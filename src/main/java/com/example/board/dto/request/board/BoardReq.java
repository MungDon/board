package com.example.board.dto.request.board;

import lombok.Data;

@Data
public class BoardReq {

	private Long board_sid;
	private Long member_sid;
	private String title;
	private String content;
	private boolean notice_yn;
	
}
