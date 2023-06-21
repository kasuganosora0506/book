package com.example.book.service;

import com.example.book.bean.Member;

public interface MemberService {
	
	void append(Member member);
	
	void update(Member member);
	
	void delete(Member member);
	
	Member search(String member_Id);
	
}
