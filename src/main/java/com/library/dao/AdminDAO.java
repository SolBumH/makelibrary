package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.library.dto.MemberDTO;
import com.library.dto.ReviewDTO;

public class AdminDAO extends AbstractDAO {

  // 계정관리
  public List<MemberDTO> memberList() {
    List<MemberDTO> list = new ArrayList<MemberDTO>();
    Connection con = db.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = "SELECT mno, mid, mname, mdate, mgrade FROM member";

    try {
      pstmt = con.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        MemberDTO e = new MemberDTO();
        e.setMno(rs.getInt("mno"));
        e.setMid(rs.getString("mid"));
        e.setMname(rs.getString("mname"));
        e.setMdate(rs.getString("mdate"));
        e.setMgrade(rs.getInt("mgrade"));
        list.add(e);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      close(rs, pstmt, con);
    }
    return list;
  }

  // 계정별 대출관리

  // 리뷰관리
  public List<ReviewDTO> reviewList() {
    List<ReviewDTO> list = new ArrayList<ReviewDTO>();
    Connection con = db.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = "SELECT * FROM reviews";

    try {
      pstmt = con.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        ReviewDTO e = new ReviewDTO();
        e.setRno(rs.getInt("rno"));
        e.setMno(rs.getInt("mno"));
        e.setRtitle(rs.getString("rtitle"));
        e.setRauthor(rs.getString("rauthor"));
        e.setRcontent(rs.getString("rcontent"));
        e.setRdate(rs.getDate("rdate"));
        list.add(e);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      close(rs, pstmt, con);
    }
    return list;
  }

  // 계정 등급 관리
  public List<MemberDTO> memberList(int grade) {

    List<MemberDTO> list = new ArrayList<MemberDTO>();
    Connection con = db.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = "SELECT mno, mid, mname, mdate, mgrade FROM member WHERE mgrade=?";

    try {
      pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, grade);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        MemberDTO e = new MemberDTO();
        e.setMno(rs.getInt("mno"));
        e.setMid(rs.getString("mid"));
        e.setMname(rs.getString("mname"));
        e.setMdate(rs.getString("mdate"));
        e.setMgrade(rs.getInt("mgrade"));
        list.add(e);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      close(rs, pstmt, con);
    }

    return list;
  }

  public List<Map<String, Object>> allRent() {
    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    Connection con = db.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = "SELECT btitle, mid, rtenum, rtdate FROM rentlist " + "LIMIT 0, 10";

    try {
      pstmt = con.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        Map<String, Object> e = new HashMap<String, Object>();
        e.put("btitle", rs.getString("btitle"));
        e.put("mid", rs.getString("mid"));
        e.put("rtenum", rs.getString("rtenum"));
        e.put("rtdate", rs.getString("rtdate"));
        list.add(e);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      close(rs, pstmt, con);
    }
    return list;
  }
}
