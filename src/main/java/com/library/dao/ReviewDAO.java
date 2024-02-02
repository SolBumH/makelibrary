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

  public void addReview(String title, String author, String reviewContent) {
    Connection con = db.getConnection();
    PreparedStatement pstmt = null;
    String sql = "INSERT INTO reviews (title, author, review_content) VALUES (?, ?, ?)";

    try {
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, title);
      pstmt.setString(2, author);
      pstmt.setString(3, reviewContent);
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

    String sql = "SELECT title, author, review_content FROM reviews";

    try {
      pstmt = con.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        ReviewDTO review = new ReviewDTO();
        review.setTitle(rs.getString("title"));
        review.setAuthor(rs.getString("author"));
        review.setReview_content(rs.getString("review_content"));
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
