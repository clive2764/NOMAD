package com.steppe.nomad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
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

	@RequestMapping(value="/secondCatagory1", method = RequestMethod.POST)
	public ModelAndView secondCatagory1(){
		System.out.println("dd");
		mav = new ModelAndView();
		mav=cm.execute(3); //projectDetail.jsp 프로젝트 상세보기 페이지
		return mav;
	}

	@RequestMapping(value="/secondCatagory2", method = RequestMethod.POST)
	public ModelAndView secondCatagory2(){
		System.out.println("dd");
		mav = new ModelAndView();
		mav=cm.execute(4); //projectDetail.jsp 프로젝트 상세보기 페이지
		return mav;
	}

	@RequestMapping(value="/insertProject", method = RequestMethod.POST)
	public ModelAndView insertProject(MultipartHttpServletRequest multi){
		System.out.println("insertProject");
		mav = new ModelAndView();
		mav=cm.execute(multi,1); //projectDetail.jsp 프로젝트 상세보기 페이지
		return mav;
	}

	//견적문의 페이지로 이동
	@RequestMapping(value="/goInsertEstimate")
	public ModelAndView goInsertEstimate(String mid){
		System.out.println("견적 문의 페이지로 이동");
		mav=new ModelAndView(mid);
		mav=cm.execute(mid,1);
		/*mav.setViewName("estimate");*/
		return mav;
	}

	//견적 문의 요청
	@RequestMapping(value="/sendEstimate")
	public ModelAndView sendEstimate(String mid,String e_title, String e_content){
		System.out.println("견적 문의 보내기");
		mav=new ModelAndView();
		mav=cm.execute(mid, e_title, e_content,1);
		return mav;
	}


}
