package com.example.book.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.book.bean.Return_Bean;
import com.example.book.bean.MemberInfo_Bean;
import com.example.book.bean.Lend_Bean;
import com.example.book.bean.UserContext;
import com.example.book.service.Return_Service;
import com.example.book.service.Lend_Service;
import com.example.book.service.MemberInfo_Service;

@Controller
@RequestMapping("/main/back")
public class Return_Controller {

	@Autowired
	private Return_Service backService;
	
	@Autowired
	private MemberInfo_Service memberService;
	
	@Autowired 
	private UserContext userContext;
	
	@PostMapping("search")
	public String search(@RequestParam("member_Id")String member_Id,
						 Model model){
		
		MemberInfo_Bean member = memberService.search(member_Id);
		List<Return_Bean> rentals = backService.search(member_Id);
		if (member == null) {
			return "22A";
		}else {
			model.addAttribute("Member", member);
			model.addAttribute("rentals", rentals);
			return "back";
		}	
	}
	
	@PostMapping("update")
	public String search(@RequestParam("member_Id")String member_Id,
			@RequestParam(value = "selectedItems", required = false) List<String> selectedItems){
					
		if (selectedItems == null) {
			return "22A";
		}else {
			List<Lend_Bean> rentals = new ArrayList<>();
			for (String selectBook_Id : selectedItems) {
				Lend_Bean rental = new Lend_Bean();
				rental.setMember_Id(member_Id);
				rental.setBook_Id(selectBook_Id);
				rental.setReturn_Date(date());
				rental.setUpdate_Date(date());
				rental.setUpdate_Id(userContext.getLogin_Id());
				rental.setStatus("2");
				rentals.add(rental);
			}
			backService.update(rentals);
			return "redirect:/init";
		}	
	}
	
	
	private String date() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
}
