package com.steppe.nomad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.steppe.nomad.service.EmailManagement;
import com.steppe.nomad.service.MemberManagement;
@Controller
public class HomeController {

	private ModelAndView mav;
	private EmailManagement em;

	@Autowired
	private MemberManagement mm;	//�럹�씠吏� 泥섏쓬 吏꾩엯�슜
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Model model) {
		mav = new ModelAndView();
		mav.setViewName("home"); //main.jsp 硫붿씤�럹�씠吏�
		return mav;
	}
	//�긽�떒 �뿤�뜑硫붾돱�쓽 硫붿씤�럹�씠吏� 留곹겕�슜
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView home2(Model model) {
		mav = new ModelAndView();
		mav.setViewName("home"); //main.jsp 硫붿씤�럹�씠吏�
		return mav;
	}

	//�쉶�썝媛��엯�슜
	@RequestMapping(value = "/goJoin", method = RequestMethod.GET)
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
	@RequestMapping(value="/goAddProject", method = RequestMethod.GET)
	public ModelAndView goAddProject(){
		mav = new ModelAndView();
		mav.setViewName("projectInsert"); //projectDetail.jsp �봽濡쒖젥�듃 �긽�꽭蹂닿린 �럹�씠吏�
		return mav;
	}

	//�씠硫붿씪 �씤利�
	@RequestMapping(value = "/sendCode", method = RequestMethod.POST)
	public ModelAndView sendCode() {
		System.out.println("ModelAndView sendCode �떆�옉");
		mav = new ModelAndView(); 
		mm.sendCode();
		return mav;
	}

	@RequestMapping(value = "/fstMm", method = RequestMethod.GET)
	public String fstMm(Model model) {
		return "fstMm";
	}

}
