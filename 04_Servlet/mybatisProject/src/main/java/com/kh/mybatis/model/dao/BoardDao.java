package com.kh.mybatis.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.vo.PageInfo;
import com.kh.mybatis.model.vo.Board;

public class BoardDao {
	public int selectAllBoardCount(SqlSession sqlSession) {
		return sqlSession.selectOne("BoardMapper.selectAllBoardCount");
	}
	
	public ArrayList<Board> selectAllBoard(SqlSession sqlSession, PageInfo pi) {
		//mybatis에서 자체적으로 페이징처리를 위해 RowBound라는 class를 제공
		//offset : 몇 개의 게시글을 건너뛰고 조회할 것인가
		//boardLimit : 몇 개의 게시글을 가지고 올 것인가?
		
		//한페이지 보여줄 boardLimit이 10이라고 가정
		//1페이지 -> 0개 건너뜀
		//2페이지 -> 10개 건너뜀
		//3페이지 -> 20개 건너뜀
		
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		
		ArrayList<Board> list = (ArrayList)sqlSession.selectList("BoardMapper.selectAllBoard", null, rowBounds);
		return list;
	}
}