 package com.example.board.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.dto.request.comment.CommentReq;
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
	public CommentRes saveComment(  CommentReq params ,HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		Long m_id =  (Long)session.getAttribute("member_sid");
		params.setMember_sid(m_id);
		Long c_id = commentService.saveComment(params);
		return commentService.detailComment(c_id);
		
	}
	// 댓글목록
	@GetMapping("/list/{b_sid}")
	public List<CommentRes> listComment(@PathVariable Long b_sid) {
		List<CommentRes> list = commentService.commentList(b_sid);
		return list;
	}
	
	// 댓글 삭제
	@DeleteMapping("")
	public String deleteComment(Long c_sid) {
		commentService.deleteComment(c_sid);
		return "삭제완료";
	}
	
}
