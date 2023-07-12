package com.example.book.service;

import com.example.book.bean.MemberInfo_Bean;

public interface MemberInfo_Service {
	
	void append(MemberInfo_Bean member);
	
	void update(MemberInfo_Bean member);
	
	void delete(MemberInfo_Bean member);
	
	MemberInfo_Bean search(String member_Id);
	
}
