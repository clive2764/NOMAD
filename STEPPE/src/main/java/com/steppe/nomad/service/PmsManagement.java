package com.steppe.nomad.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

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
		}
		return mav;
	}
	private void progressUpdate(){
		System.out.println("progressUpdate() 실행");
		mav = new ModelAndView();
		int progNum = Integer.valueOf(request.getParameter("code"));
		int btnNum = Integer.valueOf(request.getParameter("num"));
		System.out.println("progNum:"+progNum);
		System.out.println("btnNum:"+btnNum);
		String view = null;
		
		//수정할 때 프로젝트 번호를 넣어야 한다.
		int updateSuccess = pDao.progressUpdate(progNum);
		/*if(updateSuccess != 0){
			view = ;
		}else{
			view = ;
		}*/
		mav.setViewName("progress");
	}
	
	private void progress() {
		System.out.println("실행");
		mav = new ModelAndView();
		String view = null;
		List<Project> list = null;
		int value = Integer.valueOf(request.getParameter("prog"));	
		int code = 0;
		int progNum;
		/*if(Integer.valueOf(request.getParameter("code")) == null){
		}*/
		//int code = Integer.valueOf(request.getParameter("code"));
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
		
		//int code = Integer.valueOf(request.getParameter("code"));
		//System.out.println("code:"+code);
		mav = new ModelAndView();
		//int value = Integer.valueOf(request.getParameter("prog"));
		//System.out.println("value="+value);
		int progNum = 0;
		/*if(value==0){
			progNum = 0;
			//code = 0;			
		}else if(value==1){
			progNum = 30; 
			//code = 1;
		}else if(value==2){
			progNum = 60;
			//code = 2;
		}else{
			progNum = 100;
			//code = 3;
		}*/
		
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
		/*if(value == 0){
			num = 0;
		}else if(value == 1){
			progNum = 30;
			num = 1;
		}else if(value == 2){
			progNum = 60;
			num = 2;
		}else if(value == 3){
			progNum = 100;
			num = 3;
		}*/ 
		//System.out.println("num="+num);
		for(int i=0; i<list.size(); i++){
			project = list.get(i);
			sb.append(project.getP_title()+"<br/>");
			progNum = project.getP_status();
			/*if(progNum == 0){
				
			}else if(progNum == 1){
				
			}else if(progNum == 2){
				
			}else if(progNum == 3){
				
			}*/
			sb.append("<progress value="+progNum+" max='3'></progress>");
			sb.append("<div class='row'>"
					+ "<div class='col-lg-12'>");
			//sb.append("<form action='progressUpdate' method='get'>");
			sb.append("<select name='prog' id='prog'>");
			sb.append("<option value='0'>전체</option>");
			sb.append("<option value='1'>대기</option>");
			sb.append("<option value='2'>작업중</option>");
			sb.append("<option value='3'>완료</option>");
			sb.append("</select>");
			sb.append("<input type='button' onclick=\"javascript:Ajax2('progressUpdate?num="+(i+1)+"&code=', '#printP')\" id='progressSend' value='전송' />");
			//sb.append("</form>");
			sb.append("</div>"
					+ "</div>");
		}
		return sb.toString();
	}
}