package com.kh.jdbc.controller;

import java.util.List;

import com.kh.jdbc.model.vo.Book;
import com.kh.jdbc.service.BookService;
import com.kh.jdbc.view.BookMenu;

public class BookController {
	private BookService bookService;
	
	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}

	public void insertBook(String title,String author,String publisher) {
		Book b = new Book(null, title, author, publisher);
		int result = bookService.insertBook(b);
		
		if(result > 0) {
			new BookMenu().displaySuccess("도서 등록");
		} else {
			new BookMenu().displayFail("도서 등록 실패");
		}
	}
	
	public void selectBookAll() {
		List<Book> list = bookService.selectBookList();
		
		if(list.isEmpty()) {
			new BookMenu().displayNoData("회원목록 조회결과가 없습니다.");
		}else {
			new BookMenu().displayList(list, "도서 목록");
		}
	}
	
	public void updateBook(String title,String author,String publisher) {
		Book b = new Book(null, title, author, publisher);
		int result = bookService.updateBook(b);
		
		if(result > 0) {
			new BookMenu().displaySuccess("도서 정보 수정 완료");
		} else {
			new BookMenu().displayFail("도서 수정 실패");
		}
	}
	
	public void deleteBook(String title,String author) {
		Book b = new Book(title, author);
		int result = bookService.deleteBook(b);
		
		if(result > 0) {
			new BookMenu().displaySuccess("도서 삭제 완료");
		} else {
			new BookMenu().displayFail("도서 삭제 실패");
		}
	}
}
