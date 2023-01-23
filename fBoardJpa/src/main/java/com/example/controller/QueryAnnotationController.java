package com.example.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.persistence.QueryAnnoRepository;

@Controller
public class QueryAnnotationController {
	
	@Autowired
	private QueryAnnoRepository repo;
	
	@RequestMapping("queryAnno")
	public String queryAnno(Model m) {
		List<Object[]> result = repo.queryAnnotation4();
		m.addAttribute("boardList", result);
		return "board/getBoardList2";
	}
	
}
