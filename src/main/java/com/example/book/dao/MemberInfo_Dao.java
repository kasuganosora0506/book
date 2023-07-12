package com.example.book.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.book.bean.MemberInfo_Bean;

@Mapper
public interface MemberInfo_Dao {
	
	void append(MemberInfo_Bean member);
	
	void update(MemberInfo_Bean member);
	
	void delete(MemberInfo_Bean member);
	
	MemberInfo_Bean search(String member_Id);
	
}
