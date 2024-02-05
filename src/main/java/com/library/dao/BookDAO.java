package com.library.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.library.db.DBConnection;
import com.library.dto.BookDTO;

public class BookDAO extends AbstractDAO {

	public static String api(Map<String, String> map) {
		return get(map);
	}

	private static String get(Map<String, String> requestHeaders) {
		HttpURLConnection con = connect(requestHeaders.get("apiURL"));
		try {
			con.setRequestMethod("GET");
			for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
				// System.out.println(header.getKey()); // 커넥터 아이디
				// System.out.println(header.getValue()); // 커넥터 비밀번호
				con.setRequestProperty(header.getKey(), header.getValue());
			}

			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
				return readBody(con.getInputStream());
			} else { // 오류 발생
				return readBody(con.getErrorStream());
			}
		} catch (IOException e) {
			System.out.println("API 요청과 응답 실패");
			throw new RuntimeException("API 요청과 응답 실패", e);
		} finally {
			con.disconnect();
		}
	}

	private static HttpURLConnection connect(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			return (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			System.out.println("API URL이 잘못되었습니다.");
			throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
		} catch (IOException e) {
			System.out.println("연결이 실패했습니다");
			throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
		}
	}

	private static String readBody(InputStream body) {
		InputStreamReader streamReader = new InputStreamReader(body);

		try (BufferedReader lineReader = new BufferedReader(streamReader)) {
			StringBuilder responseBody = new StringBuilder();

			String line;
			while ((line = lineReader.readLine()) != null) {
				// System.out.println(line);
				responseBody.append(line);
			}
			return responseBody.toString();
		} catch (IOException e) {
			System.out.println("API 응답을 읽는 데 실패했습니다.");
			throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
		}
	}

	public List<BookDTO> bookInfo(String str) {
		List<BookDTO> list = new ArrayList<>();

		str = str.replaceAll("\t", ""); // 검색 결과에 탭 전체 삭제

//    System.out.println(str);

		String[] passingSplit = str.split("\"items\":\\[\\{"); // 앞 잉여데이터 삭제
//    System.out.println(passingSplit.length);
//    System.out.println(passingSplit[0]);
//    System.out.println(passingSplit[1]);

		if (passingSplit.length == 1) {
			return null;
		}

		passingSplit = passingSplit[1].split("}]}"); // 뒤 잉여데이터 삭제
//    System.out.println(passingSplit[0]);
		passingSplit = passingSplit[0].split("}"); // 각 아이템별로 데이터 나누기
//    System.out.println(passingSplit[0]);

		for (int i = 0; i < passingSplit.length; i++) {
			passingSplit[i] = passingSplit[i].replace(",{", "").replace("{", "").strip(); // 괄호 삭제
//      System.out.println("passingSplit 1 : " + passingSplit[i]);
		}

		// 공백 제거 하는 for 문
//    for(int i = 0; i < passingSplit.length; i++) {
//      passingSplit[i] = passingSplit[i].strip().trim().replaceAll("\t", "");
//      System.out.println("공백제거 : " + passingSplit[i]);
//    }

		String[][] rowDataArr = new String[passingSplit.length][]; // ROW데이터를 담기위한 2차원 배열

		for (int i = 0; i < passingSplit.length; i++) {
			rowDataArr[i] = passingSplit[i].split("\",\""); // 따움표 삭제
//      System.out.println("rowDataArr : " + Arrays.toString(rowDataArr[i]));
			for (int j = 0; j < rowDataArr[i].length; j++) {
				rowDataArr[i][j] = rowDataArr[i][j].replaceAll("<b>", "").replaceAll("</b>", "")
						.replaceAll("&quot;", "").replaceAll("\"", "");
				// DB에 담을 값에서 필요 없는 HTML 삭제, 필요없는 코드 및 앞 뒤 공백 삭제
			}
		}

//    for (int i = 0; i < rowDataArr.length; i++) {
//      System.out.println("rowDataArr 2 : " + Arrays.toString(rowDataArr[i]));
//    }

		List<Map<String, String>> jsonList = new ArrayList<>(); // ROW데이터로 분리될 객체 MAP을 담을 LIST

		for (int i = 0; i < rowDataArr.length; i++) {
			Map<String, String> bookMap = new HashMap<>(); // ROW 데이터를 분리할 맵
//      String[] rowDataInfo = rowDataArr[i][0].split("\" \""); // 먼저 문장에서 데이터 끼리의 (" ")로 분리
			for (int j = 0; j < rowDataArr[i].length; j++) {
				rowDataArr[i][j] = rowDataArr[i][j].isBlank() ? "null" : rowDataArr[i][j];
//        String[] rowDataInfo2 = rowDataArr[i][j].split("\":\""); // 분리된 데이터에서 key, value 분리
				String[] rowDataInfo2 = new String[2];
				rowDataInfo2[0] = rowDataArr[i][j].substring(0, rowDataArr[i][j].indexOf(":"));
				rowDataInfo2[1] = rowDataArr[i][j].substring(rowDataArr[i][j].lastIndexOf(":") + 1);
				bookMap.put(rowDataInfo2[0].replaceAll("\"", ""),
						rowDataInfo2[1].replaceAll("\"", "").replaceAll("\\\\", "")); // 따옴표
																						// 없애며
																						// key,
																						// value
																						// put
			}
			jsonList.add(bookMap);
//      System.out.println(jsonList.get(i));
		}

		for (int i = 0; i < jsonList.size(); i++) {
			BookDTO dto = new BookDTO();
			dto.setTitle(jsonList.get(i).get("title"));
			dto.setAuthor(jsonList.get(i).get("author"));
			dto.setImage("https:" + jsonList.get(i).get("image"));
			dto.setLink("https:" + jsonList.get(i).get("link"));
			dto.setIsbn(jsonList.get(i).get("isbn"));
			dto.setPublisher(jsonList.get(i).get("publisher"));
			list.add(dto);
		}
		return list;
	}

	public List<BookDTO> bookList() {
		List<BookDTO> list = new ArrayList<BookDTO>();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT bno, bname, bpub, bwrite, brent FROM book " + "LIMIT 0, 10";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BookDTO e = new BookDTO();
				e.setBno(rs.getInt("bno"));
				e.setBname(rs.getString("bname"));
				e.setBwrite(rs.getString("bwrite"));
				e.setBpub(rs.getString("bpub"));
				e.setBrent(rs.getString("brent"));
				list.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, con);
		}
		return list;
	}
	
	  //효진 추가
	  public List<BookDTO> bookRentList() {
	       List<BookDTO> list = new ArrayList<BookDTO>();
	       Connection con = db.getConnection();
	       PreparedStatement pstmt = null;
	       ResultSet rs = null;
	       String sql = "SELECT * FROM rentlist";

	       try {
	         pstmt = con.prepareStatement(sql);
	         rs = pstmt.executeQuery();

	         while (rs.next()) {
	           BookDTO e = new BookDTO();
	           e.setTitle(rs.getString("btitle"));
	           e.setMno(rs.getInt("mno"));
	           e.setMid(rs.getString("mid"));
	           e.setRtdate(rs.getString("rtdate"));
	           e.setRtenum(rs.getString("rtenum"));
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
