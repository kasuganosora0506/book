package com.example.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book.bean.MemberInfo_Bean;
import com.example.book.dao.MemberInfo_Dao;

@Service
public class MemberInfo_ServiceImpl implements MemberInfo_Service{
	
	@Autowired
	private MemberInfo_Dao memberDao;
	
	@Override
	public void append(MemberInfo_Bean member) {
		memberDao.append(member);
	}
	
	@Override
	public void update(MemberInfo_Bean member) {
		memberDao.update(member);
	}
	
	@Override
	public void delete(MemberInfo_Bean member) {
		memberDao.delete(member);
	}
	
	@Override
	public MemberInfo_Bean search(String member_Id) {
		return memberDao.search(member_Id);
	}
}
