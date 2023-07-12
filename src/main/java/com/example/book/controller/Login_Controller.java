package com.example.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.book.bean.Login_Bean;
import com.example.book.bean.UserContext;
import com.example.book.dao.Login_Dao;
import com.example.book.service.Login_Service;

@Controller
@RequestMapping("/")
public class Login_Controller {
	
	@Autowired
	private Login_Service loginService;
	
	@Autowired
	private UserContext userContext;
	
	@GetMapping("init")
	public String init() {
		return "login";
	}
	
	@PostMapping("login")
	public String login(String admin_id,String password) {
		Login_Bean login = loginService.login(admin_id, password);
		if (login != null) {
			if (login.getPassword().equals(password)) {
				userContext.setLogin_Id(admin_id);
				System.out.println();
				return "redirect:/main/init";
			}else {
				return "22A";
			}	
		}else {
			return "22A";
		}
	}
}
