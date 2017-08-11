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
			careerInsert(career);
			break;
		}
		return mav;
	}

	private void careerInsert(Career career) {
		String view = null;
		mav =new ModelAndView();
		//if(ss!=null && ss.getAttribute("id")!=null){
			//
			career.setM_id("id");
			System.out.println("확인"+fDao.getCareerMaxNum()+1);
			//career.setCa_num(fDao.getCareerMaxNum()+1);
			/*career.setCa_num(String.valueOf(fDao.getCareerMaxNum()+1));*/
			career.setCa_term(req.getParameter("ca_term"));
			career.setCa_company(req.getParameter("ca_company"));
			career.setCa_rank(req.getParameter("ca_rank"));
			System.out.println("와우");
			if(fDao.careerInsert(career)!=0){
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
			System.out.println("오우");
			view="home";
		}*/
		mav.setViewName(view);
	}
}
