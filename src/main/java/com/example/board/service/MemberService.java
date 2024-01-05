package com.example.board.service;

import org.springframework.stereotype.Service;

import com.example.board.dto.request.member.MemberRegReq;
import com.example.board.dto.response.Member.MemberRes;
import com.example.board.mapper.MemberMapper;

import jakarta.el.ELException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberMapper memberMapper;

	public void memberJoin(MemberRegReq params) throws Exception{
		MemberRes valid = memberMapper.findByEmail(params);
		if(valid != null) {
			throw new Exception("아이디가 중복되었다 ㅋㅋ");
		}
		valid = memberMapper.findByNickName(params);
		if(valid != null) {
			throw new Exception("닉네임이 중복되었다 ㅋㅋ");
		}
		if(! params.getPassword().equals(params.getPassword2()) ) {
			throw new Exception("손가락 부러졌냐 ㅋㅋ");
		}
		memberMapper.insertUser(params);
		
	}

	public MemberRes memberlogin(MemberRegReq params) throws Exception {
		MemberRes res = memberMapper.findByEmailPwd(params);
		if(res == null ) {
			throw new Exception("병신");
		}	
		return res;
	}
}
