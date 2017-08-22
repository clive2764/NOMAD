package com.steppe.nomad;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.steppe.nomad.bean.Member;
import com.steppe.nomad.service.AdminManagement;
import com.steppe.nomad.service.MemberManagement;
@Controller
public class HomeController {

	private ModelAndView mav;
	
	@Autowired
	private HttpSession session;//request.getSession();

	@Autowired
	private AdminManagement am;
	
	@Autowired
	private MemberManagement mm;	//페이지 처음 진입용

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

	@RequestMapping(value="/goAddProject")
	public ModelAndView goAddProject(){
		mav = new ModelAndView();

		mav.setViewName("projectInsert"); //projectDetail.jsp �봽濡쒖젥�듃 �긽�꽭蹂닿린 �럹�씠吏�
		return mav;
	}

	//이메일 인증

	@RequestMapping(value = "/sendCode")
	public ModelAndView sendCode() {
		System.out.println("ModelAndView sendCode �떆�옉");
		mav = new ModelAndView(); 
		try {
			mm.sendCode();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mav;
	}

	//공지사항 페이지 이동
	@RequestMapping(value = "/goNotice", method = RequestMethod.GET)
	public ModelAndView goNotice() {
		System.out.println("공지사항 페이지로 이동");
		mav = new ModelAndView();
		//mav.setViewName("notice"); //notice.jsp 로그인 페이지
		mav = am.execute(1);
		return mav;
	}
	
	//공지사항쓰기 페이지 이동
	@RequestMapping(value = "/noticeWrite")
	public ModelAndView noticeWrite() {
		System.out.println("공지사항 페이지로 이동");
		if(session!=null && session.getAttribute("id")!=null&&session.getAttribute("id").equals("admin")){
		mav = new ModelAndView();
		mav.setViewName("noticeWrite"); //noticeWrite.jsp 로그인 페이지
		}
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
	//로그아웃
	@RequestMapping(value = "/logout")
	public ModelAndView logout(Member mb) {
		System.out.println("로그아웃");
		mav = mm.execute(mb,2);
		return mav;
	}

	//회원가입
	@RequestMapping(value = "/memberInsert", method = RequestMethod.POST)
	public ModelAndView memberInsert(MultipartHttpServletRequest multi) {
		mav = mm.execute(multi,1);
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
		System.out.println("마이 페이지로 이동");
		mav = new ModelAndView();
		mav.setViewName("myPageCI");
		return mav;
	}
	
	
}
