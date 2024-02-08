package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.library.db.DBConnection;
import com.library.dto.BookDTO;
import com.library.dto.MemberDTO;
import com.library.dto.ReviewDTO;

public class ReviewDAO extends AbstractDAO {

	DBConnection db = new DBConnection();

//  public void makeReview(int mno, String rtitle, String rauthor, String rcontent) {
	public void makeReview(ReviewDTO dto) {

		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO reviews (mno, rtitle, rcontent) VALUES ((select mno from member where mid=? ORDER BY rno DESC), ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMid());
			pstmt.setString(2, dto.getRtitle());
			pstmt.setString(3, dto.getRcontent());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, pstmt, con);
		}
	}

	public List<ReviewDTO> showReviews() {
		List<ReviewDTO> reviews = new ArrayList<>();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT mno, rno, rtitle, rcontent, rdate FROM reviews";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ReviewDTO review = new ReviewDTO();
				review.setRno(rs.getInt("rno"));
				review.setMno(rs.getInt("mno"));
				review.setRtitle(rs.getString("rtitle"));
				review.setRcontent(rs.getString("rcontent"));
				review.setRdate(rs.getDate("rdate"));
				reviews.add(review);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, con);
		}
		return reviews;
	}

	public MemberDTO Bookreview(MemberDTO dto) {

		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member WHERE mid=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMid());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto.setMno(rs.getInt("mno"));
				dto.setMname(rs.getString("mname"));
				dto.setMpw(rs.getString("mpw"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, con);
		}
		return dto;
	}

	public int delete(BookDTO dto) {
		int result = 0;
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		String sql = "UPDATE reviews SET rdel='0' WHERE mno=? AND mid=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getMno());
			pstmt.setString(1, dto.getMid());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(null, pstmt, conn);
		}

		return result;
	}

	public List<ReviewDTO> myReviews(String mid) {
		List<ReviewDTO> reviews = new ArrayList<>();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT mno, rno, rtitle, rcontent, rdate FROM reviews WHERE mno=(SELECT mno from member WHERE mid=?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ReviewDTO review = new ReviewDTO();
				review.setRno(rs.getInt("rno"));
				review.setMno(rs.getInt("mno"));
				review.setRtitle(rs.getString("rtitle"));
				review.setRcontent(rs.getString("rcontent"));
				review.setRdate(rs.getDate("rdate"));
				reviews.add(review);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, con);
		}
		return reviews;
	}
}
