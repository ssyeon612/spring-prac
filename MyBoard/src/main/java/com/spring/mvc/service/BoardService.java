package com.spring.mvc.service;

import java.util.List;

import com.spring.mvc.model.dto.BoardDto;

public interface BoardService {
	
	public List<BoardDto> selectList();
	public BoardDto selectOne(int myno);
	public int insert(BoardDto dto);
	public int update(BoardDto dto);
	public int delete(int myno);

}
