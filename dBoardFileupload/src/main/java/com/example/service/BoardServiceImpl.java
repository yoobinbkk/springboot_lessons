package com.example.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.BoardDAO;
import com.example.dao.FileDAO;
import com.example.domain.BoardVO;
import com.example.domain.FileVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	@Autowired
	private FileDAO fileDAO;
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		List<BoardVO> list = boardDAO.getBoardList(vo);
		System.out.println("[BoardService] 리스트 갯수 : " + list.size());
		return list;
	}
	
	//등록하기
   @Transactional
   public void insertBoard(BoardVO bvo, FileVO fvo) {
      if(fvo!=null) {
    	  fileDAO.insertFile(fvo);
    	  bvo.setFileId(fileDAO.selectId());
      }
      boardDAO.insertBoard(bvo);
      System.out.println("[BoardService] 등록하기 :"+ bvo);
      
   }

   //글 상세보기
   @Override
   public HashMap getBoard(BoardVO vo) {
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
