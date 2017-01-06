package com.naver.cafe.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public int addBoard(Board board) {
		// TODO Auto-generated method stub
		return boardDao.insertBoard(board);
	}

	@Override
	public Map<String, Object> getBoardListPerCurrentPage(int currentPage) {
		// pagePerRow, beginRow 먼저구하고
		
		int pagePerRow = 10;
		int beginRow = (currentPage-1)*pagePerRow;
		// totalCount
		int totalRowCount = boardDao.selectTotalBoardCount();
		// lastPage
		int lastPage = totalRowCount/pagePerRow;
        if(totalRowCount%pagePerRow != 0) {
            lastPage++;
        }

	
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("beginRow", beginRow);
        map.put("pagePerRow", pagePerRow);
		List<Board> list = boardDao.selectBoardListPerPage(map);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("totalRowCount", totalRowCount);
		returnMap.put("lastPage", lastPage);
		returnMap.put("list", list);
		return returnMap;
	}

	@Override
	public Board selectBoardByKey(int boardNo) {
		return boardDao.selectBoardByKey(boardNo);
	}

	@Override
	public int deleteBoard(Board board) {
		// TODO Auto-generated method stub
		return boardDao.deleteBoard(board);
	}

	@Override
	public int updateBoard(Board board) {
		// TODO Auto-generated method stub
		
		return boardDao.updateBoard(board);
	}

}
