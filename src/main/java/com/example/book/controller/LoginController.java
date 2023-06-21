package com.example.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.book.bean.Login;
import com.example.book.bean.UserContext;
import com.example.book.dao.LoginDao;
import com.example.book.service.LoginService;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private UserContext userContext;
	
	@GetMapping("init")
	public String init() {
		return "login";
	}
	
	@PostMapping("login")
	public String login(String admin_id,String password) {
		Login login = loginService.login(admin_id, password);
		if (login != null) {
			if (login.getPassword().equals(password)) {
				userContext.setLogin_Id(admin_id);
				return "main";
			}else {
				return "22A";
			}	
		}else {
			return "22A";
		}
	}
}
