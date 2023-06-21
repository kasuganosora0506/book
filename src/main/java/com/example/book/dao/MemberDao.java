package com.example.book.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.book.bean.Member;

@Mapper
public interface MemberDao {
	
	void append(Member member);
	
	void update(Member member);
	
	void delete(Member member);
	
	Member search(String member_Id);
	
}
