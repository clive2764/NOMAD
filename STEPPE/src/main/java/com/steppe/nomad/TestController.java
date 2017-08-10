package com.steppe.nomad;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.steppe.nomad.bean.Test;
import com.steppe.nomad.service.FstManagrment;

@Controller
public class TestController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	@Autowired
	private FstManagrment fm;
	private ModelAndView mav;

	
	@RequestMapping(value = "/showFstList")
	public ModelAndView showFstList(Test test) {
		System.out.println("시험리스트");
		mav=new ModelAndView();
		mav=fm.execute(test, 1);
		return mav;
	}
	
	@RequestMapping(value = "/showFstDetail")
	public ModelAndView showFstDetail() {
		System.out.println("시험디테일");
		mav=new ModelAndView();
		mav=fm.execute(1); 
		return mav;
	}
	
	@RequestMapping(value = "/insertFst")
	public ModelAndView insertFst() {
		System.out.println("시험문제추가");
		mav=new ModelAndView();
		mav=fm.execute(2); 
		return mav;
	}
	
	@RequestMapping(value = "/goInsertFst")
	public ModelAndView goInsertFst() {
		System.out.println("시험추가페이지");
		mav=new ModelAndView();
		mav.setViewName("fstInsert");		
		return mav;
	}
	
	@RequestMapping(value = "/goUpdateFst")
	public ModelAndView UpdateFst() {
		System.out.println("시험수정페이지");
		mav=new ModelAndView();
		mav=fm.execute(3); 		
		return mav;
	}
	
	@RequestMapping(value = "/updateFst")
	public ModelAndView updateFst() {
		System.out.println("시험수정");
		mav=new ModelAndView();
		mav=fm.execute(4); 		
		return mav;
	}
	
	@RequestMapping(value = "/deleteFst")
	public ModelAndView deleteFst() {
		System.out.println("시험수정");
		mav=new ModelAndView();
		mav=fm.execute(5); 		
		return mav;
	}
	
}
