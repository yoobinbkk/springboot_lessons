package com.example.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.FileVO;

@Mapper
public interface FileDAO {
	
	// 등록하기
	void insertFile(FileVO vo);
	
	// 아이디 찾기
	long selectId();
	
	// 파일 찾기
	FileVO selectFile(FileVO vo);
	
}
