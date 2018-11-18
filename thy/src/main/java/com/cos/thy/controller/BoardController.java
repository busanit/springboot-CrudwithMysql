package com.cos.thy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/")
public class BoardController {

	@GetMapping(path="/board/list")
    public String boardList() {
        return "/board/list";
	}
}
