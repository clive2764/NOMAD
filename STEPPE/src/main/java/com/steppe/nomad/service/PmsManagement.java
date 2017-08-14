package com.steppe.nomad.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.steppe.nomad.bean.Member;
import com.steppe.nomad.bean.Project;
import com.steppe.nomad.dao.ProjectDao;

@Service
public class PmsManagement {
	private ModelAndView mav;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpSession session;
	@Autowired
	private ProjectDao pDao;
	private String jsonStr;
	private Map<String, Integer> map = new HashMap<String, Integer>();
	public ModelAndView execute(int code, Project project) {
		if(code == 1){
			showProcess(project);
		}else if(code == 2){
		}
		return mav;
	}
	
	public ModelAndView execute(int code){
		if(code==1){
			progress();
		}else if(code==2){
			progressUpdate();
		}else if(code==3){
			showMyProjectList();
		}else if(code==4){
			deleteTeamMember();
		}
		return mav;
	}
	private void deleteTeamMember() {
		mav = new ModelAndView();
		String mid = request.getParameter("mid");
		pDao.deleteTeamMember(mid);
		mav.setViewName("redirect:showMyProjectList");
	}
	public String executeAjax(int code){
		if(code==1){
			showMyMemberList();
		}
		return jsonStr;
	}
	private void showMyMemberList() {
		mav = new ModelAndView();
		Map<Object, Object> mapList = new HashMap<Object, Object>();
		String title = request.getParameter("title");
		String pNum = request.getParameter("pNum");
		System.out.println("pNum="+pNum);
		mapList.put("title", title);
		mapList.put("pNum", pNum);
		List<Member> memberList = pDao.showMyMemberList(mapList);
		//String makeMemberList = makeMemberList(memberList);
		Gson jsonObj = new Gson();
		jsonStr = jsonObj.toJson(memberList);
		//mav.addObject("memberList",makeMemberList);
		//mav.setViewName("");
	}

	private String makeMemberList(List<Project> memberList) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<memberList.size(); i++){
			
		}
		return sb.toString();
	}

	private void showMyProjectList() {
		mav = new ModelAndView();
		//session.getAttribute("");
		
		List<Project> list = pDao.showMyProjectList("test2");
		String makeList = makeMyProjectList(list);
		mav.addObject("makeList", makeList);
		mav.setViewName("team");
	}

	private String makeMyProjectList(List<Project> list) {
		StringBuilder sb = new StringBuilder();
		Project project = null;
		sb.append("<select id='sBox' onchange='Ajax(this)'> ");
		sb.append("<option>선택해 주세요.</option>");
		for(int i=0; i<list.size(); i++){
			project = list.get(i);
			sb.append("<option value='"+project.getP_num()+"'>"+project.getP_title()+"</option>");
		}
		sb.append("</select>");
		return sb.toString();
	}

	private void progressUpdate(){
		System.out.println("progressUpdate() 실행");
		mav = new ModelAndView();
		int progNum = Integer.valueOf(request.getParameter("code"));
		int btnNum = Integer.valueOf(request.getParameter("num"));
		System.out.println("progNum:"+progNum);
		System.out.println("btnNum:"+btnNum);
		String view = null;
		//pDao.progressSelect();
		//수정할 때 프로젝트 번호를 넣어야 한다.
		map.put("progNum", progNum);
		map.put("btnNum", btnNum);
		pDao.progressUpdate(map);
		
		mav.setViewName("showProcessAll");
	}
	
	private void progress() {
		System.out.println("실행");
		mav = new ModelAndView();
		String view = null;
		List<Project> list = null;
		int value = Integer.valueOf(request.getParameter("prog"));	
		int code = 0;
		int progNum;

		if(value==0){
			progNum = 30;
			code = 0;			
		}else if(value==1){
			progNum = 30; 
			code = 1;
		}else if(value==2){
			progNum = 60;
			code = 2;
		}else if(value==3){
			progNum = 100;
			code = 3;
		}
		list = pDao.showProcess(code);
		String makeShowList = makeProjectList(list, value);
		
		mav.addObject("makeShowList", makeShowList);
		mav.setViewName("progress");
	}

	private void showProcess(Project project) {
		System.out.println("showProcess() 실행");
		String view = null;
		List<Project> list = null;
		
		mav = new ModelAndView();

		int progNum = 0;
		
		list = pDao.showProcess(progNum);
		String makeList = makeProjectList(list, progNum);
		mav.addObject("makeList", makeList);
		mav.setViewName("pms");
	}
	
	public String makeProjectList(List<Project> list, int value){
		StringBuilder sb = new StringBuilder();
		Project project = null;
		System.out.println("value="+value);
		int num = 0;
		int progNum = 0;

		int number = 0;
		for(int i=0; i<list.size(); i++){
			project = list.get(i);
			sb.append(project.getP_title()+"<br/>");
			progNum = project.getP_status();
		
			sb.append("<progress value="+progNum+" max='3'></progress>");
			sb.append("<div class='row'>"
					+ "<div class='col-lg-12'>");
			sb.append("<select name='prog' id='prog"+number+"'>");
			sb.append("<option value='0'>전체</option>");
			sb.append("<option value='1'>대기</option>");
			sb.append("<option value='2'>작업중</option>");
			sb.append("<option value='3'>완료</option>");
			sb.append("</select>");
			sb.append("<input type='button' onclick=\"javascript:Ajax2('progressUpdate?num="+project.getP_num()+"&code=', '#printP', 'prog"+number+"')\" id='progressSend' value='전송' />");
			sb.append("</div>"
					+ "</div>");
			number++;
		}
		number = 0;
		return sb.toString();
	}
}