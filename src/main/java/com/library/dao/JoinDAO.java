package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.library.db.DBConnection;

public class JoinDAO {

  DBConnection db = new DBConnection();

  public void join(String id, String pw, String date) {
    Connection con = db.getConnection();
    PreparedStatement pstmt = null;
    String sql = "SELECT * FROM member";

    try {
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, id);
      pstmt.setString(2, pw);
      pstmt.setString(3, date);

      pstmt.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
}
