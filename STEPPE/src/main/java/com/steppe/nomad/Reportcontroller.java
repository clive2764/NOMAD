package com.steppe.nomad;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.steppe.nomad.bean.Report;
import com.steppe.nomad.service.ReportManagement;

@Controller
public class Reportcontroller {
	private ModelAndView mav;

	@Autowired
	private HttpSession session;

	@Autowired
	ReportManagement rm;

	@Autowired
	private HttpServletRequest request;


	//신고작성 페이지로 이동
	@RequestMapping(value ="/goReportWrite")
	public ModelAndView goReportWrite(){
		mav=rm.goReportWrite();
		return mav;
	}
	
	//신고 작성
	@RequestMapping(value="/InsertReport")
	public ModelAndView InsertReport(Report report){
		mav=rm.InsertReport(report);
		return mav;		
	}
	
	//신고글 리스트 페이지로 이동
	@RequestMapping(value="/goReportList")
	public ModelAndView goReportList(){
		mav=rm.showReportList();
		return mav;
	}
	//신고리스트 삭제
	@RequestMapping(value="/deleteReport")
	public ModelAndView deleteReport(){
		mav=rm.deleteReport();
		return mav;
		
	}
	//프로젝트 검색
	@RequestMapping(value="/searchProject")
	public ModelAndView searchProject(){
		mav=rm.searchProject();
		return mav;
	}

}
