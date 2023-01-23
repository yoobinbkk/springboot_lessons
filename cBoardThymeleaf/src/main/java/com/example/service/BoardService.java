package com.example.service;

import java.util.List;

import com.example.domain.BoardVO;

public interface BoardService {
	
	//목록보기
   List<BoardVO> getBoardList(BoardVO vo);
   
   //등록하기
   void insertBoard(BoardVO vo);
   
   //글 상세보기
   BoardVO getBoard(BoardVO vo);
   
   //수정하기
   void updateBoard(BoardVO vo);
   
   //삭제하기
   void deleteBoard(BoardVO vo);
	
}
