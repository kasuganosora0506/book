package com.example.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book.bean.BookInfo_Bean;
import com.example.book.dao.BookInfo_Dao;

@Service
public class BookInfo_ServiceImpl implements BookInfo_Service{
	
	@Autowired
	private BookInfo_Dao bookDao;
	
	
	//新規追加
	public void append(BookInfo_Bean book) {
		bookDao.append(book);
	}
	
	//更新
	public void update(BookInfo_Bean book) {
		bookDao.update(book);
	}
	
	//削除
	public void delete(BookInfo_Bean book) {
		bookDao.delete(book);
	}
	
	//検索
	public BookInfo_Bean search(String book_Id) {
		return bookDao.search(book_Id);
	}
}
