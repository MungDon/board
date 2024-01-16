package com.example.board.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.board.dto.request.comment.CommentReq;
import com.example.board.dto.request.comment.ReqReplyInsert;
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
	
	/*대댓글 저장*/
	@Transactional
	public Long saveReply(final ReqReplyInsert params) {
		System.out.println(params.getBoard_sid());
		CommentReq save =  new CommentReq();
		save.setContent(params.getContent());
		save.setMember_sid(params.getMember_sid());
		save.setBoard_sid(params.getBoard_sid());
		commentMapper.save(save);
		params.setReply_sid(save.getComment_sid());
		commentMapper.replySave(params);
		return params.getReply_sid();
	}
	       
	/*댓글 목록*/
	public List<CommentRes> commentList(final Long board_sid){
		return commentMapper.findAll(board_sid);
	}
	
	/*댓글 상세조회*/
	public CommentRes detailComment(final Long comment_sid){
		return commentMapper.findById(comment_sid);
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
