package com.example.book.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.book.bean.BookInfo_Bean;
import com.example.book.bean.MemberInfo_Bean;
import com.example.book.bean.UserContext;
import com.example.book.service.BookInfo_Service;
import com.example.book.service.MemberInfo_Service;

@Controller
@RequestMapping("/main/book")
public class BookInfo_Controller {
	
	@Autowired
	private BookInfo_Service bookService;
	
	@Autowired
	private UserContext userContext;
	
	//新規追加
	@PostMapping("/append")
	public String append(@RequestParam("publiCation_Day_Year")String year,
						@RequestParam("publiCation_Day_Month")String month,
						@RequestParam("publiCation_Day_Day")String day,
						@ModelAttribute("book")BookInfo_Bean book) {
		String publiCation_Day = year + "-" + month + "-" + day;
		
		
		book.setPubliCation_Day(publiCation_Day);
		book.setRegist_Id(userContext.getLogin_Id());
		book.setRegist_Date(date());
		book.setDelete_Flg("0");
		bookService.append(book);
		return "redirect:/main/book"; 
	}
	
	//更新
	@PostMapping("update")
	public String update(@RequestParam("publiCation_Day_Year")String year,
						@RequestParam("publiCation_Day_Month")String month,
						@RequestParam("publiCation_Day_Day")String day,
						@ModelAttribute("book")BookInfo_Bean book) {
		String publiCation_Day = year + "-" + month + "-" + day;
		
		book.setPubliCation_Day(publiCation_Day);
		book.setUpdate_Id(userContext.getLogin_Id());
		book.setUpdate_Date(date());
		bookService.update(book);
		return "redirect:/init";
	}
	
	//削除
	@PostMapping("delete")
	public String delete(@ModelAttribute("book")BookInfo_Bean book){

		book.setDelete_Flg("1");
		book.setUpdate_Id(userContext.getLogin_Id());
		book.setUpdate_Date(date());
		bookService.delete(book);
		return "redirect:/init";
	}
	
	//検索
	@PostMapping("search")
	public String search(@RequestParam("book_Id")String book_Id,Model model){
		
		BookInfo_Bean book = bookService.search(book_Id);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		if (book == null) {
			book = new BookInfo_Bean();
		}

		LocalDate publiCation_Day = LocalDate.parse(book.getPubliCation_Day(), formatter);
		int publiCation_Day_Year = publiCation_Day.getYear();
		int publiCation_Day_Month = publiCation_Day.getMonthValue();
		int publiCation_Day_Day = publiCation_Day.getDayOfMonth();
		
		model.addAttribute("publiCation_Day_Year", publiCation_Day_Year);
		model.addAttribute("publiCation_Day_Month", publiCation_Day_Month);
		model.addAttribute("publiCation_Day_Day", publiCation_Day_Day);
		model.addAttribute("Book", book);
		return "book";
	}
	

	private String date() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
}
