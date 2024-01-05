package com.example.board.dto.response.comment;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class CommentRes {
	private Long comment_sid; // 댓글 번호 PK
	private Long board_sid; // 게시글 번호 FK
	private String content; // 댓글 내용
	private String writer; // 작성자
	private String delete_yn; // 댓글 삭제 여부
	private LocalDateTime created_date; // 댓글 생성 일시
<<<<<<< HEAD
	private LocalDateTime modified_date; // 댓글 수정 일시
=======
	private LocalDateTime moidfied_date; // 댓글 수정 일시
>>>>>>> cb6f619 (test1)
}
