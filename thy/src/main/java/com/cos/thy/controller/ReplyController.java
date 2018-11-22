package com.cos.thy.controller;


import java.util.HashMap;
import java.util.Map;
import com.cos.thy.domain.Board;
import com.cos.thy.domain.Reply;
import com.cos.thy.domain.User;
import com.cos.thy.persistent.ReplyRepository;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(path="/")
public class ReplyController {

    @Autowired
    private ReplyRepository replyRepository;

    // @PostMapping(path="/reply/write")
    // public @ResponseBody String replyWrite(@RequestBody Map<String, String> map) {
    //     System.out.println("/reply/write");
    //     System.out.println(map.get("content"));
    //     System.out.println(map.get("boardid")); 
    //     System.out.println(map.get("userid"));
    //     return "200";
    // }

    // 스프링 부트 기반에서는 대부분의 MessageConverter를 
    // spring-boot-starter-web 의존성을 통해서 자동으로 세팅해줍니다.
    // 스프링 부트가 아니라면 jackson databind 의존성을 추가해야 Map을 json으로 변환해준다.
    @PostMapping(path="/reply/write")
    public @ResponseBody Map<String, Integer> replyWrite(@RequestBody Map<String, String> map) {
        Reply reply = new Reply();
        Gson gson = new Gson();
        String content = map.get("content");
        User user = gson.fromJson(map.get("user"), User.class);
        Board board = gson.fromJson(map.get("board"), Board.class);
        System.out.println("==============================================");
        System.out.println(content);
        System.out.println(user.getUserid());
        System.out.println(board.getBoardid());
        reply.setContent(content);
        reply.setUser(user);
        reply.setBoard(board);

        replyRepository.save(reply);
        int lastReplyid = replyRepository.findLastReplyid();
        Map<String, Integer> result = new HashMap<>();
        result.put("lastReplyid", lastReplyid);
        return result;
    }

    @GetMapping(path="/reply/delete")
	public String userDelete(@RequestParam int replyid, @RequestParam int boardid, RedirectAttributes redirect) {
        replyRepository.deleteById(replyid);
        redirect.addAttribute("boardid", boardid);
		return "redirect:/board/detail";	
	}
}
