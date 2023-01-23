package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.BoardVO;
import com.example.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardRepository boardRepo;
	
	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return (List<BoardVO>)boardRepo.findAll();
	}

	@Override
	public void saveBoard(BoardVO vo) {
		boardRepo.save(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardRepo.findById(vo.getSeq()).get();
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardRepo.deleteById(vo.getSeq());
	}
	
	public void updateBoard(BoardVO vo) {
		BoardVO result = boardRepo.findById(vo.getSeq()).get();
		result.setTitle(vo.getTitle());
		result.setContent(vo.getContent());
		
		boardRepo.save(result);
	}

}
