package com.steppe.nomad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.steppe.nomad.bean.Notice;
import com.steppe.nomad.service.AdminManagement;

@Controller
public class AdminController {
	
	private ModelAndView mav;
	
	@Autowired
	private AdminManagement am; //페이지 처음 진입용
	
	@RequestMapping(value = "/noticeInsert", method = RequestMethod.POST)
	public ModelAndView noticeInsert(Notice nt) {
		mav = am.execute(nt, 1);
		return mav;
	}
	
	@RequestMapping(value = "/noticeDelete")
	public ModelAndView noticeDelete(int nnum) {
		System.out.println("nnum=="+nnum);
		mav = am.execute(nnum, 1);
		return mav;
	}
	
		
	@RequestMapping(value = "/goNoticeUpdate")
	public ModelAndView goNoticeUpdate(int nnum) {
		mav = am.execute(nnum, 2);
		return mav;
	}
	
	@RequestMapping(value = "/noticeUpdate")
	public ModelAndView noticeUpdate(Notice notice) {
		mav = am.execute(notice, 2);
		return mav;
	}
	
	@RequestMapping(value = "/goNoticeDetail")
	public ModelAndView goNoticeDetail(int nnum) {
		System.out.println("nnum=="+nnum);
		mav = am.execute(nnum, 4);
		
		return mav;
	}
	
	
	
	
}










