package com.example.board.dto.request.member;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberRegReq {
	private Long member_sid; // 회원 번호 (PK)
	private String email; // 로그인 ID
	private String password; // 비밀번호
	private String password2; // 비밀번호확인
	private String nick_name; // 이름
	
}
