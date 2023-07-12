package com.example.book.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.book.bean.BookInfo_Bean;
import com.example.book.bean.Lend_Bean;


@Mapper
public interface Lend_Dao {
	
	BookInfo_Bean search(String book_Id);

	Lend_Bean searchRental(String book_Id);
	
	void append(Lend_Bean rental);
}
