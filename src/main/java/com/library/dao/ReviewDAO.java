package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.library.db.DBConnection;
import com.library.dto.ReviewDTO;

public class ReviewDAO extends AbstractDAO {

	DBConnection db = new DBConnection();

//  public void makeReview(int mno, String rtitle, String rauthor, String rcontent) {
	public void makeReview(ReviewDTO dto) {

		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO reviews (mno, rno, rtitle, rauthor, rcontent, rdate) VALUES ((select mno from member where mid=?), ?, ?, ?,?, CURRENT_TIMESTAMP)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getMno());
			pstmt.setInt(2, dto.getRno());
			pstmt.setString(3, dto.getRtitle());
			pstmt.setString(4, dto.getRauthor());
			pstmt.setString(5, dto.getRcontent());
			pstmt.executeUpdate();

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

		String sql = "SELECT mno, rno, rtitle, rauthor, rcontent, rdate FROM reviews";
		System.out.println("dao오냐");
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ReviewDTO review = new ReviewDTO();
				review.setRno(rs.getInt("rno"));
				review.setMno(rs.getInt("mno"));
				review.setRtitle(rs.getString("rtitle"));
				review.setRauthor(rs.getString("rauthor"));
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