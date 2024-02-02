package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.library.dto.MemberDTO;

public class MemberDAO extends AbstractDAO {

	//로그인
  public MemberDTO login(MemberDTO dto) {

    Connection con = db.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = "SELECT count(*) as count, mname FROM member WHERE mid=? AND mpw=?";

    try {
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, dto.getMid());
      pstmt.setString(2, dto.getMpw());

      rs = pstmt.executeQuery();
      if (rs.next()) {
        dto.setCount(rs.getInt("count"));
        dto.setMname(rs.getNString("mname"));
      }
    } catch (SQLException e) {
      e.printStackTrace();

    } finally {
      close(rs, pstmt, con);
    }
    return dto;
  }

  //회원가입
  public int join(MemberDTO dto) {

    int result = 0;
    Connection con = db.getConnection();
    PreparedStatement pstmt = null;
    String sql = "INSERT INTO member(mid, mpw, mname) VALUES(?, ?, ?)";

    try {
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, dto.getMid());
      pstmt.setString(2, dto.getMpw());
      pstmt.setString(3, dto.getMname());

      result = pstmt.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      close(null, pstmt, con);
    }
    return result;
  }

  //아이디검사
  public int idCheck(MemberDTO dto) {
    int result = 1;

    Connection con = db.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = "SELECT COUNT(*) FROM member WHERE mid=?";

    try {
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, dto.getMid());
      rs = pstmt.executeQuery();
      if (rs.next()) {
        result = rs.getInt(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      close(rs, pstmt, con);
    }
    return result;
  }

  //마이페이지
  public MemberDTO info(MemberDTO dto) {

    Connection con = db.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = "SELECT * FROM member WHERE mid=?";

    try {
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, dto.getMid());
      rs = pstmt.executeQuery();

      if (rs.next()) {
        dto.setNo(rs.getInt("no"));
        dto.setMname(rs.getString("mname"));
        dto.setMpw(rs.getString("mpw"));
        dto.setMdate(rs.getString("mdate"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      close(rs, pstmt, con);
    }
    return dto;
  }
}
