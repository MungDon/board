package com.example.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.board.dto.request.board.BoardReq;
import com.example.board.dto.response.board.BoardRes;
import com.example.board.service.BoardService;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

	private final BoardService boardService;

	/* 게시판 목록 */
	@GetMapping("")
	public String boardList(Model model) {
		List<BoardRes> board = boardService.findAllBoard();
		model.addAttribute("board", board);
		return "board/boardlist";
	}

	/* 게시판 등록 폼 */
	@GetMapping("/add")
	public String boardAddForm() {

		return "board/boardadd";
	}

	/* 게시판 등록 기능 */
	@PostMapping("/add")
	public String boardSave(final BoardReq params, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		if(session == null) {
			return "redirect:/member/login";
		}
		
		Long member_sid = (Long) session.getAttribute("member_sid");
		params.setMember_sid(member_sid);
		boardService.saveBoard(params);
		return "redirect:/board";
	}

	/* 상세보기 페이지 */
	@GetMapping("/detail/{id}")
	public String boardDetail(Model model, @PathVariable(value = "id") Long id) {
		BoardRes detail = boardService.findBoardById(id);
		model.addAttribute("detail", detail);
		return "board/boarddetail";

	}

	@GetMapping("/update/{id}")
	public String boardUpdateForm(@PathVariable(value = "id") Long id, Model model) {
		BoardRes update = boardService.findBoardById(id);
		model.addAttribute("update", update);
		return "board/boardupdate";
	}

	@PutMapping("/update")
	public String boardUpdate(BoardReq boardReq) {
		boardService.updateBoard(boardReq);
		return "redirect:/board";

	}
	@DeleteMapping("/delete")
	@ResponseBody
public void boardDelete(@RequestParam final Long id) {
		boardService.deleteBoard(id);
	
		

}
}