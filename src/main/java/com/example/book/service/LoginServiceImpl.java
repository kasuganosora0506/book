package com.example.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.book.bean.Login;
import com.example.book.dao.LoginDao;


@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginDao loginDao;
	
	
	@Override
	public Login login(String admin_id,String password) {
		return loginDao.login(admin_id, password);
	}
}
