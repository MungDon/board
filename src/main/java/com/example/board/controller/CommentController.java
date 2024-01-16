package com.example.board.controller;

import java.util.List;

import javax.swing.event.ListDataEvent;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.dto.request.comment.CommentReq;
import com.example.board.dto.request.comment.ReqReplyInsert;
import com.example.board.dto.response.comment.CommentRes;
import com.example.board.service.CommentService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor

@RequestMapping("/board/comment")
public class CommentController {

	private final CommentService commentService;

	// 댓글 생성
	@PostMapping("")
	public CommentRes saveComment(CommentReq params, HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		Long m_id = (Long) session.getAttribute("member_sid"); 
		params.setMember_sid(m_id);
		Long c_id = commentService.saveComment(params);
		return commentService.detailComment(c_id);

	}

	// 댓글목록
	@GetMapping("/list/{board_sid}")
	public List<CommentRes> listComment(@PathVariable Long board_sid) {
		List<CommentRes> list = commentService.commentList(board_sid);
		return list;
	}
	//댓글 수정 
	@PutMapping("/update")
	public Long updateComment(CommentReq params) {
		return	commentService.updateComment(params);
		
		
	}
	
	//대댓글 저장
	@PostMapping("/reply")
	public List<CommentRes> replySave(ReqReplyInsert params, HttpServletRequest req){
		HttpSession session = req.getSession(false);
		Long m_id = (Long) session.getAttribute("member_sid"); 
		params.setMember_sid(m_id);
		commentService.saveReply(params);
		List<CommentRes> list = commentService.commentList(params.getBoard_sid());
		return list;
		
		
	}
	
	// 댓글 삭제
	@DeleteMapping("")
	public String deleteComment(Long comment_sid) {
		commentService.deleteComment(comment_sid);
		return "삭제완료";
	}

}
