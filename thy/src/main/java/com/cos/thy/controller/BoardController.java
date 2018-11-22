package com.cos.thy.controller;



import javax.servlet.http.HttpSession;

import com.cos.thy.domain.Board;
import com.cos.thy.domain.User;
import com.cos.thy.persistent.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path="/")
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

	@GetMapping(path="/board/list")
    public String boardList(Model model,
    @PageableDefault(sort = { "boardid" }, direction = Direction.DESC, size = 6) Pageable pageable) {
        Page<Board> list = boardRepository.findAll(pageable);
        model.addAttribute("list", list);
        return "/board/list";
    }
    
    @GetMapping(path="/board/delete/{boardid}")
    public String boardDelete(@PathVariable int boardid){
        boardRepository.deleteById(boardid);
        return "redirect:/board/list";
    }

    @GetMapping(path="/board/writeForm")
    public String boardWriteForm() {
        return "/board/writeForm";
    }
    
    @PostMapping(path="/board/insert")
    public String boardInsert(Board board, HttpSession session) {
        User userVO = (User)session.getAttribute("login");
        board.setReadcount(0);
        board.setUser(userVO);
        boardRepository.save(board);
        return "redirect:/board/list";
    }
    
    @GetMapping(path="/board/detail")
    public String boardDetail(@RequestParam int boardid, Model model) {
        Board boardVO = boardRepository.findByBoardid(boardid);
        model.addAttribute("boardVO", boardVO);
        return "/board/detail";
	}
    
}
