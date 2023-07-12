package com.example.book.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.book.bean.Login_Bean;

@Mapper
public interface Login_Dao {
	
	Login_Bean login(@Param("admin_id")String admin_id,@Param("password")String password);

}
