package com.example.book.service;

import com.example.book.bean.Book;
import com.example.book.bean.Rental;

public interface LentService {
	
	Book search(String book_Id);
	
	Rental searchRental(String book_Id);
	
	void append(Rental rental);

}
