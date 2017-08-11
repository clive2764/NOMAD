package com.steppe.nomad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.steppe.nomad.service.ClientManagement;


@Controller
public class ClientController {

	private ModelAndView mav;
	@Autowired
	private ClientManagement cm;
	
	@RequestMapping(value="/goAddProject", method = RequestMethod.GET)
	public ModelAndView goAddProject(){
		mav = new ModelAndView();
		mav=cm.execute(1); //projectDetail.jsp 프로젝트 상세보기 페이지
		return mav;
	}
	
	@RequestMapping(value="/firstCatagory", method = RequestMethod.GET)
	public ModelAndView firstCatagory(){
		mav = new ModelAndView();
		mav=cm.execute(2); //projectDetail.jsp 프로젝트 상세보기 페이지
		return mav;
	}
	
	@RequestMapping(value="/secondCatagory", method = RequestMethod.GET)
	public ModelAndView secondCatagory(){
		System.out.println("dd");
		mav = new ModelAndView();
		mav=cm.execute(3); //projectDetail.jsp 프로젝트 상세보기 페이지
		return mav;
	}
	
}
