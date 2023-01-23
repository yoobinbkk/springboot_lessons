package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.BoardVO;

@Mapper
public interface BoardDAO {
	
	public List<BoardVO> getBoardList(BoardVO vo);
	
}

/*
 * 기본적인 구조라면,
 * 인터페이스를 구현한 클래스 BoardDAOImpl.java
 * 그 클래스 @Repository 지정
*/