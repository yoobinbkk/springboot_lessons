package com.example.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.MemberVO;

@Mapper
public interface MemberDAO {
	
	// 회원가입
	void insertMember(MemberVO vo);
	
	// 로그인 확인
	String loginCheck(MemberVO vo);

}
