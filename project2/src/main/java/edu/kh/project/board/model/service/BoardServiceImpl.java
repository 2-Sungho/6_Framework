package edu.kh.project.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.board.model.dao.BoardDAO;
import edu.kh.project.board.model.vo.Board;
import edu.kh.project.board.model.vo.Pagination;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO dao;

	@Override
	public List<Map<String, Object>> selectBoardType() {
		return dao.selectBoardType();
	}

	@Override
	public Map<String, Object> selectBoardList(int boardCode, int cp) {

		// 1. 특정 게시판의 전체 게시글 수 조회(단, 삭제 제외)
		int listCount = dao.getListCount(boardCode);

		// 2. 전체 게시글 수 + cp(현제 페이지)이용해서
		// 페이징 처리 객체 생성
		Pagination pagination = new Pagination(listCount, cp);

		// 3. 페이징 처리객체를 이용해서 게시글 목록 조회
		List<Board> boardList = dao.selectBoardList(pagination, boardCode);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pagination", pagination);
		map.put("boardList", boardList);

		return map;
	}

	/**
	 * 게시글 상세조회+이미지목록조회+댓글목록조회
	 */
	@Override
	public Board selectBoardDetail(int boardNo) {
		return dao.selectBoardDetail(boardNo);
	}

	/**
	 * 게시글 조회 수 증가
	 */
	@Override
	@Transactional
	public int updateReadCount(int boardNo) {
		return dao.updateReadCount(boardNo);
	}
	
	/**
	 * 좋아요 여부 체크
	 */
	@Override
	public int boardLikeCheck(Map<String, Object> map) {
		return dao.boardLikeCheck(map);
	}
	
	/**
	 * 좋아요 수 증가
	 */
	@Override
	public int boardLikeUp(Map<String, Object> paramMap) {
		return dao.boardLikeUp(paramMap);
	}
	
	@Override
	public int boardLikeDown(Map<String, Object> paramMap) {
		return dao.boardLikeDown(paramMap);
	}
}
