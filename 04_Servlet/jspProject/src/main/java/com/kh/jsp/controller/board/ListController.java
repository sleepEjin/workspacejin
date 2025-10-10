package com.kh.jsp.controller.board;

import java.io.IOException;

import com.kh.jsp.model.vo.Board;
import com.kh.jsp.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListController
 */
@WebServlet("/list.me")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//board목록을 가져와서 응답페이지로 전달
		
		int boardType = Integer.parseInt(request.getParameter("boardType"));
		int categoryNo = Integer.parseInt(request.getParameter("categoryNo"));
		String boardTitle = request.getParameter("boardTitle");
		int boardWriter = Integer.parseInt(request.getParameter("boardWriter"));
		String boardContent =request.getParameter("boardContent");
		
		Board b = Board.insertBoard(boardType, categoryNo, boardTitle, boardWriter, boardContent);
		
		int result = new BoardService().insertBoard(b);
		
		if(result > 0) { //가입성공
			request.getSession().setAttribute("alertMsg", "성공적으로 게시글 작성을 완료하였습니다.");
			
			response.sendRedirect(request.getContextPath());
		} else { //가입실패
			request.setAttribute("errorMsg", "게시글 작성에 실패하였습니다.");
			request.getRequestDispatcher("views/common/error.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
