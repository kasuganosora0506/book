package com.example.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book.bean.BookInfo_Bean;
import com.example.book.bean.Lend_Bean;
import com.example.book.dao.Lend_Dao;


@Service
public class Lend_ServiceImpl implements Lend_Service{
	
	@Autowired
	private Lend_Dao lentDao;

	@Override
	public BookInfo_Bean search(String book_Id) {
		return lentDao.search(book_Id);
	}
	
	@Override
	public Lend_Bean searchRental(String book_Id) {
		return lentDao.searchRental(book_Id);
	}
	
	public void append(Lend_Bean rental) {
		lentDao.append(rental);
	}
}
