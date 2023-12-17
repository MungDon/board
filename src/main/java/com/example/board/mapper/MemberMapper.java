package com.example.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.board.dto.request.member.MemberRegReq;
import com.example.board.dto.response.Member.MemberRes;

@Mapper
public interface MemberMapper {

	/* 회원가입 */
	void insertUser(MemberRegReq params);

	/* 로그인 */
	MemberRes findByEmailPwd(MemberRegReq params);

	/* 아이디 중복검사 */
	MemberRes findByEmail(MemberRegReq params);

	/* 닉네임 중복검사 */
	MemberRes findByNickName(MemberRegReq params);

}
