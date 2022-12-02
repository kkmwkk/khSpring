package com.korea.myboard.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.korea.myboard.dao.BoardDAO;
import com.korea.myboard.vo.BoardVO;
import com.korea.myboard.vo.SearchCriteria;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO dao;
	
	// 게시글 작성
	@Override
	public void write(BoardVO boardVO) throws Exception {
		dao.write(boardVO);

	}
	
	// 게시글 목록 조회
	@Override
	public List<BoardVO> list(SearchCriteria scri) throws Exception {
		
		return dao.list(scri);
	}
	
	// 게시글 총 개수
	@Override
	public int listCount(SearchCriteria scri) throws Exception {
		
		return dao.listCount(scri);
	}
	
	// 게시글 조회
	@Override
	public BoardVO read(int bno) throws Exception {
		
		return dao.read(bno);
	}
	
	// 게시글 수정
	@Override
	public void update(BoardVO boardVO) throws Exception {
		dao.update(boardVO);

	}

	
	// 게시글 삭제
	@Override
	public void delete(int bno) throws Exception {
		dao.delete(bno);
	}

}