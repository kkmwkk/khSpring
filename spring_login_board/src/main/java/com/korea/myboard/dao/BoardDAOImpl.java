package com.korea.myboard.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.korea.myboard.vo.BoardVO;
import com.korea.myboard.vo.SearchCriteria;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	
	// 게시글 작성
	@Override
	public void write(BoardVO boardVO) throws Exception {
		sqlSession.insert("boardMapper.insert", boardVO);
	}
	
	// 게시물 묵록
	@Override
	public List<BoardVO> list(SearchCriteria scri) throws Exception {
		return sqlSession.selectList("boardMapper.listPage", scri);
	}

	// selectList = 쿼리 결과 List<E> 로 반환 
	// 결과가 없을 때에는 빈 List를 반환(NULL을 반환하지 않는다.)
	
	
	// 게시물 총 갯수
	@Override
	public int listCount(SearchCriteria scri) throws Exception {
		return sqlSession.selectOne("boardMapper.listCount", scri);
	}
	
	// selectOne = 쿼리 결과가 없으면 NULL을 반환
	// 쿼리 결과로 레코드 하나만 가져온다.
	// 다수 레코드가 있을 때 TooManyResultException 발생
	
	
	// 게시물 조회
	@Override
	public BoardVO read(int bno) throws Exception {
		return sqlSession.selectOne("boardMapper.read", bno);
	}
	
	// 게시물 수정
	@Override
	public void update(BoardVO boardVO) throws Exception {
		sqlSession.update("boardMapper.update", boardVO);

	}

	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete("boardMapper.delete", bno);

	}

}
