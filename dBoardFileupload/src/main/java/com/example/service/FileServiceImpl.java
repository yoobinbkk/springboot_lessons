package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.FileDAO;
import com.example.domain.FileVO;

@Service
public class FileServiceImpl implements FileService {
	
	@Autowired
	private FileDAO fileDAO;

	// 등록하기
	public void insertFile(FileVO vo) {
		fileDAO.insertFile(vo);
	}

	// 아이디 찾기
	public long selectId() {
		return fileDAO.selectId();
	}

	// 파일 찾기
	public FileVO selectFile(FileVO vo) {
		return fileDAO.selectFile(vo);
	}

}
