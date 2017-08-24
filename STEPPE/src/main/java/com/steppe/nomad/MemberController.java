package com.steppe.nomad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.steppe.nomad.service.ClientManagement;
import com.steppe.nomad.service.MemberManagement;

@Controller
public class MemberController {

	private ModelAndView mav;
	
	@Autowired
	private MemberManagement mm;
	
	@RequestMapping(value="/goUpdateUserInfo")
	public ModelAndView goUpdateUserInfo(){
		mav = new ModelAndView();
		mav.setViewName("updateUserInfo");
		return mav;
	}
	
	@RequestMapping(value="/deleteMember")//회원 탈퇴  조건 검색메소드
	public ModelAndView deleteMember(){
		mav = new ModelAndView();
		mav=mm.execute(1); 
		return mav;
	}
	
	@RequestMapping(value="/deleteMemberMake")//회원 탈퇴  메소드
	public ModelAndView deleteMemberMaker(){
		mav = new ModelAndView();
		mav=mm.execute(2); 
		return mav;
	}
}
