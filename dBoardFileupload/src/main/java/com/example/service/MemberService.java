package com.example.service;

import com.example.domain.MemberVO;

public interface MemberService {
	
	// 회원가입
	void insertMember(MemberVO vo);
	
	// 로그인 확인
	String loginCheck(MemberVO vo);

}
