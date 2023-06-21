package com.example.book.service;


import com.example.book.bean.Login;

public interface LoginService {
	
	Login login(String admin_id,String password);
}
