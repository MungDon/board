package com.example.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.board.dto.request.comment.CommentReq;
import com.example.board.dto.request.comment.ReqReplyInsert;
import com.example.board.dto.response.comment.CommentRes;

@Mapper
public interface CommentMapper {
	/*댓글저장*/
	void save(CommentReq params);
	
	/*대댓글저장*/
	void replySave(ReqReplyInsert params);
	
	/*대댓글 더보기*/
	List<CommentRes> more(Long first_sid);
	
	/*댓글목록*/
	List<CommentRes> findAll(Long board_sid);
	
	/*댓글 상세조회*/
	CommentRes findById(Long comment_sid);
	
	/*댓글 수정*/
	void update(CommentReq prarams);
	
	/*댓글 삭제*/
	void deleteById(Long c_sid);
	
	/*댓글 카운트 수 */
	int count(Long b_sid);

	
}
