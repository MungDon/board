 package com.example.board.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.board.service.CommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CommentController {

	private final CommentService commentService;


	
}
