package com.korea.myboard.service;

import java.util.List;

import com.korea.myboard.vo.BoardVO;
import com.korea.myboard.vo.SearchCriteria;

public interface BoardService {
	
	// 게시글 작성
	public void write(BoardVO boardVo) throws Exception;

	public List<BoardVO> list(SearchCriteria scri) throws Exception;
	
	public int listCount(SearchCriteria scri) throws Exception;
	
	public BoardVO read(int bno) throws Exception;
	
	public void update(BoardVO boardVO) throws Exception;
	
	public void delete(int bno) throws Exception;
}
