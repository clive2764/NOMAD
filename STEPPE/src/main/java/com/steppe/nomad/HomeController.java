package com.steppe.nomad;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
<<<<<<< HEAD
import org.springframework.web.multipart.MultipartHttpServletRequest;
=======
>>>>>>> d317d85d5485a6cb7d4cf31b037b3a3bce5efc3a
import org.springframework.web.servlet.ModelAndView;

import com.steppe.nomad.bean.Member;
import com.steppe.nomad.bean.Notice;
import com.steppe.nomad.service.AdminManagement;
import com.steppe.nomad.service.MemberManagement;
@Controller
public class HomeController {

	private ModelAndView mav;
	
	@Autowired
	private HttpSession session;//request.getSession();

	@Autowired
<<<<<<< HEAD
	private AdminManagement am;
	
	@Autowired
=======

>>>>>>> d317d85d5485a6cb7d4cf31b037b3a3bce5efc3a
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
<<<<<<< HEAD
		mav.setViewName("projectInsert"); //goAddProject.jsp 프로젝트 상세보기 페이지
=======
		mav.setViewName("projectInsert"); //projectDetail.jsp �봽濡쒖젥�듃 �긽�꽭蹂닿린 �럹�씠吏�
>>>>>>> d317d85d5485a6cb7d4cf31b037b3a3bce5efc3a
		return mav;
	}

	//이메일 인증
<<<<<<< HEAD
	@RequestMapping(value = "/sendCode", method = RequestMethod.POST)
	public ModelAndView sendCode() throws Exception {
=======
	@RequestMapping(value = "/sendCode")
	public ModelAndView sendCode() {
		System.out.println("ModelAndView sendCode �떆�옉");
>>>>>>> d317d85d5485a6cb7d4cf31b037b3a3bce5efc3a
		mav = new ModelAndView(); 
		mm.sendCode();
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
<<<<<<< HEAD

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


=======
	
>>>>>>> d317d85d5485a6cb7d4cf31b037b3a3bce5efc3a
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
