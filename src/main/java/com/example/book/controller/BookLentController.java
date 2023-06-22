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

import com.example.book.bean.Rental;
import com.example.book.bean.UserContext;
import com.example.book.bean.Book;
import com.example.book.bean.Member;
import com.example.book.service.LentService;
import com.example.book.service.MemberService;

@Controller	
@RequestMapping("/main/lent")
public class BookLentController {

	@Autowired
	private LentService lentService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired 
	private UserContext userContext;
	
	@PostMapping("search")
	public String search(@RequestParam("book_Id")String book_Id,
			 			Model model) {
		Book book = lentService.search(book_Id);
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
		Book book = lentService.search(book_Id);
		if (book == null) {
			return "32A";
		}else {
			Member member = memberService.search(member_Id);
			if (member == null) {
				return "32B";
			}else {
				Rental rental = lentService.searchRental(book_Id);
				if (rental != null) {
					return "32C";
				}else {
					rental.setMember_Id(member_Id);
					rental.setBook_Id(book_Id);
					rental.setRental_Date(date());
					rental.setStatus("1");
					rental.setRegist_Id(userContext.getLogin_Id());
					rental.setRegist_Date(date());
					rental.setDelete_Flg("0");
					lentService.append(rental);
					return "lent";
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
