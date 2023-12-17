package com.example.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.board.dto.request.board.BoardReq;
import com.example.board.dto.response.board.BoardRes;

@Mapper
public interface BoardMapper {
	
	/* 게시글 저장*/
		void save(BoardReq params);
	
	/* 게시글 목록 */
	List<BoardRes> findAll();
	
	/* 게시글 상세조회 */
	BoardRes findById(Long id);
	
	/* 게시글 수정 */
	void update(BoardReq params);
	
	/* 게시글 삭제 */
	void deleteById(Long id);
	
	
	/* 게시글 조회 수 */
	int count();



	
}
