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
		case 2 :
			insertFst();
			break;
		case 3 :
			goUpdateFst();
			break;
		case 4 :
			updateFst();
			break;
		case 5 :
			deleteFst();
			break;
		}
		return mav;
	}
	
	private void deleteFst() {
		String view = null;
		mav = new ModelAndView();
		int t_num = Integer.parseInt(req.getParameter("t_num"));
		if(tDao.deleteFst(t_num)!=0){
			System.out.println("문제 삭제 성공");
		}else{
			System.out.println("문제 삭제 실패");
		}
		view = "fstMm";
		mav.setViewName(view);
	}

	private void updateFst() {
		String view = null;
		mav = new ModelAndView();
		Test test = new Test();
		int t_answer = Integer.parseInt(req.getParameter("t_answer"));
		int t_num = Integer.parseInt(req.getParameter("t_num"));
		test.setT_num(t_num);
		test.setT_name(req.getParameter("t_name"));
		test.setT_content(req.getParameter("t_content"));
		test.setT_answer(t_answer);
		test.setT_no1(req.getParameter("t_no1"));
		test.setT_no2(req.getParameter("t_no2"));
		test.setT_no3(req.getParameter("t_no3"));
		test.setT_no4(req.getParameter("t_no4"));
		if(tDao.updateFst(test)!=0){
			System.out.println("문제수정성공");
			view = "fstMm";
		}else{
			System.out.println("문제수정실패");
			view = "fstMm";
		}
		mav.setViewName(view);
	}

	private void goUpdateFst() {
		String view = null;
		mav= new ModelAndView();
		int t_num = Integer.parseInt(req.getParameter("t_num"));
		mav.addObject("test",tDao.showFstDetail(t_num));
		view = "fstUpdate";
		mav.setViewName(view);
	}

	private void insertFst() {
		String view = null;
		mav = new ModelAndView();
		Test test = new Test();
		int t_answer = Integer.parseInt(req.getParameter("t_answer"));
		test.setT_num(tDao.getTestMaxNum()+1);
		test.setT_name(req.getParameter("t_name"));
		test.setT_content(req.getParameter("t_content"));
		test.setT_answer(t_answer);
		test.setT_no1(req.getParameter("t_no1"));
		test.setT_no2(req.getParameter("t_no2"));
		test.setT_no3(req.getParameter("t_no3"));
		test.setT_no4(req.getParameter("t_no4"));
		System.out.println(test);
		if(tDao.insertFst(test)!=0){
			System.out.println("문제추가성공");
			view = "fstMm";
		}else{
			System.out.println("문제추가실패");
			view = "fstMm";
		}
		mav.setViewName(view);
	}

	private void showFstDetail() {
		String view = null;
		mav= new ModelAndView();
		int t_num = Integer.parseInt(req.getParameter("t_num"));
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
				sb.append("<td><a href='goUpdateFst?t_num="+t.getT_num()+"'>수정</a></td></tr>");
			}
			mav.addObject("tlist", sb.toString());
		}
		view="fstMm";
		mav.setViewName(view);
	}

}
