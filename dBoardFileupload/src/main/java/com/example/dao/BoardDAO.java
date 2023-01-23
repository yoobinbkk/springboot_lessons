package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.BoardVO;

@Mapper
public interface BoardDAO {
	
	//목록보기
   List<BoardVO> getBoardList(BoardVO vo);
   
   //등록하기
   void insertBoard(BoardVO vo);
   
   //글 상세보기
   HashMap getBoard(BoardVO vo);
   
   //수정하기
   void updateBoard(BoardVO vo);
   
   //삭제하기
   void deleteBoard(BoardVO vo);
	
}

/*
 * 기본적인 구조라면,
 * 인터페이스를 구현한 클래스 BoardDAOImpl.java
 * 그 클래스 @Repository 지정
*/