package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.MemberDAO;
import com.example.domain.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;

	// 회원가입
	public void insertMember(MemberVO vo) {
		memberDAO.insertMember(vo);
	}

	// 로그인 확인
	public String loginCheck(MemberVO vo) {
		return memberDAO.loginCheck(vo);
	}

}
