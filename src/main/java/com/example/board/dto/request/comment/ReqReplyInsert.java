package com.example.board.dto.request.comment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqReplyInsert {
		private Long first_sid;
		private Long sec_sid;
		private Long reply_sid;
		private Long board_sid; // 게시글 번호 FK
		private String content; // 댓글 내용
		private Long member_sid; // 작성자
}
