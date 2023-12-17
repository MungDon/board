package com.example.board.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.board.dto.request.board.BoardReq;
import com.example.board.dto.response.board.BoardRes;
import com.example.board.mapper.BoardMapper;
import com.mysql.cj.Session;

import ch.qos.logback.core.pattern.PostCompileProcessor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardMapper boardMapper;

	// 게시글 저장
	@Transactional
	public Long saveBoard(final BoardReq params) {

		boardMapper.save(params);
		return params.getBoard_sid();

	}

	// 게시글 조회
	public List<BoardRes> findAllBoard() {
		return boardMapper.findAll();

	}

	// 게시글 상세
	public BoardRes findBoardById(final Long id) {
		return boardMapper.findById(id);

	}

	// 게시글 수정
	@Transactional
	public Long updateBoard(final BoardReq params) {
		
		boardMapper.update(params);
		return params.getBoard_sid();
	}

	// 게시글 삭제
	public Long deleteBoard(final Long id) {
		boardMapper.deleteById(id);
		return id;
	}
}
