package com.naver.cafe.service;


import java.util.Map;

public interface BoardService {
		int addBoard(Board board);
		Map<String,Object> getBoardListPerCurrentPage(int currentPage); 
		Board selectBoardByKey(int boardNo);
		int deleteBoard(Board board);
		int updateBoard(Board board);
		
	}


