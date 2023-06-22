package com.example.book.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.book.bean.Book;
import com.example.book.bean.Rental;


@Mapper
public interface LentDao {
	
	Book search(String book_Id);

	Rental searchRental(String book_Id);
	
	void append(Rental rental);
}
