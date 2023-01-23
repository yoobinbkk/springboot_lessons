package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.MemberVO;
import com.example.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/{step}")
	public String viewPage2(@PathVariable String step) {
		return "/member/"+step;
	}
	
	@RequestMapping("/insertMember")
	public String insertMember(MemberVO vo) {
		memberService.insertMember(vo);
		return "/member/loginForm";
	}
	
	@RequestMapping("/loginCheck")
	public String loginCheck(MemberVO vo, Model m, HttpSession session) {
		String result = memberService.loginCheck(vo);
		if (result != null || result != "") {
			m.addAttribute("member", result);
			session.setAttribute("member", result);
			return "/member/loginSuccess";
		} else {
			return "/member/loginForm";
		}
	}
	
	@RequestMapping("/logOut")
	public String logOut(HttpSession session) {
		session.removeAttribute("member");
		return "/member/loginForm";
	}
	
}
