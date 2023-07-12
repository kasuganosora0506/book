package com.example.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.book.bean.BookInfo_Bean;
import com.example.book.bean.MemberInfo_Bean;
import com.example.book.bean.UserContext;

@Controller
@RequestMapping("/main")
public class MainMenu_Controller {
	
	@Autowired
	private UserContext userContext;
	
	@GetMapping("/signout")
	public String signout() {
		userContext.setLogin_Id(null);
		return "signout";
	}
	
	@GetMapping("/init")
	public String init() {
		if (userContext.getLogin_Id() == null) {
			return "loginerr";
		}
		return "main";
	}
	
	@GetMapping("/member")
	public String member(Model model) {
		if (userContext.getLogin_Id() == null) {
			return "loginerr";
		}
		MemberInfo_Bean member = new MemberInfo_Bean();
		model.addAttribute("Member",member);
		return "member";
	}
	
	@GetMapping("/lent")
	public String lent(Model model) {
		if (userContext.getLogin_Id() == null) {
			return "loginerr";
		}
		BookInfo_Bean book = new BookInfo_Bean();
		model.addAttribute("Book",book);
		return "lent";
	}
	
	@GetMapping("/book")
	public String book(Model model) {
		if (userContext.getLogin_Id() == null) {
			return "loginerr";
		}
		BookInfo_Bean book = new BookInfo_Bean();
		model.addAttribute("Book",book);
		return "book";
	}
	
	@GetMapping("/back")
	public String back(Model model) {
		if (userContext.getLogin_Id() == null) {
			return "loginerr";
		}
		MemberInfo_Bean member = new MemberInfo_Bean();
		model.addAttribute("Member",member);
		return "back";
	}

}
