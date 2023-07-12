package com.example.book.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Lend_Bean {
	
	private String member_Id;
	
	private String book_Id;
	
	private String rental_Date;
	
	private String return_Date;
	
	private String status;
	
	private String regist_Id;
	
	private String regist_Date;
	
	private String update_Id;
	
	private String update_Date;
	
	private String delete_Flg;

}
