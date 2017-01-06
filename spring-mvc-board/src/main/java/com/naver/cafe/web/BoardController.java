package com.naver.cafe.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.naver.cafe.service.Board;
import com.naver.cafe.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	@RequestMapping(value="/board/boardList")
	public String boardList(Model model,
			@RequestParam(value="currentPage", defaultValue="1") int currentPage){
		Map<String, Object> returnMap = boardService.getBoardListPerCurrentPage(currentPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalRowCount", returnMap.get("totalRowCount"));
		model.addAttribute("lastPage", returnMap.get("lastPage"));
		model.addAttribute("list", returnMap.get("list"));
		
		return "/board/boardList";
	}
	
	@RequestMapping(value="/board/boardAdd", method=RequestMethod.GET)
	public String boardAdd(){
		return "/board/boardAdd"; //forward
		
	}
	@RequestMapping(value="/board/boardAdd", method=RequestMethod.POST)
	public String boardAdd(Board board) {
							//command 객체 s
		System.out.println(board);
		boardService.addBoard(board);
		return "redirect:/board/boardList";
	}
	@RequestMapping(value="/board/boardView", method=RequestMethod.GET)
	public String boardView(Model model,@RequestParam(value="boardNo") int boardNo){
		model.addAttribute("board", boardService.selectBoardByKey(boardNo));
		return "/board/boardView";
	}
	@RequestMapping(value="/board/boardRemove", method=RequestMethod.GET)
	public String boardDelete(Model model, 
							@RequestParam(value="boardNo") int boardNo){
		model.addAttribute("boardNo", boardNo);
		return "/board/boardRemove";
		
	}
	@RequestMapping(value="board/boardRemove", method=RequestMethod.POST)
	public String boardDelete(Board board){
		System.out.println(board);
		boardService.deleteBoard(board);
		return "redirect:/board/boardList";
	}
	
	@RequestMapping(value="board/boardModify", method=RequestMethod.GET)
	public String boardUpdate(Model model, @RequestParam(value="boardNo") int boardNo){
		
		model.addAttribute("board", boardService.selectBoardByKey(boardNo));
		
		return "/board/boardModify";
		
	}
	@RequestMapping(value="board/boardModify", method=RequestMethod.POST)
	public String boardUpdate(Model model, Board board){
		if(boardService.updateBoard(board) != 1){
			model.addAttribute("board", board);
			return "/board/boardModify";
		}
		return "redirect:/board/boardList";
	}
}
