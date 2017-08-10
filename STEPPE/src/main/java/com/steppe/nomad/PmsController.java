package com.steppe.nomad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.steppe.nomad.bean.Project;
import com.steppe.nomad.service.PmsManagement;

@Controller
public class PmsController {
	private ModelAndView mav;
	@Autowired
	private PmsManagement pmm;
	@RequestMapping(value = "/showProcessAll", method = RequestMethod.GET)
	public ModelAndView showProcessAll(Project project){
		System.out.println("showProcessAll() 메소드 실행");
		mav = pmm.execute(1, project);
		return mav;
	}
	@RequestMapping(value = "/progress", method = RequestMethod.GET)
	public ModelAndView progress(){
		System.out.println("progress() 메소드 실행");
		mav = pmm.execute(1);
		return mav;
	}
}