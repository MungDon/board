package com.example.board.dto.response.board;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardRes {
	private Long board_sid;
	private String title;
	private String content;
	private String writer;
	private int view_cnt;
	private Boolean notice_yn;
	private Boolean delete_yn;
	private LocalDateTime created_date;
	private LocalDateTime modified_date;
	
}
