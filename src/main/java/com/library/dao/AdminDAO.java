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
import com.library.util.Util;

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

	// 레벨업
	public int memberUpdate(int grade, int mno) {

		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		String sql = "UPDATE member SET mgrade=? WHERE mno=?";
		int result = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, grade);
			pstmt.setInt(2, mno);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, pstmt, con);
		}
		return result;
	}


	//전체 대출 리스트
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
	
	// 계정별 대출관리

	// 게시글 상태 변경
	public void changeReviewDel(String rno, String del) {
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		String sql = "update reviews set rdel=? where rno=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, del);
			pstmt.setInt(2, Util.str2Int(rno));
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, pstmt, conn);
		}
	}

	// 리뷰관리
	public List<ReviewDTO> reviewList() {
		List<ReviewDTO> list = new ArrayList<ReviewDTO>();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM reviews order by rdate desc";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ReviewDTO e = new ReviewDTO();
				e.setRno(rs.getInt("rno"));
				e.setMno(rs.getInt("mno"));
				e.setRtitle(rs.getString("rtitle"));
				e.setRcontent(rs.getString("rcontent"));
				e.setRdate(rs.getDate("rdate"));
				e.setRdel(rs.getString("rdel"));
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
