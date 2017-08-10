package com.steppe.nomad.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.steppe.nomad.bean.Test;
import com.steppe.nomad.dao.TestDao;

@Component
public class FstManagrment implements Action{
	@Autowired
	private TestDao tDao;
	@Autowired
	private HttpSession ss;
	@Autowired
	private HttpServletRequest req;
	
	
	private ModelAndView mav;
	

	public ModelAndView execute(Test test, int cmd) {
		switch(cmd){
		case 1 :
			showFstList(test);
			break;
		}
		return mav;
	}
	
	@Override
	public ModelAndView execute(int cmd) {
		switch(cmd){
		case 1 :
			showFstDetail();
			break;
		}
		return mav;
	}
	private void showFstDetail() {
		String view = null;
		mav= new ModelAndView();
		String t_num = req.getParameter("t_num");
		mav.addObject("test",tDao.showFstDetail(t_num));
		view = "fstDetail";
		mav.setViewName(view);
	}

	private void showFstList(Test test) {
		mav=new ModelAndView();
		String view = null;
		List<Test> tlist = null;
		String t_name = req.getParameter("FstList");
		System.out.println(t_name);
		tlist = tDao.getTestList(t_name);
		System.out.println(tlist);
		if(tlist!=null){
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<tlist.size(); i++){
				Test t=tlist.get(i);
				sb.append("<tr><td>"+t.getT_num()+"</td>");
				sb.append("<td><a href='showFstDetail?t_num="+t.getT_num()+"'>"+t.getT_content()+"</a></td>");
				sb.append("<td>"+t.getT_answer()+"</td>");
				sb.append("<td>"+"삭제"+"</td></tr>");
			}
			mav.addObject("tlist", sb.toString());
		}
		view="fstMm";
		mav.setViewName(view);
	}

}
