package com.steppe.nomad.service;

import java.util.ArrayList;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.steppe.nomad.bean.Catagory;
import com.steppe.nomad.dao.CatagoryDao;
import com.steppe.nomad.dao.FreelancerDao;


@Repository
public class ClientManagement {

	@Autowired
	private HttpSession ss;
	
	@Autowired
	private HttpServletRequest req;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired	
	private CatagoryDao cDao;

	private ModelAndView mav;
	private String jsonStr;
	
	public ModelAndView execute(int cmd) {
		switch(cmd){
		case 1:
			goAddProject();
			break;
		
		case 2:
			firstCatagory();
			break;
		case 3:
			secondCatagory();
			break;
		}
		return mav;
	}

	private void secondCatagory() {
		String view=null;
		mav=new ModelAndView();
		int selectedValue=Integer.parseInt(req.getParameter("selectedValue"));
		System.out.println(selectedValue);
		List<Catagory> cList2=null;
		cList2=cDao.getCatagorycList2(selectedValue);
		System.out.println(cList2);
		if(cList2!=null){
			StringBuilder sb = new StringBuilder();
		}
	}

	private void firstCatagory() {
		String view=null;
		mav=new ModelAndView();
		//Catagory ca= new Catagory();
		List<Catagory> cList1=null;
		cList1=cDao.getCatagorycList1();
		if(cList1!=null){
			StringBuilder sb = new StringBuilder();
			sb.append("<option value='1차 카테고리'>1차 카테고리</option>");
			for(int i=0; i<cList1.size(); i++){
				Catagory ca=cList1.get(i);
				sb.append("<option value='"+ca.getPc1_id()+"'>"+ca.getPc1_name());
				sb.append("</option>");
			}
			mav.addObject("cList1", sb.toString());
		}
		view="projectInsert";
		mav.setViewName(view);
	}

	private void goAddProject() {
		String view=null;
		mav=new ModelAndView();
		view="redirect:/firstCatagory";
		mav.setViewName(view);
		
	}
	
	
}
