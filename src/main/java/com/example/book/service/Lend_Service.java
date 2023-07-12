package com.example.book.service;

import com.example.book.bean.BookInfo_Bean;
import com.example.book.bean.Lend_Bean;

public interface Lend_Service {
	
	BookInfo_Bean search(String book_Id);
	
	Lend_Bean searchRental(String book_Id);
	
	void append(Lend_Bean rental);

}
