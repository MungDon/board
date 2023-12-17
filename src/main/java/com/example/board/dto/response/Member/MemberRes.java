package com.example.board.dto.response.Member;



import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@ToString
public class MemberRes {
	
		private Long member_sid;                       // 회원 번호 (PK)
	    private String email;                // 로그인 ID
	    private String password;               // 비밀번호
	    private String nick_name;                   // 이름
	    private String delete_yn;              // 삭제 여부
	    private LocalDateTime created_date;     // 생성일시
	    private LocalDateTime modified_date;    // 최종 수정일시
}
