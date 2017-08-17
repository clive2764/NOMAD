package com.steppe.nomad;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {

	private ModelAndView mav;
	
	@RequestMapping(value="/goUpdateUserInfo")
	public ModelAndView goUpdateUserInfo(){
		mav = new ModelAndView();
		mav.setViewName("updateUserInfo");
		return mav;
	}
	
	@RequestMapping(value="/deleteMember")
	public ModelAndView deleteMember(){
		mav = new ModelAndView();
		mav.setViewName("#");
		return mav;
	}
}
