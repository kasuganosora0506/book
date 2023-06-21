package com.example.book.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.book.bean.Login;

@Mapper
public interface LoginDao {
	
	Login login(@Param("admin_id")String admin_id,@Param("password")String password);

}
