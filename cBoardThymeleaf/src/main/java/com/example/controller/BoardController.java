package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.BoardVO;
import com.example.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/{step}")
	public String viewPage(@PathVariable String step) {
		return "board/"+step;
	}
	
	@RequestMapping("/getBoardList")
	public void getBoardList(Model m) {
		BoardVO vo = new BoardVO();
		List<BoardVO> list = boardService.getBoardList(vo);
		System.out.println("[Controller:getBoardList 요청] 결과갯수 : " + list.size());
		
		m.addAttribute("boardList", list);
	}
	
	//등록하기
	   @RequestMapping("/saveBoard")
	   public String insertBoard(BoardVO vo) {
	      boardService.insertBoard(vo);
	      System.out.println("[Controller:insertBoard 요청] " + vo);
	      return "redirect:getBoardList";
	   }
	   
	   //글 상세보기
	   @RequestMapping("/getBoard")
	   public void getBoard(BoardVO vo, Model m) {
		   System.out.println("pass");
	      BoardVO result = boardService.getBoard(vo);
	      m.addAttribute("board", result);      
	      
	   }
	   
	   //수정하기
	   @RequestMapping("/updateBoard")
	   public String updateBoard(BoardVO vo) {
	      boardService.updateBoard(vo);
	      System.out.println("[Controller:updateBoard 요청] " + vo);
	      return "redirect:getBoardList";
	   }
	   
	   //삭제하기
	   @RequestMapping("/deleteBoard")
	   public String deleteBoard(BoardVO vo) {
	      boardService.deleteBoard(vo);
	      System.out.println("[Controller:deleteBoard 요청] " + vo);
	      return "redirect:getBoardList";
	   }
	
	
}
