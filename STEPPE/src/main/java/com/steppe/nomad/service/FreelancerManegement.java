package com.steppe.nomad.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.steppe.nomad.bean.Career;
import com.steppe.nomad.bean.Profile;
import com.steppe.nomad.bean.Test;
import com.steppe.nomad.dao.FreelancerDao;

@Service
public class FreelancerManegement {
	@Autowired	
	private FreelancerDao fDao;
	@Autowired
	private HttpSession ss; //request.getSession();
	@Autowired
	private HttpServletRequest req; //request.getSession();
	@Autowired
	private SqlSessionTemplate sqlSession;

	private ModelAndView mav;
	private String jsonStr;

	public ModelAndView execute(Career career,int cmd) {
		switch(cmd){
		case 1 :
			showCareer(career);
			break;
		case 2 :
			insertCareer(career);
			break;
		case 3 :
			deleteCareer(career);
			break;
		}
		return mav;
	}
	
	public ModelAndView execute(Profile profile, int cmd) {
		switch(cmd){
		case 1 :
			showProfile(profile);
			break;
		case 2 :
			insertProfile(profile);
			break;
		}
		return mav;
	}

	private void insertProfile(Profile profile) {
		
	}

	private void showProfile(Profile profile) {
		mav=new ModelAndView();
		String view = null;
		List<Profile> plist = null;
		int pro_num = Integer.parseInt(req.getParameter("pro_num"));
		System.out.println(pro_num);
		plist = fDao.getProfileList(pro_num);
		System.out.println(plist);
		if(plist!=null){
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<plist.size(); i++){
				Profile p=plist.get(i);
				sb.append("<tr><td>"+p.getPro_num()+"</td>");
				sb.append("<td><a href='goMyProfile?pro_num="+p.getPro_num()+"'>"+p.getM_name()+"</a></td>");
				sb.append("<td>"+p.getM_image()+"</td>");
				sb.append("<td>"+p.getPro_content()+"</td></tr>");
			}
			mav.addObject("plist", sb.toString());
		}
		view="profile";
		mav.setViewName(view);
	}

	private void insertCareer(Career career) {
		String view = null;
		mav =new ModelAndView();
		//if(ss!=null && ss.getAttribute("id")!=null){
		//
		career.setM_id("id");
		System.out.println("Ȯ��"+fDao.getCareerMaxNum()+1);
		//career.setCa_num(fDao.getCareerMaxNum()+1);
		/*career.setCa_num(String.valueOf(fDao.getCareerMaxNum()+1));*/
		career.setCa_term(req.getParameter("ca_term"));
		career.setCa_company(req.getParameter("ca_company"));
		career.setCa_rank(req.getParameter("ca_rank"));
		System.out.println("�Ϳ�");
		if(fDao.insertCareer(career)!=0){
			/*//
				List<Career> clist =fDao.getCareerList(canum);
				Gson jsonObj=new Gson();
				jsonStr = jsonObj.toJson(clist);
				System.out.println("jsonStr : "+jsonStr);
				//jsonObj=new HashMap<String,List<Reply>>();
				//jsonObj.put("rlist", rlist); //hashMap
			 */				mav.addObject("check",1);
			 view = "careerInfo";
		}
		/*}else{//
			System.out.println("����");
			view="home";
		}*/
		mav.setViewName(view);
	}

	private void deleteCareer(Career career) {
		String view=null;
		mav=new ModelAndView();
		//if(ss!=null && ss.getAttribute("id")!=null){
		int canum=Integer.parseInt(req.getParameter("ca_num"));
		/*int c=Delete(bnum);
		if(r!=0 && b!=0){ //댓글 및 원글 삭제 성공시
			view="redirect:boardlist";
		}else{
			view="redirect:boardlist";
		}
*/
		mav.setViewName(view);
	}
	private void showCareer(Career career) {
		mav=new ModelAndView();
		String view = null;
		List<Career> clist = null;
		int ca_num = Integer.parseInt(req.getParameter("ca_num"));
		System.out.println(ca_num);
		clist = fDao.getCareerList(ca_num);
		System.out.println(clist);
		if(clist!=null){
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<clist.size(); i++){
				Career c=clist.get(i);
				sb.append("<tr><td>"+c.getCa_num()+"</td>");
				sb.append("<td><a href='goMyCareer?Ca_num="+c.getCa_num()+"'>"+c.getCa_term()+"</a></td>");
				sb.append("<td>"+c.getCa_company()+"</td>");
				sb.append("<td>"+c.getCa_rank()+"</td>");
				sb.append("<td>"+"삭제"+"</td></tr>");
			}
			mav.addObject("clist", sb.toString());
		}
		view="careerInfo";
		mav.setViewName(view);
	}

}