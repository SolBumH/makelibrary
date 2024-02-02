package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.library.db.DBConnection;

public class CommentDAO {

  DBConnection db = new DBConnection();

  public void addComment(String userId, String commentText, int reviewId) {
    Connection con = db.getConnection();
    PreparedStatement pstmt = null;
    String sql = "INSERT INTO comments (user_id, comment_text, review_id) VALUES (?, ?, ?)";

    try {
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, userId);
      pstmt.setString(2, commentText);
      pstmt.setInt(3, reviewId);

      pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      // 여기에 자원 해제 코드 추가 (try-with-resources를 사용하는 것이 좋음)
      try {
        if (pstmt != null)
          pstmt.close();
        if (con != null)
          con.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
