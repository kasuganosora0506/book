package com.example.book.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member {
	private String member_Id;
	
	private String member_Family_Name;
	
	private String member_Family_Name_Kana;
	
	private String member_First_Name;
	
	private String member_First_Name_Kana;
	
	private String address;
	
	private String birth_Day;
	
	private String regist_Id;
	
	private String regist_Date;
	
	private String update_Id;
	
	private String update_Date;
	
	private String delete_Flg;
	

}
