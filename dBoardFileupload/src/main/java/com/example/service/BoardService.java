package com.example.service;

import java.util.HashMap;
import java.util.List;

import com.example.domain.BoardVO;
import com.example.domain.FileVO;

public interface BoardService {
	
	//목록보기
   List<BoardVO> getBoardList(BoardVO vo);
   
   //등록하기
   void insertBoard(BoardVO bvo, FileVO fvo);
   
   //글 상세보기
   HashMap getBoard(BoardVO vo);
   
   //수정하기
   void updateBoard(BoardVO vo);
   
   //삭제하기
   void deleteBoard(BoardVO vo);
	
}
