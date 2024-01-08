package com.example.board.dto.request.comment;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentReq {
		
		private Long comment_sid; // 댓글 번호 PK
		private Long board_sid; // 게시글 번호 FK
		private String content; // 댓글 내용
		private Long member_sid; // 작성자

}
