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

import com.example.book.bean.MemberInfo_Bean;
import com.example.book.bean.UserContext;
import com.example.book.service.MemberInfo_Service;

@Controller
@RequestMapping("/main/member")
public class MemberInfo_Controller {
	
	@Autowired
	private MemberInfo_Service memberService;
	
	@Autowired
	private UserContext userContext;

	@PostMapping(value = {"append", "update"})
	public String append(@RequestParam("birth_Day_Year")String year,
						@RequestParam("birth_Day_Month")String month,
						@RequestParam("birth_Day_Day")String day,
						@ModelAttribute("member")MemberInfo_Bean member,Model model) {
		
		model.addAttribute("birth_Day_Year", year);
		model.addAttribute("birth_Day_Month", month);
		model.addAttribute("birth_Day_Day", day);
		
		model.addAttribute("Member", member);
		return "memberconfirm"; 
	}
	
	@PostMapping("appendconfirm")
	public String appendConfirm(@RequestParam("birth_Day_Year")String year,
						@RequestParam("birth_Day_Month")String month,
						@RequestParam("birth_Day_Day")String day,
						@ModelAttribute("Member")MemberInfo_Bean member) {
		String birthday = year + "-" + month + "-" + day;
	
		member.setBirth_Day(birthday);
		member.setRegist_Id(userContext.getLogin_Id());
		member.setRegist_Date(date());
		member.setDelete_Flg("0");
		memberService.append(member);
		return "updatesuccess"; 
	}
	
	@PostMapping("updateconfirm")
	public String update(@RequestParam("birth_Day_Year")String year,
						@RequestParam("birth_Day_Month")String month,
						@RequestParam("birth_Day_Day")String day,
						@ModelAttribute MemberInfo_Bean member) {
		String birthday = year + "-" + month + "-" + day;
		
		member.setBirth_Day(birthday);
		member.setUpdate_Id(userContext.getLogin_Id());
		member.setUpdate_Date(date());
		memberService.update(member);
		return "updatesuccess";
	}
	
	@PostMapping("delete")
	public String delete(@ModelAttribute MemberInfo_Bean member){

		member.setDelete_Flg("1");
		member.setUpdate_Id(userContext.getLogin_Id());
		member.setUpdate_Date(date());
		memberService.delete(member);
		return "updatesuccess";
	}
	
	@PostMapping("search")
	public String search(@RequestParam("member_Id")String member_Id,
						 Model model){
		
		MemberInfo_Bean member = memberService.search(member_Id);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		if (member == null) {
			member = new MemberInfo_Bean();
		}

		LocalDate birthday = LocalDate.parse(member.getBirth_Day(), formatter);
		int birth_Day_Year = birthday.getYear();
		int birth_Day_Month = birthday.getMonthValue();
		int birth_Day_Day = birthday.getDayOfMonth();
		
		model.addAttribute("birth_Day_Year", birth_Day_Year);
		model.addAttribute("birth_Day_Month", birth_Day_Month);
		model.addAttribute("birth_Day_Day", birth_Day_Day);
		model.addAttribute("Member", member);
		
		return "member";
	}
	

	private String date() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
}
