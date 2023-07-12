package com.example.book.service;

import com.example.book.bean.BookInfo_Bean;

public interface BookInfo_Service {
	//本の情報
	
	//新規追加
	void append(BookInfo_Bean book);
	
	//更新
	void update(BookInfo_Bean book);
	
	//削除
	void delete(BookInfo_Bean book);
	
	//検索
	BookInfo_Bean search(String book_Id);
	
}
