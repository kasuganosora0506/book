package com.example.book.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
	
	private String book_Id;
	
	private String book_Title;
	
	private String author_Name;
	
	private String publiSher;
	
	private String publiCation_Day;
	
	private String regist_Id;
	
	private String regist_Date;
	
	private String update_Id;
	
	private String update_Date;
	
	private String delete_Flg;

}
