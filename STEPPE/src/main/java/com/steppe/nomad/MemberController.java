package com.steppe.nomad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.steppe.nomad.bean.Member;
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
	
	@RequestMapping(value="/deleteMember")
	public ModelAndView deleteMember(){
		mav = new ModelAndView();
		mav.setViewName("#");
		return mav;
	}

	@RequestMapping(value="/updateInfo")
	public ModelAndView updateInfo(Member mb){
		mav = mm.execute(mb, 3);
		return mav;
	}
	@RequestMapping(value="/memberUpdate")
	public ModelAndView memberUpdate(MultipartHttpServletRequest multi){
		mav = mm.execute(multi, 2);
		return mav;
	}

}
