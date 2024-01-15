package com.example.board.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.board.dto.request.comment.CommentReq;
import com.example.board.dto.response.comment.CommentRes;
import com.example.board.mapper.CommentMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {
	
	private final CommentMapper commentMapper;
	
	/*댓글 저장*/
	@Transactional
	public Long saveComment(final CommentReq params) {
		commentMapper.save(params);
		return params.getComment_sid();
	}
	       
	/*댓글 목록*/
	public List<CommentRes> commentList(final Long b_sid){
		return commentMapper.findAll(b_sid);
	}
	
	/*댓글 상세조회*/
	public CommentRes detailComment(final Long c_sid){
		return commentMapper.findById(c_sid);
	}
		
	/*댓글 수정*/
	@Transactional
	public Long updateComment(final CommentReq prarams) {
		commentMapper.update(prarams);
		return prarams.getComment_sid();
	}
	
	/*댓글 삭제*/
	@Transactional
	public Long deleteComment(final Long comment_sid) {
		commentMapper.deleteById(comment_sid);
		return comment_sid; 
	}
	
	
}
