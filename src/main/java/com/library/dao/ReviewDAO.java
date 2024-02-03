package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.library.db.DBConnection;
import com.library.dto.ReviewDTO;

public class ReviewDAO extends AbstractDAO{

  DBConnection db = new DBConnection();

  public void addReview(int mno, String rtitle, String rauthor, String rcontent) {
      Connection con = db.getConnection();
      PreparedStatement pstmt = null;
      String sql = "INSERT INTO reviews (mno, rtitle, rauthor, rcontent, rdate) VALUES (?, ?, ?, ?, CURRENT_TIMESTAMP)";

      try {
          pstmt = con.prepareStatement(sql);
          pstmt.setInt(1, mno);
          pstmt.setString(2, rtitle);
          pstmt.setString(3, rauthor);
          pstmt.setString(4, rcontent);
          pstmt.executeUpdate();
      } catch (SQLException e) {
          e.printStackTrace();
      } finally {
          close(null, pstmt, con);
      }
  }

  public List<ReviewDTO> getReviews() {
      List<ReviewDTO> reviews = new ArrayList<>();
      Connection con = db.getConnection();
      PreparedStatement pstmt = null;
      ResultSet rs = null;

      String sql = "SELECT mno, rtitle, rauthor, rcontent, rdate FROM reviews";

      try {
          pstmt = con.prepareStatement(sql);
          rs = pstmt.executeQuery();

          while (rs.next()) {
              ReviewDTO review = new ReviewDTO();
              review.setMno(rs.getInt("mno"));
              review.setRtitle(rs.getString("rtitle"));
              review.setRauthor(rs.getString("rauthor"));
              review.setRcontent(rs.getString("rcontent"));
              review.setRdate(rs.getDate("rdate")); // 날짜 정보 추가
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