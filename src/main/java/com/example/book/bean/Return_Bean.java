package com.example.book.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Return_Bean {
	
	private String member_Id;
	
	private String book_Id;
	
	private String book_Title;

}
