package com.steppe.nomad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.steppe.nomad.bean.Career;
import com.steppe.nomad.bean.Portfolio;
import com.steppe.nomad.bean.Profile;
import com.steppe.nomad.bean.Skill;
import com.steppe.nomad.service.FreelancerManagement;

@Controller
public class FreelancerController {
	
	@Autowired
	private FreelancerManagement fm;
	private ModelAndView mav;
	
	@RequestMapping(value = "/goMyCareer")
	public ModelAndView goMyCareer() {
		mav = new ModelAndView();
		mav.setViewName("careerInfo");
		return mav;
	}
	
	@RequestMapping(value = "/goMyProfile")
	public ModelAndView goMyProfile() {
		mav = new ModelAndView();
		mav.setViewName("profile");
		return mav;
	}
	
	@RequestMapping(value = "/goMySkill")
	public ModelAndView goMySKill() {
		mav = new ModelAndView();
		mav.setViewName("skillInfo");
		return mav;
	}
	
	@RequestMapping(value = "/goMyPortfolio")
	public ModelAndView portfolio() {
		mav=new ModelAndView();
		mav.setViewName("portfolio");
		return mav;
	}
	
	@RequestMapping(value = "/goPortfolioUpdate")
	public ModelAndView portfolioUpdate() {
		mav=new ModelAndView();
		mav.setViewName("portfolioUpdate");
		return mav;
	}
	
	@RequestMapping(value = "/addCareerInfo")
	public @ResponseBody String addCareerInfo(Career career) {
		String jsonStr=fm.executeAjax(career, 1);
		return jsonStr;
	}
	
	@RequestMapping(value = "/showMyCareer")
	public @ResponseBody String showMyCareer(Career career) {
		String jsonStr=fm.executeAjax(career, 2);
		return jsonStr;
	}
	
	@RequestMapping(value = "/deleteCareerInfo")
	public @ResponseBody String deleteCareerInfo(Career career) {
		String jsonStr=fm.executeAjax(career, 3);
		return jsonStr;
	}
	
	@RequestMapping(value = "/insertProfile")
	public @ResponseBody String insertProfile(Profile profile) {
		String jsonStr=fm.executeAjax(profile, 1);
		return jsonStr;
	}
	
	@RequestMapping(value = "/showMyProfile")
	public @ResponseBody String showMyProfile(Profile profile) {
		String jsonStr=fm.executeAjax(profile, 2);
		return jsonStr;
	}
	
	@RequestMapping(value = "/deleteProfile")
	public @ResponseBody String deleteProfile(Profile profile) {
		String jsonStr=fm.executeAjax(profile, 3);
		return jsonStr;
	}
	
	@RequestMapping(value = "/addSkill")
	public @ResponseBody String addSkill(Skill skill) {
		String jsonStr=fm.executeAjax(skill, 1);
		return jsonStr;
	}
	
	@RequestMapping(value = "/showMySkill")
	public @ResponseBody String showMySkill(Skill skill) {
		String jsonStr=fm.executeAjax(skill, 2);
		return jsonStr;
	}
	
	@RequestMapping(value = "/deleteSkill")
	public @ResponseBody String deleteSkill(Skill skill) {
		String jsonStr=fm.executeAjax(skill, 3);
		return jsonStr;
	}
	
	@RequestMapping(value = "/addPortfolio")
	   public ModelAndView portFolioInsert(MultipartHttpServletRequest multi, @RequestParam("pf_image[]") MultipartFile[] files){
	      System.out.println("실행2");
	      mav = fm.execute(1, multi, files);
	      return mav;
	   }
	
	@RequestMapping(value = "/showPortfolioList")
	public @ResponseBody String showPortfolioList(Portfolio portfolio) {
		String jsonStr=fm.executeAjax(portfolio, 1);
		return jsonStr;
	}
	
	@RequestMapping(value = "/showPortfolioDetail")
	public @ResponseBody String showPortfolioDetail(Portfolio portfolio) {
		String jsonStr=fm.executeAjax(portfolio, 2);
		return jsonStr;
	}
	
	@RequestMapping(value = "/updatePortfolio")
	public ModelAndView updatePortfolio(Portfolio portfolio){
		mav = fm.execute(portfolio, 1);
		return mav;
	}
	
	@RequestMapping(value = "/deletePortfolio")
	public ModelAndView deletePortfolio(Portfolio portfolio){
		mav = fm.execute(portfolio, 2);
		return mav;
	}
	
}
