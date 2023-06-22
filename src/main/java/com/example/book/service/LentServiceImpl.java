package com.example.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book.bean.Book;
import com.example.book.bean.Rental;
import com.example.book.dao.LentDao;


@Service
public class LentServiceImpl implements LentService{
	
	@Autowired
	private LentDao lentDao;

	@Override
	public Book search(String book_Id) {
		return lentDao.search(book_Id);
	}
	
	@Override
	public Rental searchRental(String book_Id) {
		return lentDao.searchRental(book_Id);
	}
	
	public void append(Rental rental) {
		lentDao.append(rental);
	}
}
