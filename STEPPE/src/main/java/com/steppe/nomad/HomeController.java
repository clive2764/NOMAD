package com.steppe.nomad;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	private ModelAndView mav;
	//페이지 처음 진입용
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Model model) {
		mav = new ModelAndView();
		mav.setViewName("home"); //main.jsp 메인페이지
		return mav;
	}
	//상단 헤더메뉴의 메인페이지 링크용
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView home2(Model model) {
		mav = new ModelAndView();
		mav.setViewName("home"); //main.jsp 메인페이지
		return mav;
	}

	//회원가입용
	@RequestMapping(value = "/goJoin", method = RequestMethod.GET)
	public ModelAndView goJoin() {
		mav = new ModelAndView();
		mav.setViewName("join"); //join.jsp 회원가입 페이지
		return mav;
	}
	@RequestMapping(value="/goProject", method = RequestMethod.GET)
	public ModelAndView goProject(){
		mav = new ModelAndView();
		mav.setViewName("project"); //join.jsp 회원가입 페이지
		return mav;
	}
	@RequestMapping(value="/goProjectDetail", method = RequestMethod.GET)
	public ModelAndView goProjectDetail(){
		mav = new ModelAndView();
		mav.setViewName("projectDetail"); //projectDetail.jsp 프로젝트 상세보기 페이지
		return mav;
	}
	@RequestMapping(value="/goAddProject", method = RequestMethod.GET)
	public ModelAndView goAddProject(){
		mav = new ModelAndView();
		mav.setViewName("projectInsert"); //projectDetail.jsp 프로젝트 상세보기 페이지
		return mav;
	}

}
