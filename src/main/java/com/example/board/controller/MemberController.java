package com.example.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.board.dto.request.member.MemberRegReq;
import com.example.board.dto.response.Member.MemberRes;
import com.example.board.service.MemberService;
import com.mysql.cj.Session;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
	
	private final MemberService memberService;

	//로그인 페이지
	@GetMapping("/login")
	public String memberLoginForm() {
		return "member/login";
	}
	@PostMapping("/login")
	public String memberLogin(MemberRegReq params, HttpServletRequest httpServletRequest)throws Exception {
		MemberRes res= memberService.memberlogin(params);
		httpServletRequest.getSession().invalidate();
		HttpSession session= httpServletRequest.getSession(true);
		session.setAttribute("member_sid", res.getMember_sid());
		session.setMaxInactiveInterval(1800); // Session이 30분동안 유지
		return "redirect:/board";
	}
	
	@DeleteMapping("/logout")
	@ResponseBody
	public void memberLogout( HttpServletRequest httpServletRequest)throws Exception {
		HttpSession session = httpServletRequest.getSession(false);
		if(session!=null) {
			session.invalidate();
		}
		
	}
	//회원가입 페이지
	@GetMapping("")
	public String memberJoinForm() {
		return "member/join";
	}
	@PostMapping("")
	public String memberJoin(MemberRegReq params) throws Exception{
		memberService.memberJoin(params);
		return "redirect:/member/login";
	}
}
