package com.example.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book.bean.Return_Bean;
import com.example.book.bean.Lend_Bean;
import com.example.book.dao.Return_Dao;

@Service
public class Return_ServiceImpl implements Return_Service{
	
	@Autowired
	private Return_Dao backDao;
	
	public void update(List<Lend_Bean> rentals) {
		backDao.update(rentals);
	}
	
	public List<Return_Bean> search(String member_Id) {
		return backDao.search(member_Id);
	}
}
