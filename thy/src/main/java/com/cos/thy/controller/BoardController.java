package com.cos.thy.controller;




import java.util.List;

import javax.servlet.http.HttpSession;

import com.cos.thy.domain.Board;
import com.cos.thy.domain.Reply;
import com.cos.thy.domain.User;
import com.cos.thy.persistent.BoardRepository;
import com.cos.thy.persistent.ReplyRepository;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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

    @Autowired
    private ReplyRepository replyRepository;

	@GetMapping(path="/board/list")
    public String boardList(Model model,
    @PageableDefault(sort = { "boardid" }, direction = Direction.DESC, size = 5) Pageable pageable) {
        Page<Board> list = boardRepository.findAll(pageable);
        model.addAttribute("list", list);
        return "/board/list";
    }
    
    @GetMapping(path="/admin/board/delete/{boardid}")
    public String boardAdminDelete(@PathVariable int boardid){
        boardRepository.deleteById(boardid);
        return "redirect:/board/list";
    }

    @GetMapping(path="/board/delete")
    public String boardDelete(@RequestParam int boardid){
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
    
    @Transactional
    @GetMapping(path="/board/detail")
    public String boardDetail(@RequestParam("boardid") int boardid, Model model) {
        System.out.println("-----------------------------------------");
        System.out.println(boardid);
        System.out.println("-----------------------------------------");
        Board boardVO = boardRepository.findByBoardid(boardid);
        boardRepository.updateReadCount(boardid);
        List<Reply> replyList =  replyRepository.findByCustomBoardid(boardid);
        model.addAttribute("boardVO", boardVO);
        model.addAttribute("gson", new Gson());
        model.addAttribute("replyList", replyList);
        return "/board/detail";
    }

    @GetMapping(path="/board/updateForm")
    public String boardUpdateForm(@RequestParam int boardid, Model model) {
        Board boardVO = boardRepository.findByBoardid(boardid);
        System.out.println("boardid : "+boardVO.getBoardid());
        model.addAttribute("boardVO", boardVO);
        return "/board/updateForm";
    }
    
    @PostMapping(path="/board/update")
    public String boardUpdate(Board board, HttpSession session) {
        User userVO = (User)session.getAttribute("login");
        board.setReadcount(0);
        board.setUser(userVO);
        boardRepository.save(board);
        return "redirect:/board/list";
    }
}
