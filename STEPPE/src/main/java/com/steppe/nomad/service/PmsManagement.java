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
		}
		return mav;
	}
	private void progress() {
		System.out.println("실행");
		mav = new ModelAndView();
		String view = null;
		List<Project> list = null;
		int value = Integer.valueOf(request.getParameter("prog"));	
		int code;
		//int 
		/*if(Integer.valueOf(request.getParameter("code")) == null){
			
		}*/
		//int code = Integer.valueOf(request.getParameter("code"));
		if(value==0){
			code = 0;			
		}else if(value==1){
			code = 1;
		}else if(value==2){
			code = 2;
		}else{
			code = 3;
		}
		System.out.println("value="+value);
		list = pDao.showProcess(code);
		System.out.println("code:"+code);
		String makeShowList = makeProjectList(list);
		System.out.println(makeShowList);
		/*if(code == 0){
			view = "progress";
		}else if(code == 1){
			view = "progress";
		}else if(code == 2){
			view = "progress";
		}else if(code == 3){
			view = "progress";
		}*/
		mav.addObject("makeShowList", makeShowList);
		mav.setViewName("progress");
	}

	private void showProcess(Project project) {
		String view = null;
		List<Project> list = null;
		//int code = Integer.valueOf(request.getParameter("code"));
		//System.out.println("code:"+code);
		mav = new ModelAndView();
		int flag = 0;
		list = pDao.showProcess(flag);
		String makeList = makeProjectList(list);
		mav.addObject("makeList", makeList);
		mav.setViewName("pms");
	}
	public String makeProjectList(List<Project> list){
		StringBuilder sb = new StringBuilder();
		Project project = null;
		for(int i=0; i<list.size(); i++){
			project = list.get(i);
			sb.append(project.getP_content()+"<br/>");
			sb.append("<progress value=50 max='100'></progress>");
			
		}
		return sb.toString();
	}
}