package com.example.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book.bean.Member;
import com.example.book.dao.MemberDao;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public void append(Member member) {
		memberDao.append(member);
	}
	
	@Override
	public void update(Member member) {
		memberDao.update(member);
	}
	
	@Override
	public void delete(Member member) {
		memberDao.delete(member);
	}
	
	@Override
	public Member search(String member_Id) {
		return memberDao.search(member_Id);
	}
}
