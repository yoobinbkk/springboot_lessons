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
	
	@RequestMapping("/insertBoard")
	public void insertBoard() {
		
	}
	
	@RequestMapping("/getBoardList")
	public void getBoardList(Model m) {
		BoardVO vo = new BoardVO();
		List<BoardVO> list = boardService.getBoardList(vo);
		System.out.println("[Controller:getBoardList 요청] 결과갯수 : " + list.size());
		
		m.addAttribute("boardList", list);
	}
	
	
	
}
