package com.cos.thy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cos.thy.domain.User;
import com.cos.thy.service.UserService;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path="/")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping(path="/")
    public String home() {
        return "home";
	}
	
	//Optional<User> 테스트용!!
	@GetMapping(path="/test/oneUser")
	public @ResponseBody Optional<User> oneUser(@RequestParam Integer id) {
		Optional<User> user = userService.findById(id);
		return user; 
	}

	//Query 테스트용!!
	@GetMapping(path="/test/customQuery")
	public @ResponseBody List<User> customQuery() {
		List<User> user = userService.findByCustom();
		return user; 
	}

	//Page -> number, last, first, content
	@GetMapping(path="/user/list")
	public String userList(Model model,
	@PageableDefault(sort = { "id" }, direction = Direction.DESC, size = 6) Pageable pageable) {
		// This returns a JSON or XML with the users
		Page<User> list = userService.findAll(pageable);
		model.addAttribute("list", list);
		return "/user/list";
	}

	@GetMapping(path="/user/joinForm")
    public String userJoinForm() {
        return "/user/joinForm";
	}

	@GetMapping(path="/user/loginForm")
    public String userLoginForm() {
        return "/user/loginForm";
	}

	//@RequestParam(name="name", required=false, defaultValue="World") String name
	@PostMapping(path="/user/insert") // Map ONLY GET Requests
	public String userInsert (User user, Model model) {
		userService.save(user);
		return "redirect:/user/list";	
	}

	@PostMapping(path="/user/login")
	public void userLogin (User user, Model model, HttpSession session) {
		User userVO = userService.findByEmailAndPassword(user.getEmail(), user.getPassword());
		model.addAttribute("userVO", userVO);
	}

	@GetMapping(path="/user/update") // Map ONLY GET Requests
	public String userUpdate (@RequestParam int id, @RequestParam String name
			, @RequestParam String email) {
		User userVO = new User();
		userVO.setId(id);
		userVO.setName(name);
		userVO.setEmail(email);
		userService.save(userVO);
		return "redirect:/user/list";		
	}

	@GetMapping(path="/user/delete/{id}")
	public String userDelete(@PathVariable int id) {
		userService.deleteById(id);
		return "redirect:/user/list";	
	}

	@GetMapping(path="/user/logout")
	public String userLogout(HttpSession session) {
		session.removeAttribute("login");
		return "redirect:/";	
	}
}
