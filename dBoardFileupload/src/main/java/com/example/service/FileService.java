package com.example.service;

import com.example.domain.FileVO;

public interface FileService {
	
	// 등록하기
	void insertFile(FileVO vo);
	
	// 아이디 찾기
	long selectId();
	
	// 파일 찾기
	FileVO selectFile(FileVO vo);

}
