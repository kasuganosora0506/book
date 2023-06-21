package com.example.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.book.bean.Member;

@Controller
@RequestMapping("/main")
public class MainController {
	
	@GetMapping("/member")
	public String member(Model model) {
		Member member = new Member();
		model.addAttribute("Member",member);
		return "member";
	}
	
	@GetMapping("/lent")
	public String lent() {
		return "lent";
	}
	
	@GetMapping("/book")
	public String book() {
		return "book";
	}
	
	@GetMapping("/back")
	public String back() {
		return "back";
	}

}
