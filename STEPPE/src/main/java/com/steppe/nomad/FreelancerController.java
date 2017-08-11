package com.steppe.nomad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.steppe.nomad.bean.Career;
import com.steppe.nomad.service.FreelancerManegement;

@Controller
public class FreelancerController {
	
	@Autowired
	private FreelancerManegement fm;
	private ModelAndView mav;
	@RequestMapping(value = "/goMyCareer")
	public ModelAndView careerInfo() {
		mav=new ModelAndView();
		mav.setViewName("careerInfo");
		return mav;
	}
	
	@RequestMapping(value = "/addCareerInfo", method = RequestMethod.POST)
	public ModelAndView addCareerInfo(Career career) {
		mav=fm.execute(career, 1);
		return mav;
	}
	
	@RequestMapping(value = "/goMyProfile", method = RequestMethod.GET)
	public ModelAndView profile() {
		mav=new ModelAndView();
		mav.setViewName("profile");
		return mav;
	}
	
	@RequestMapping(value = "/goMySkill", method = RequestMethod.GET)
	public ModelAndView skillInfo() {
		mav=new ModelAndView();
		mav.setViewName("skillInfo");
		return mav;
	}
	
	@RequestMapping(value = "/goMyPortfolio", method = RequestMethod.GET)
	public ModelAndView portfolio() {
		mav=new ModelAndView();
		mav.setViewName("portfolio");
		return mav;
	}
	
	@RequestMapping(value = "/goPortfolioUpdate", method = RequestMethod.GET)
	public ModelAndView portfolioUpdate() {
		mav=new ModelAndView();
		mav.setViewName("portfolioUpdate");
		return mav;
	}
	
}
