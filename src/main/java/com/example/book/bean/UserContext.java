package com.example.book.bean;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class UserContext {
	
	private String login_Id;
	
	public boolean loginTest() {
		if (login_Id == null) {
			return false;
		}else {
			return true;
		}
	}
}
