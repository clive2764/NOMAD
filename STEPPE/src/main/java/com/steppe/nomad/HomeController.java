package com.steppe.nomad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.steppe.nomad.bean.Member;
import com.steppe.nomad.service.EmailManagement;
import com.steppe.nomad.service.MemberManagement;

@Controller
@SessionAttributes("member")
public class HomeController {

	private ModelAndView mav;
	private EmailManagement em;

	@Autowired
	private MemberManagement mm;	//페이지 처음 진입용
	@RequestMapping(value = "/")
	public ModelAndView home(Model model) {
		mav = new ModelAndView();
		mav.setViewName("home"); //main.jsp 메인페이지
		return mav;
	}
	//상단 헤더메뉴의 메인페이지 링크용
	@RequestMapping(value = "/main")
	public ModelAndView home2(Model model) {
		mav = new ModelAndView();
		mav.setViewName("home"); //main.jsp 메인페이지
		return mav;
	}

	//회원가입용
	@RequestMapping(value = "/goJoin")
	public ModelAndView goJoin() {
		System.out.println("회원가입 페이지로 이동");
		mav = new ModelAndView();
		mav.setViewName("join"); //join.jsp 회원가입 페이지
		return mav;
	}
	@RequestMapping(value="/goProject")
	public ModelAndView goProject(){
		mav = new ModelAndView();
		mav.setViewName("project"); //join.jsp 회원가입 페이지
		return mav;
	}
	@RequestMapping(value="/goProjectDetail")
	public ModelAndView goProjectDetail(){
		mav = new ModelAndView();
		mav.setViewName("projectDetail"); //projectDetail.jsp 프로젝트 상세보기 페이지
		return mav;
	}
	@RequestMapping(value="/goAddProject")
	public ModelAndView goAddProject(){
		mav = new ModelAndView();
		mav.setViewName("projectInsert"); //projectDetail.jsp 프로젝트 상세보기 페이지
		return mav;
	}

	//이메일 인증
	@RequestMapping(value = "/sendCode")
	public ModelAndView sendCode() {
		System.out.println("ModelAndView sendCode 시작");
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
	
}
