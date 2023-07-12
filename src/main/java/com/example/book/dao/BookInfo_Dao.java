package com.example.book.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.book.bean.BookInfo_Bean;


@Mapper
public interface BookInfo_Dao {
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
