package com.steppe.nomad.service;

import java.util.HashMap;



import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.steppe.nomad.bean.Catagory;
import com.steppe.nomad.bean.Member;
import com.steppe.nomad.bean.Project;
import com.steppe.nomad.bean.Required_Skill;
import com.steppe.nomad.bean.Volunteer;
import com.steppe.nomad.dao.CatagoryDao;
import com.steppe.nomad.dao.ProjectDao;
import com.steppe.nomad.userClass.UploadFile;
@Repository
public class ClientManagement {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private HttpServletRequest req;
	@Autowired
	private HttpServletResponse res;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired	
	private CatagoryDao cDao;
	
	@Autowired	
	private ProjectDao pDao;

	private ModelAndView mav;
	private String jsonStr;
	
	public ModelAndView execute(int cmd) {
		switch(cmd){
		case 1:
			goAddProject();
			break;
		case 2:
			setRequired_Skill();
			break;
		case 3:
			goMyPageCI();
			break;
		}
		return mav;
	}

/*
	private void secondCatagory2() {
		String view=null;
		mav=new ModelAndView();
		List<Catagory> cList22=null;
		cList22=cDao.getCatagorycList22();
		System.out.println(cList22);
		if(cList22!=null){
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<cList22.size(); i++){
				Catagory ca=cList22.get(i);
				sb.append("<option value='"+ca.getPc2_name()+"'>"+ca.getPc2_name());
				sb.append("</option>");
			}
			mav.addObject("cList2", sb.toString());
		}
		
		List<Required_Skill> slist=null;
		slist=pDao.getRequired_SkillList();
		System.out.println(slist);
		
		if(slist!=null){
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<slist.size(); i++){
				Required_Skill rs=slist.get(i);
				sb.append("<input type='checkbox' value='"+rs.getRs_plnum()+"' name='"+rs.getRs_plnum()+"' id='inter' "
						+ " onClick='CountChecked(this)'/>"+rs.getRs_plnum());
				sb.append("/");
			}
			mav.addObject("slist", sb.toString());
			System.out.println(sb);
		}
		
		view="projectInsert";
		mav.setViewName(view);
		view="projectInsert";
		mav.setViewName(view);
		
	}*/
	
/*
	private void secondCatagory1() {
		String view=null;
		mav=new ModelAndView();
		List<Catagory> cList21=null;
		cList21=cDao.getCatagorycList21();
		if(cList21!=null){
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<cList21.size(); i++){
				Catagory ca=cList21.get(i);
				sb.append("<option value='"+ca.getPc2_name()+"'>"+ca.getPc2_name());
				sb.append("</option>");
			}
			mav.addObject("cList2", sb.toString());
		}
		
		List<Required_Skill> slist=null;
		slist=pDao.getRequired_SkillList();
		System.out.println(slist);
		
		if(slist!=null){
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<slist.size(); i++){
				Required_Skill rs=slist.get(i);
				sb.append("<input type='checkbox' value='"+rs.getRs_plnum()+"' name='"+rs.getRs_plnum()+"' id='inter' "
						+ " onClick='CountChecked(this)'/>"+rs.getRs_plnum());
				sb.append("/");
			}
			mav.addObject("slist", sb.toString());
			System.out.println(sb);
		}
		
		view="projectInsert";
		mav.setViewName(view);
		
		view="projectInsert";
		mav.setViewName(view);
	}*/

	private void goMyPageCI() {
		String view=null;
		mav=new ModelAndView();
		System.out.println("옴");
		
		List<Project> plist=null;
		//Member mb= new Member();
		//if(session!=null && session.getAttribute("m_id")!=null && mb.getM_kind()=="C")//합치면 이것으로
		//plist=pDao.getProjectList(session.getAttribute("m_id"));//합치면 이것으로
		String m_id=session.getAttribute("m_id").toString();
	
		
	
		plist=pDao.getProjectList(m_id);
		System.out.println(plist);
		//sb.append("<td> <a href='#contents_layer' onclick='articleView("+B.getBnum()+")'>"+B.getBtitle()+"</a></td>");
		if(plist!=null){
			StringBuilder sb = new StringBuilder();
			sb.append("<form id='showList' name='showList'>");
			sb.append("<table border='1' align='center'>");
			sb.append("<tr><th>번호</th><th>제목</th><th>지원자 수</th><th>상태</th></tr>");
			for(int i=0; i<plist.size(); i++){
				Project p=plist.get(i);
				System.out.println("ddddd");
				sb.append("<tr><td>"+p.getP_num()+"</td>");
				sb.append("<td><onclick='showApplyList("+p.getP_num()+")'>"+p.getP_title()+"</td>");
				sb.append("<td>"+p.getP_vol()+"</td>");
				sb.append("<td>"+p.getP_status2()+"</td></tr>");
			}
			sb.append("</table>");
			sb.append("</form>");
			System.out.println(sb);
			mav.addObject("plist", sb.toString());
		}
		view="myPageCI";
		mav.setViewName(view);
	}

	private void setRequired_Skill() {
		String view=null;
		mav=new ModelAndView();
		List<Required_Skill> slist=null;
		slist=pDao.getRequired_SkillList();
		System.out.println(slist);
		
		if(slist!=null){
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<slist.size(); i++){
				Required_Skill rs=slist.get(i);
				sb.append("<input type='checkbox' value='"+rs.getRs_plnum()+"' name='p_plnum' id='inter'"
						+ " onClick='CountChecked(this)'/>"+rs.getRs_plnum());
				sb.append("/");
			}
			mav.addObject("slist", sb.toString());
			System.out.println(sb);
		}
		view="projectInsert";
		mav.setViewName(view);
		}

		//setRequired_Skill();
		//view="projectInsert";
		//mav.setViewName(view);
		/*
		List<Required_Skill> slist=null;
		slist=pDao.getRequired_SkillList();
		System.out.println(slist);
		
		if(slist!=null){
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<slist.size(); i++){
				Required_Skill rs=slist.get(i);
				sb.append("<input type='checkbox' value='"+rs.getRs_plnum()+"' name='"+rs.getRs_plnum()+"' id='inter' "
						+ " onClick='CountChecked(this)'/>"+rs.getRs_plnum());
				sb.append("/");
			}
			mav.addObject("slist", sb.toString());
			System.out.println(sb);
		}*/
		
		//view="projectInsert";
		//mav.setViewName(view);
	//}

	private void goAddProject() {
		String view=null;
		mav=new ModelAndView();
		view="redirect:/firstCatagory";
		mav.setViewName(view);
		
	}

	public ModelAndView execute(MultipartHttpServletRequest multi, int cmd) {
		switch(cmd){
		case 1:
			insertProject(multi);
			break;
		
		}
		return mav;
	}

	private void insertProject(MultipartHttpServletRequest multi) {
		String pc1_name=multi.getParameter("pc1_name");
		String pc2_name=multi.getParameter("pc2_name");
		//String p_mid="client";
		//String p_mid=session.getAttribute("m_id").toString();
		int p_budget=Integer.parseInt(multi.getParameter("p_budget"));
		String p_term=multi.getParameter("p_term");
		String p_title=multi.getParameter("p_title");
		String p_content=multi.getParameter("p_content");
		int check=Integer.parseInt(multi.getParameter("fileCheck"));//확인
		String p_deadline=multi.getParameter("p_deadline");
		String p_plnum0=multi.getParameter("p_plnum0");
		String p_plnum1=multi.getParameter("p_plnum1");
		String p_plnum2=multi.getParameter("p_plnum2");
		int p_person=Integer.parseInt(multi.getParameter("p_person"));
		session.setAttribute("m_id", "client");
		System.out.println("check="+check);//1이면 첨부됨
		Map<Object,Object> fMap=new HashMap<Object, Object>();
		if(check==1){
			UploadFile upload=new UploadFile();
			//서버에 파일을 업로드 한 뒤, 
			//오리지널 파일명, 시스템 파일명을 리턴 후 Map에 저장
			fMap=upload.fileUp(multi);//
			System.out.println(fMap);
		}
		Project project=new Project();
		project.setP_num(pDao.getProjectMaxNum()+1);
		project.setP_pc1name(pc1_name);
		project.setP_pc2name(pc2_name);
		project.setP_mid("client");
		project.setP_budget(p_budget);
		project.setP_term(p_term);
		project.setP_title(p_title);
		project.setP_content(p_content);
		project.setP_deadline(p_deadline);
		project.setP_plnum0(p_plnum0);
		project.setP_plnum1(p_plnum1);
		project.setP_plnum2(p_plnum2);
		project.setP_person(p_person);
		project.setP_status(0);
		
		fMap.put("p_num", project.getP_num());
		fMap.put("pc1_name", project.getP_pc1name());
		fMap.put("pc2_name", project.getP_pc2name());
		fMap.put("p_mid",project.getP_mid());
		fMap.put("p_budget",project.getP_budget());
		fMap.put("p_term", project.getP_term());
		fMap.put("p_title", project.getP_title());
		fMap.put("p_content", project.getP_content());
		fMap.put("p_deadline", project.getP_deadline());
		fMap.put("p_plnum0", project.getP_plnum0());
		fMap.put("p_plnum1", project.getP_plnum1());
		fMap.put("p_plnum2", project.getP_plnum2());
		fMap.put("p_person", project.getP_person());
		fMap.put("p_status", project.getP_status());
		mav=new ModelAndView();
		String view=null;
		System.out.println(fMap);
		
		if(pDao.insertProject(fMap)!=0){
			view="redirect:goMyPageCI";
			
		}else{
			view="redirect:goAddProject";
		}
		mav.setViewName(view);
	}

	public ModelAndView execute(int cmd, Project pr) {
		switch(cmd){
		case 1:
			showApplyList(pr);
			break;
		}
		return null;
	}

	private void showApplyList(Project pr) {
		mav=new ModelAndView();
		String view=null;
		List<Volunteer> vList=null;
	}

	
	
}
