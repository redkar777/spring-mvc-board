package com.naver.cafe.service;

import java.util.List;
import java.util.Map;

public interface BoardDao {
	public int insertBoard(Board board);
	public int selectTotalBoardCount();
	List<Board> selectBoardListPerPage(Map<String, Integer> map);
	public Board selectBoardByKey(int boardNo);
	public int deleteBoard(Board board);
	public int updateBoard(Board board);
}
