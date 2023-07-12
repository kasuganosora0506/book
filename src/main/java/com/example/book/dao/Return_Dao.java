package com.example.book.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.book.bean.Return_Bean;
import com.example.book.bean.Lend_Bean;

@Mapper
public interface Return_Dao {
	
	void update(List<Lend_Bean> rentals);
	
	List<Return_Bean> search(String member_Id);

}
