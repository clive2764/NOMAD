package com.steppe.nomad;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.steppe.nomad.bean.Accounting;
import com.steppe.nomad.bean.Project;
import com.steppe.nomad.service.ClientManagement;
import com.steppe.nomad.service.PmsManagement;


@Controller
public class ClientController {

	private ModelAndView mav;
	@Autowired
	private ClientManagement cm;
	
	@Autowired
	private PmsManagement pmm;
	
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
	
	@RequestMapping(value="/insertProject", method = RequestMethod.POST)
	public ModelAndView insertProject(MultipartHttpServletRequest multi){
		System.out.println("insertProject");
		mav = new ModelAndView();
		mav=cm.execute(multi,1); //projectDetail.jsp 프로젝트 상세보기 페이지
		return mav;
	}
	
	@RequestMapping(value="/showProcessAll")
	public ModelAndView goPms(Project project){
		System.out.println("showProcessAll() 메서드 실행");
		mav = new ModelAndView();
		mav=pmm.execute(1, project); 
		return mav;
	}
	
	@RequestMapping(value="/showApplyList")
	public ModelAndView showApplyList(){
		System.out.println("showApplyList 메서드 실행");
		mav = new ModelAndView();
		mav=cm.execute(4);
		return mav;
	}
	
	@RequestMapping(value="/pickMember")
	public ModelAndView pickMember(){
		System.out.println("pickMember 메서드 실행");
		mav = new ModelAndView();
		mav=cm.execute(5);
		return mav;
	}
	
	@RequestMapping(value="/deleteProject")
	public ModelAndView deleteProject(){
		System.out.println("deleteProject 메서드 실행");
		mav = new ModelAndView();
		mav=cm.execute(6);
		return mav;
	}
	
	@RequestMapping(value="/purchase")
	public ModelAndView purchase(Accounting ac){
		System.out.println("Purchase 메서드 실행");
		mav = new ModelAndView();
		mav=cm.execute(ac,1);
		return mav;
	}

}