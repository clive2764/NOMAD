package com.steppe.nomad;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.steppe.nomad.bean.Member;
import com.steppe.nomad.bean.Project;
import com.steppe.nomad.service.ClientManagement;
import com.steppe.nomad.service.EmailManagement;
import com.steppe.nomad.service.MemberManagement;
@Controller
@SessionAttributes("member")
public class HomeController {
	@Autowired
	private HttpSession session;
	
	private ModelAndView mav;
	private EmailManagement em;

	@Autowired
	private MemberManagement mm;	//페이지 처음 진입용
	
	@Autowired
	private ClientManagement cm;	

	@RequestMapping(value = "/")
	public ModelAndView home(Model model) {
		mav = new ModelAndView();
		mav.setViewName("home"); //main.jsp 硫붿씤�럹�씠吏�
		return mav;
	}

	//상단 헤더메뉴의 메인페이지 링크용
	@RequestMapping(value = "/main")
	public ModelAndView home2(Model model) {
		mav = new ModelAndView();
		mav.setViewName("home"); //main.jsp 硫붿씤�럹�씠吏�
		return mav;
	}



	//회원가입용
	@RequestMapping(value = "/goJoin")
	public ModelAndView goJoin() {
		mav = new ModelAndView();
		mav.setViewName("join"); //join.jsp �쉶�썝媛��엯 �럹�씠吏�
		return mav;
	}
	@RequestMapping(value="/goProject", method = RequestMethod.GET)
	public ModelAndView goProject(){
		mav = new ModelAndView();
		mav.setViewName("project"); //join.jsp �쉶�썝媛��엯 �럹�씠吏�
		return mav;
	}
	@RequestMapping(value="/goProjectDetail", method = RequestMethod.GET)
	public ModelAndView goProjectDetail(){
		mav = new ModelAndView();
		mav.setViewName("projectDetail"); //projectDetail.jsp �봽濡쒖젥�듃 �긽�꽭蹂닿린 �럹�씠吏�
		return mav;
	}

	//이메일 인증
	@RequestMapping(value = "/sendCode")
	public ModelAndView sendCode() {
		System.out.println("ModelAndView sendCode �떆�옉");
		mav = new ModelAndView(); 
		mm.sendCode();
		return mav;
	}
	
	//로그인 페이지 이동
	@RequestMapping(value = "/goLogin", method = RequestMethod.GET)
	public ModelAndView goLogin() {
		System.out.println("로그인 페이지로 이동");
		mav = new ModelAndView();
		mav.setViewName("login"); //login.jsp 로그인 페이지
		return mav;
	}
	
	//로그인
	@RequestMapping(value = "/access", method = RequestMethod.POST)
	public ModelAndView access(Member mb) {
		System.out.println("mb="+mb.getM_id());
		mav = mm.execute(mb,1);
		return mav;
	}
	
	@RequestMapping(value = "/fstMm", method = RequestMethod.GET)
	public String fstMm(Model model) {
		return "fstMm";
	}
	
	//이용방법 페이지로 이동
	@RequestMapping(value= "/goManual")
	public ModelAndView goManual(){
		System.out.println("이용방법 페이지로 이동");
		mav = new ModelAndView();
		mav.setViewName("manual");
		return mav;
	}
	
	@RequestMapping(value= "/goMyPageCI")
	public ModelAndView goMyPageCI(){
		mav = new ModelAndView();
		mav=cm.execute(3); //projectDetail.jsp 프로젝트 상세보기 페이지
		return mav;
	}
		
		
		
	
	
}
