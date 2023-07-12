package com.example.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.book.bean.Login_Bean;
import com.example.book.dao.Login_Dao;


@Service
public class Login_ServiceImpl implements Login_Service{
	
	@Autowired
	private Login_Dao loginDao;
	
	
	@Override
	public Login_Bean login(String admin_id,String password) {
		return loginDao.login(admin_id, password);
	}
}
