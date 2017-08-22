package com.steppe.nomad.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.steppe.nomad.bean.Member;
import com.steppe.nomad.bean.Project;
import com.steppe.nomad.bean.Report;
import com.steppe.nomad.dao.ReportDao;

@Service
public class ReportManagement {
	
	@Autowired
	private ReportDao rDao;
	
	private ModelAndView mav;

	@Autowired
	private HttpSession session;
	
	
	@Autowired
	private HttpServletRequest request;

	//신고 작성 페이지로 이동
	public ModelAndView goReportWrite() {
		mav = new ModelAndView();
		String view=null;
		String m_id=(String) session.getAttribute("m_id");
		
		if(m_id==null){
			view="redirect:/";
			mav.setViewName(view);
		}
		if(m_id!=null){
			
				String user=request.getParameter("m_id");
				String reportUrl=request.getHeader("REFERER");
				System.out.println("이전주소:"+reportUrl);
				System.out.println("신고유저명:"+user);
				mav.addObject("user2",user);
				mav.addObject("reportUrl",reportUrl);
				view="reportWrite";
				mav.setViewName(view);
			
			
		}
		return mav;
	}

	//신고작성
	public ModelAndView InsertReport(Report report) {
		mav = new ModelAndView();
		String view=null;
		
		String m_id=(String) session.getAttribute("m_id");
		report.setR_mid(m_id);
		String r_url=request.getParameter("r_url");
		report.setR_url(r_url);
		String r_kind=request.getParameter("r_kind");
		report.setR_kind(r_kind);
		String r_content=request.getParameter("r_contents");
		report.setR_content(r_content);
		System.out.println(m_id);
		int r_num = rDao.getMaxNum()+1;
		report.setR_num(r_num);
		
		rDao.insertReport(report);
			view="redirect:/goFreelancer";
			mav.setViewName(view);
		
	
		
		return mav;
	}
	//신고 리스트 표출
	public ModelAndView showReportList() {
		mav=new ModelAndView();
		String view=null;
		String m_id=(String)session.getAttribute("m_id");
		String m_kind=(String)session.getAttribute("m_kind");
		System.out.println(m_kind);
		List<Report>rlist=null;
		rlist =rDao.getReportList();
		if(rlist!=null){
			if(m_id.equals("admin")){
				StringBuilder sb=new StringBuilder();
				sb.append("<div class='container' style='text-align:center;'>");
				sb.append("<table class='table table-striped' style='text-align:center; color:black;'");
				sb.append("<tr>");
				sb.append("<th style='text-align:center;'>"+"글 번호"+"</th>");
				sb.append("<th style='text-align:center;'>신고자</th>");
				sb.append("<th style='text-align:center;'>"+"신고종류"+"</th>");
				sb.append("<th style='text-align:center;'>"+"신고내용"+"</th>");
				sb.append("<th style='text-align:center;'>"+"신고대상 주소 "+"</th>");
				sb.append("<th style='text-align:center;'>"+"삭제"+"</th>");
				for(int i=0; i<rlist.size(); i++){
					Report r=rlist.get(i);
					sb.append("<tr>");
					sb.append("<td>"+r.getR_num()+"</td>");
					sb.append("<td>"+r.getR_mid()+"</td>");
					sb.append("<td>"+r.getR_kind()+"</td>");
					sb.append("<td>"+r.getR_content()+"</td>");
					sb.append("<td>"+"<a href="+r.getR_url()+">"+"페이지 이동"+"</a>"+"</td>");
					sb.append("<td>"+"<a href='deleteReport?r_num="+r.getR_num()+"'>"+"<input type='button' value='삭제'>"+"</a>"+"</td>");
					sb.append("</tr>");
				}
				sb.append("</table>");
				sb.append("</div>");
				view="report";
				mav.addObject("rlist",sb.toString());
				mav.setViewName(view);
			}
			else{
				view="home";
				mav.setViewName(view);
			}
		}

		return mav;
	}

	public ModelAndView showProjectList() {
		mav=new ModelAndView();
		String view=null;
		List<Project> plist=null;
		
		plist=rDao.getProjectList();
		if(plist!=null){
			StringBuilder sb=new StringBuilder();
			sb.append("<div class='container'>");
			sb.append("<div class='row'>");
			sb.append("<form action='searchProjectList' id='search' class='pull-right'>");
			sb.append("<input type='text' id='keyword'  name='keyword' placeholder='프로젝트명을 입력하세요'/>");
			sb.append("<input type='button' id='searchBtn' value='검색'>");
			sb.append("</form>");
			sb.append("</div>");
			for(int i=0; i<plist.size(); i++){
				Project p=plist.get(i);
				sb.append("<div class='col-sm-4 col-lg-4 col-md-4'>");
				sb.append("<div class='thumbnail'>");
				sb.append("<a href='goProjectDetail?p_num="+p.getP_num()+"'>");
				sb.append("<img src='http://placehold.it/320x150' alt=''>");
				sb.append("</a>");
				sb.append("<div class='caption'>");
				sb.append("<h4>"+"<a href='goProjectDetail?p_num="+p.getP_num()+"'>"+p.getP_title()+"</a></h4>");
				sb.append("<span calss='pull-right'>"+p.getP_vol()+"</span>");
				sb.append("<p>"+p.getP_plnum0()+","+p.getP_plnum1()+","+p.getP_plnum2()+"</p>");
				sb.append("</div>");
				sb.append("</div>");
				sb.append("</div>");
			}
			sb.append("</div>");
			mav.addObject("plist",sb.toString());
		}
		view="project";
		mav.setViewName(view);
		return mav;
		
	}
	//프로젝트 상세 페이지
	public ModelAndView showProjcetDetail() {
		mav=new ModelAndView();
		String view=null;
		//프로젝트 번호
		int p_num=Integer.parseInt(request.getParameter("p_num"));
		rDao.getProjectDetail(p_num);
		mav.addObject("project",rDao.getProjectDetail(p_num));
		view="projectDetail";
		mav.setViewName(view);
		return mav;
	}
	//신고 삭제
	public ModelAndView deleteReport() {
		mav=new ModelAndView();
		String view=null;
		int r_num=Integer.parseInt(request.getParameter("r_num"));
		rDao.deleteReport(r_num);
		view="redirect:/goReportList";
		mav.setViewName(view);
		return mav;
	}
	//프로젝트 검색
	public ModelAndView searchProjectList() {
		mav = new ModelAndView();
		String view=null;
		String keyowrd=request.getParameter("keyword");
		List<Project> splist=null;
		splist=rDao.searchProject(keyowrd);
		if(splist!=null){
			StringBuilder sb = new StringBuilder();
			sb.append("<div class='container'>");
			sb.append("<div class='row'>");
			sb.append("<form action='searchProjectList' id='search' class='pull-right'>");
			sb.append("<input type='text' id='keyword' name='keyword' placeholder='프로젝트명을 입력하세요'/>");
			sb.append("<input type='button' id='searchBtn' value='검색'>");
			sb.append("</form>");
			sb.append("</div>");
			for(int i=0;i<splist.size();i++){
				Project p=splist.get(i);
				sb.append("<div class='col-sm-6 col-lg-6 col-md-6'>");
				sb.append("<div class='thumbnail'>");
				sb.append("<a href='goProjectDetail?p_num="+p.getP_num()+"'>");
				sb.append("<img src='http://placehold.it/320x150' alt=''>");
				sb.append("</a>");
				sb.append("<div class='caption'>");
				sb.append("<h4>"+"<a href='goProjectDetail?p_num="+p.getP_num()+"'>"+p.getP_title()+"</a></h4>");
				sb.append("<span calss='pull-right'>"+p.getP_vol()+"</span>");
				sb.append("<p>"+p.getP_plnum0()+","+p.getP_plnum1()+","+p.getP_plnum2()+"</p>");
				sb.append("</div>");
				sb.append("</div>");
				sb.append("</div>");
			}
			sb.append("</div>");
			mav.addObject("splist",sb.toString());
		}
		view="project";
		mav.setViewName(view);
		return mav;

	}
	
}
