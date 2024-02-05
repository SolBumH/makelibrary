package com.library.dao;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.library.dto.MemberDTO;
import com.library.dto.ReviewDTO;

public class AdminDAO extends AbstractDAO {

	//계정관리
	public List<MemberDTO> memberList() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT mno, mid, mname, mdate FROM member";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberDTO e = new MemberDTO();
				e.setMno(rs.getInt("mno"));
				e.setMid(rs.getString("mid"));
				e.setMname(rs.getString("mname"));
				e.setMdate(rs.getString("mdate"));
				list.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs, pstmt, con);
		}
		
		return list;
	}
	

	//계정별 대출관리
	
	
	

	//리뷰관리
	public List<ReviewDTO> reviewList(){
		List<ReviewDTO> list = new ArrayList<ReviewDTO>();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT reviews_id, reviews_title, reviews_author, reviews_reviews_content";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				ReviewDTO e = new ReviewDTO();
				e.setId(rs.getInt("id"));
				e.setTitle(rs.getString("title"));
				e.setAuthor(rs.getString("author"));
				e.setReview_content(rs.getString("reviews_content"));
				list.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs, pstmt, con);
		}
		return list;
	}
	
	
}
