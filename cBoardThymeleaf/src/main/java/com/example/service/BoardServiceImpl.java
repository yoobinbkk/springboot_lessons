package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BoardDAO;
import com.example.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		List<BoardVO> list = boardDAO.getBoardList(vo);
		System.out.println("[BoardService] 리스트 갯수 : " + list.size());
		return list;
	}
	
	//등록하기
   @Override
   public void insertBoard(BoardVO vo) {
      boardDAO.insertBoard(vo);
      System.out.println("[BoardService] 등록하기 :"+ vo);
      
   }

   //글 상세보기
   @Override
   public BoardVO getBoard(BoardVO vo) {
      
      return boardDAO.getBoard(vo);
   }
   
   //수정하기
   @Override
   public void updateBoard(BoardVO vo) {
      boardDAO.updateBoard(vo);
      System.out.println("[BoardService] 수정하기 :"+ vo);
      
      
   }
   
   //삭제하기
   @Override
   public void deleteBoard(BoardVO vo) {
      boardDAO.deleteBoard(vo);
      System.out.println("[BoardService] 삭제하기 :"+ vo);
      
   }

}
