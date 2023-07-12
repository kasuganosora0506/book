package com.example.book.service;


import com.example.book.bean.Login_Bean;

public interface Login_Service {
	
	Login_Bean login(String admin_id,String password);
}
