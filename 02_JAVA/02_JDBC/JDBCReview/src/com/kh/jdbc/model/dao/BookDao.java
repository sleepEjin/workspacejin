package com.kh.jdbc.model.dao;

import static com.kh.jdbc.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.jdbc.model.vo.Book;

public class BookDao {
	private Properties prop = new Properties();
	
	
	
	public BookDao() {
		super();
		try {
			prop.loadFromXML(new FileInputStream("resources/book-query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertBook(Book book, Connection conn) {
		//book추가 -> int
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertBook");
		
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setString(3, book.getPublisher());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public ArrayList<Book> selectBookList(Connection conn) {
		ResultSet rset = null;
		ArrayList<Book> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectBookList");
		
		try {
			pstmt= conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Book b = new Book();
				b.setBookId(rset.getLong("BOOK_ID"));
				b.setTitle(rset.getString("TITLE"));
				b.setAuthor(rset.getString("AUTHOR"));
				b.setPublisher(rset.getString("PUBLISHER"));
				
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return list;
	}
	
	public int updateBook(Book book, Connection conn) {
		//book추가 -> int
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateBook");
		
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(3, book.getTitle());
			pstmt.setString(1, book.getAuthor());
			pstmt.setString(2, book.getPublisher());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deleteBook(Book book, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteBook");
		
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
}
