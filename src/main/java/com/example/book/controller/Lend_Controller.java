package com.example.book.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.book.bean.Lend_Bean;
import com.example.book.bean.UserContext;
import com.example.book.bean.BookInfo_Bean;
import com.example.book.bean.MemberInfo_Bean;
import com.example.book.service.Lend_Service;
import com.example.book.service.MemberInfo_Service;

@Controller	
@RequestMapping("/main/lent")
public class Lend_Controller {

	@Autowired
	private Lend_Service lentService;
	
	@Autowired
	private MemberInfo_Service memberService;
	
	@Autowired 
	private UserContext userContext;
	
	@PostMapping("search")
	public String search(@RequestParam("book_Id")String book_Id,
			 			Model model) {
		BookInfo_Bean book = lentService.search(book_Id);
		if (book == null) {
			return "22A";
		}else {
			model.addAttribute("Book", book);
			return "lent";
		}
	}
	
	@PostMapping("lent")
	public String search(@RequestParam("book_Id")String book_Id,
						@RequestParam("member_Id")String member_Id){
		BookInfo_Bean book = lentService.search(book_Id);
		if (book == null) {
			return "32A";
		}else {
			MemberInfo_Bean member = memberService.search(member_Id);
			if (member == null) {
				return "32B";
			}else {
				Lend_Bean rental = lentService.searchRental(book_Id);
				if (rental != null) {
					return "32C";
				}else {
					rental = new Lend_Bean();
					rental.setMember_Id(member_Id);
					rental.setBook_Id(book_Id);
					rental.setRental_Date(date());
					rental.setStatus("1");
					rental.setRegist_Id(userContext.getLogin_Id());
					rental.setRegist_Date(date());
					rental.setDelete_Flg("0");
					lentService.append(rental);
					System.out.println();
					return "redirect:/init";
				}
			}

		}
	}
	
	private String date() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
}
