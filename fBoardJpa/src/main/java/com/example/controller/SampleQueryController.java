package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.BoardVO;
import com.example.persistence.SampleQueryRepository;

@Controller
public class SampleQueryController {
	
	@Autowired
	private SampleQueryRepository repo;
	
	@RequestMapping("/sampleQuery")
	public String sampleQuery(Model m) {
		// m.addAttribute("boardList", repo.findBoardVOByTitle("ggg"));
		// m.addAttribute("boardList", repo.findBoardVOByTitleContaining("g"));
		Pageable paging = PageRequest.of(0, 2);
		// m.addAttribute("boardList", repo.findAll(paging));
		m.addAttribute("boardList", repo.findBoardVOByTitleContaining("2", paging));
		return "board/getBoardList";
	}
	
}
