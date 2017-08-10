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

	
	@RequestMapping(value = "/showFstList", method = RequestMethod.POST)
	public ModelAndView showFstList(Test test) {
		mav=fm.execute(test, 1);
		return mav;
	}
	
	@RequestMapping(value = "/showFstDetail", method = RequestMethod.GET)
	public ModelAndView showFstDetail() {
		System.out.println("디테일");
		mav=fm.execute(1); 
		return mav;
	}
	
	@RequestMapping(value = "/goInsertFst", method = RequestMethod.GET)
	public ModelAndView goInsertFst() {
		mav=new ModelAndView();
		mav.setViewName("fstInsert");		
		return mav;
	}
	
}
