package com.kh.jsp.model.dao;

import static com.kh.jsp.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.jsp.common.JDBCTemplate;
import com.kh.jsp.model.vo.Board;

public class BoardDao {
	private Properties prop = new Properties();

	public BoardDao() {
		super();
	
	String path = JDBCTemplate.class.getResource("/db/sql/member-mapper.xml").getPath();
	
	try {
		prop.loadFromXML(new FileInputStream(path));
	} catch (IOException e) {
		e.printStackTrace();
	}
}
	
	public int insertBoard(Board b, Connection conn) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b.getBoardType());
			pstmt.setInt(2, b.getCategoryNo());
			pstmt.setString(3, b.getBoardTitle());
			pstmt.setInt(4, b.getBoardWriter());
			pstmt.setString(5, b.getBoardContent());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
}
