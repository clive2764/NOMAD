package com.steppe.nomad;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FreelancerController {
	
	private ModelAndView mav;
	@RequestMapping(value = "/goMyPortfolio", method = RequestMethod.GET)
	public ModelAndView portfolio() {
		mav=new ModelAndView();
		mav.setViewName("portfolio");
		return mav;
	}
}
