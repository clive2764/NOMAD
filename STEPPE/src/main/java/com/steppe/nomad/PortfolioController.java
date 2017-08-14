package com.steppe.nomad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.steppe.nomad.service.PortfolioManagement;

@Controller
public class PortfolioController {
	private ModelAndView mav;
	@Autowired
	private PortfolioManagement pfmm ;
	
	@RequestMapping(value = "/portFolio")
	public ModelAndView portFolio(){
		System.out.println("실행");
		mav = pfmm.execute(1);
		return mav;
	}
	@RequestMapping(value = "/portFolioInsert")
	public ModelAndView portFolioInsert(MultipartHttpServletRequest multi){
		mav = pfmm.execute(2);
		return mav;
	}

}
