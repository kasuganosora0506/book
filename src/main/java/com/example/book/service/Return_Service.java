package com.example.book.service;

import java.util.List;

import com.example.book.bean.Return_Bean;
import com.example.book.bean.MemberInfo_Bean;
import com.example.book.bean.Lend_Bean;

public interface Return_Service {

	void update(List<Lend_Bean> rentals);
	
	List<Return_Bean> search(String member_Id);
}
