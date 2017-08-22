package com.steppe.nomad.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.steppe.nomad.bean.Career;
import com.steppe.nomad.bean.Member;
import com.steppe.nomad.bean.Portfolio;
import com.steppe.nomad.bean.Profile;
import com.steppe.nomad.bean.Skill;
import com.steppe.nomad.dao.FreelancerDao;
import com.steppe.nomad.userClass.UploadFile;

@Service
public class FreelancerManagement {
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

	public String executeAjax(Career career, int cmd) {
		switch(cmd){
		case 1 :
			insertCareer(career);
			break;
		case 2 :
			showCareer(career);
			break;
		case 3 :
			deleteCareer(career);
			break;
		}
		return jsonStr;	
	}

	public String executeAjax(Profile profile, int cmd) {
		switch(cmd){
		case 1 :
			insertProfile(profile);
			break;
		case 2 :
			showProfile(profile);
			break;
		case 3 :
			deleteProfile(profile);
			break;
		}
		return jsonStr;	
	}

	public String executeAjax(Skill skill, int cmd) {
		switch(cmd){
		case 1 :
			addSkill(skill);
			break;
		case 2 :
			showSkill(skill);
			break;
		case 3 :
			deleteSkill(skill);
		}
		return jsonStr;
	}

	public String executeAjax(Portfolio portfolio, int cmd) {
		switch(cmd){
		case 1 :
			showPortfolioList(portfolio);
			break;
		case 2 :
			showPortfolioDetail(portfolio);
			break;
		}
		return jsonStr;
	}

	public ModelAndView execute(int cmd, MultipartHttpServletRequest multi, MultipartFile[] files) {
		switch(cmd){
		case 1: insertPortfolio(multi, files);
		break;
		}
		return mav;
	}

	public ModelAndView execute(Portfolio portfolio, int cmd) {
		switch(cmd){
		case 1: 
			updatePortfolio(portfolio);
			break;
		case 2: 
			deletePortfolio(portfolio);
			break;
		}
		return mav;
	}

	private void addSkill(Skill skill) {
		String view = null;
		mav =new ModelAndView();
		if(ss!=null && ss.getAttribute("m_id")!=null){
			String id = (String) ss.getAttribute("m_id");
			skill.setSk_num(fDao.getSkillMaxNum()+1);
			skill.setM_id(id);
			skill.setSk_name(req.getParameter("sk_name"));
			System.out.println(req.getParameter("sk_name"));
			skill.setSk_grade(req.getParameter("sk_grade"));
			System.out.println(req.getParameter("sk_grade"));
			skill.setSk_career(req.getParameter("sk_career"));
			System.out.println(req.getParameter("sk_career"));
			if(fDao.insertSkill(skill)!=0){
				List<Skill> sklist = fDao.getSkillList(id);
				System.out.println(sklist);
				Gson jsonObj=new Gson();
				jsonStr = jsonObj.toJson(sklist);
				System.out.println("jsonStr : "+jsonStr);
				//jsonObj=new HashMap<String,List<Reply>>();
				//jsonObj.put("rlist", rlist); //hashMap에 저장
			}

		}else{
			System.out.println("실패");
			view="skillInfo";
		}
	}

	private void showSkill(Skill skill) {
		mav=new ModelAndView();
		String view = null;
		List<Skill> sklist = null;
		System.out.println("기술정보 들어옴");
		if(ss!=null && ss.getAttribute("m_id")!=null){
			String m_id = (String) ss.getAttribute("m_id");
			System.out.println(m_id);
			sklist = fDao.getSkillList(m_id);
			System.out.println(sklist);
			if(sklist!=null){
				Gson jsonObj=new Gson();
				jsonStr = jsonObj.toJson(sklist);
				System.out.println("jsonStr : "+jsonStr);
				mav.addObject("slist",jsonStr);
				view = "skillInfo";
			}
		}
		view="skillInfo";
		mav.setViewName(view);
	}

	private void deleteSkill(Skill skill) {
		System.out.println("기술정보 삭제 들어옴");
		String view=null;
		mav=new ModelAndView();
		if(ss!=null && ss.getAttribute("m_id")!=null){
			int sk_num=Integer.parseInt(req.getParameter("num"));
			if(fDao.deleteSKill(sk_num)!=0){
				System.out.println("기술정보 삭제 성공");
			}else{
				System.out.println("기술정보 삭제 실패");
			}
			view="skillInfo";
			mav.setViewName(view);
		}
	}

	private void insertProfile(Profile profile) {
		String view = null;
		mav =new ModelAndView();
		if(ss!=null && ss.getAttribute("m_id")!=null){
			String id = (String) ss.getAttribute("m_id");
			profile.setPro_num(fDao.getProfileMaxNum()+1);
			profile.setM_id(id);
			System.out.println(id);
			profile.setPro_content(req.getParameter("pro_content"));
			System.out.println(req.getParameter("pro_content"));
			if(fDao.insertProfile(profile)!=0){
				List<Profile> prlist = fDao.getProfileList(id);
				System.out.println(prlist);
				Gson jsonObj=new Gson();
				jsonStr = jsonObj.toJson(prlist);
				System.out.println("jsonStr : "+jsonStr);
				//jsonObj=new HashMap<String,List<Reply>>();
				//jsonObj.put("rlist", rlist); //hashMap에 저장
			}

		}else{
			System.out.println("실패");
			view="profile";
		}
	}

	private void showProfile(Profile profile) {
		mav=new ModelAndView();
		String view = null;
		List<Profile> prlist = null;
		System.out.println("프로필들어옴");
		if(ss!=null && ss.getAttribute("m_id")!=null){
			String m_id = (String) ss.getAttribute("m_id");
			System.out.println(m_id);
			prlist = fDao.getProfileList(m_id);
			System.out.println(prlist);
			if(prlist!=null){
				Gson jsonObj=new Gson();
				jsonStr = jsonObj.toJson(prlist);
				System.out.println("jsonStr : "+jsonStr);
				mav.addObject("prlist",jsonStr);
				view = "profile";
				/*StringBuilder sb = new StringBuilder();
				for(int i=0; i<prlist.size(); i++){
					Profile pr=prlist.get(i);
					sb.append("<tr><td>"+c.getCa_num()+"</td>");
					sb.append("<tr><td>"+pr.getM_name()+"</td>");
					sb.append("<td>"+pr.getM_image()+"</td>");
					sb.append("<td>"+pr.getPro_content()+"</td></tr>");
				}
				mav.addObject("prlist", sb.toString());*/
			}
			view="profile";
			mav.setViewName(view);
		}
	}

	private void deleteProfile(Profile profile) {
		System.out.println("프로필 삭제 들어옴");
		String view=null;
		mav=new ModelAndView();
		if(ss!=null && ss.getAttribute("m_id")!=null){
			int pro_num=Integer.parseInt(req.getParameter("num"));
			if(fDao.deleteProfile(pro_num)!=0){
				System.out.println("프로필 삭제 성공");
			}else{
				System.out.println("프로필 삭제 실패");
			}
			view="profile";
			mav.setViewName(view);
		}
	}

	private void insertCareer(Career career) {
		System.out.println("경력인서트들어옴");
		String view = null;
		mav =new ModelAndView();
		if(ss!=null && ss.getAttribute("m_id")!=null){
			String id = (String) ss.getAttribute("m_id");
			career.setCa_num(fDao.getCareerMaxNum()+1);
			/*career.setCa_num(String.valueOf(fDao.getCareerMaxNum()+1));*/
			career.setM_id(id.toString());
			career.setCa_term(req.getParameter("ca_term"));
			career.setCa_company(req.getParameter("ca_company"));
			career.setCa_rank(req.getParameter("ca_rank"));
			System.out.println("ca_rank="+req.getParameter("ca_rank"));
			if(fDao.insertCareer(career)!=0){
				List<Career> clist = fDao.getCareerList(id);
				Gson jsonObj=new Gson();
				jsonStr = jsonObj.toJson(clist);
				System.out.println("jsonStr : "+jsonStr);
				//jsonObj=new HashMap<String,List<Reply>>();
				//jsonObj.put("rlist", rlist); //hashMap에 저장
				mav.addObject("clist",jsonStr);
				view = "careerInfo";
			}

		}else{
			System.out.println("실패");
			view="careerInfo";
		}
	}

	private void showCareer(Career career) {
		mav=new ModelAndView();
		String view = null;
		List<Career> clist = null;
		System.out.println("경력 출력 들어옴");
		if(ss!=null && ss.getAttribute("m_id")!=null){
			String m_id = (String) ss.getAttribute("m_id");
			System.out.println(m_id);
			clist = fDao.getCareerList(m_id);
			System.out.println(clist);
			if(clist!=null){
				Gson jsonObj=new Gson();
				jsonStr = jsonObj.toJson(clist);
				System.out.println("jsonStr : "+jsonStr);
				//jsonObj=new HashMap<String,List<Reply>>();
				//jsonObj.put("rlist", rlist); //hashMap에 저장
				mav.addObject("clist",jsonStr);
				view = "careerInfo";
				/*StringBuilder sb = new StringBuilder();
				for(int i=0; i<clist.size(); i++){
					Career c=clist.get(i);
					sb.append("<tr><td>"+c.getCa_num()+"</td>");
					sb.append("<tr><td>"+c.getCa_term()+"</td>");
					sb.append("<td>"+c.getCa_company()+"</td>");
					sb.append("<td>"+c.getCa_rank()+"</td>");
					sb.append("<td><a href='deleteCareerInfo?Ca_num="+c.getCa_num()+"'>"+"삭제"+"</a></td></tr>");
				}
				mav.addObject("clist", sb.toString());*/
			}
			view="careerInfo";
			mav.setViewName(view);
		}
	}

	private void deleteCareer(Career career) {
		System.out.println("경력 삭제 들어옴");
		String view=null;
		mav=new ModelAndView();
		if(ss!=null && ss.getAttribute("m_id")!=null){
			int ca_num=Integer.parseInt(req.getParameter("num"));
			if(fDao.deleteCareer(ca_num)!=0){
				System.out.println("경력 삭제 성공");
			}else{
				System.out.println("경력 삭제 실패");
			}
			view="careerInfo";
			mav.setViewName(view);
		}
	}

	private void insertPortfolio(MultipartHttpServletRequest multi, MultipartFile[] files) {
		mav = new ModelAndView();
		String view = null;
		//MultipartFile[] files = request.getParameter("pf_image[]");
		if(ss!=null && ss.getAttribute("m_id")!=null){
		String pf_mid = (String) ss.getAttribute("m_id");
		String pf_title = multi.getParameter("pf_title");
		String pf_term = multi.getParameter("pf_term");
		String pf_contribute = multi.getParameter("pf_contribute");
		String pf_content = multi.getParameter("pf_content");
		//int check = Integer.parseInt(multi.getParameter(""))
		//Map<String, Object> pfMap = null;
		UploadFile upload = new UploadFile();
		//pfMap = upload.fileUp(multi);
		//List<Map<String, Object>> mapList = upload.fileUp(multi, files);
		List<String> mapList = upload.fileUp(multi, files);
		Portfolio portfolio = new Portfolio();
		portfolio.setPf_mid(pf_mid);
		if(fDao.getPortfolioCount()!=0){
			portfolio.setPf_num(fDao.getPortfolioCount()+1);
		}else{
			portfolio.setPf_num(1);
		}
		portfolio.setPf_title(pf_title);
		portfolio.setPf_term(pf_term);
		portfolio.setPf_contribute(pf_contribute);
		portfolio.setPf_content(pf_content);
		//insert 값 부족
		System.out.println("portfolio num:"+ portfolio.getPf_num());
		if(fDao.insertPortfolio(portfolio)!=0){
			List<Portfolio> pflist = fDao.getPortfolioList(pf_mid);
			Gson jsonObj=new Gson();
			jsonStr = jsonObj.toJson(pflist);
			System.out.println("jsonStr : "+jsonStr);
			//jsonObj=new HashMap<String,List<Reply>>();
			//jsonObj.put("rlist", rlist); //hashMap에 저장
			mav.addObject("pflist",jsonStr);
			view = "portfolio";
		}
		//pfDao.portFolioInsert(portfolio);
		int pfNum = fDao.getPortfolioMaxNum();
		fDao.portfolioFileInsert(mapList,pfNum);
		System.out.println(mapList);
		mav.setViewName("portfolio");
		}
	}
	
	private void showPortfolioList(Portfolio portfolio) {
		mav=new ModelAndView();
		String view = null;
		List<Portfolio> pflist = null;
		System.out.println("포트폴리오 출력 들어옴");
		if(ss!=null && ss.getAttribute("m_id")!=null){
			String m_id = (String) ss.getAttribute("m_id");
			System.out.println(m_id);
			pflist = fDao.getPortfolioList(m_id);
			System.out.println(pflist);
			if(pflist!=null){
				Gson jsonObj=new Gson();
				jsonStr = jsonObj.toJson(pflist);
				System.out.println("jsonStr : "+jsonStr);
				//jsonObj=new HashMap<String,List<Reply>>();
				//jsonObj.put("rlist", rlist); //hashMap에 저장
				/*StringBuilder sb = new StringBuilder();
				for(int i=0; i<clist.size(); i++){
					Career c=clist.get(i);
					sb.append("<tr><td>"+c.getCa_num()+"</td>");
					sb.append("<tr><td>"+c.getCa_term()+"</td>");
					sb.append("<td>"+c.getCa_company()+"</td>");
					sb.append("<td>"+c.getCa_rank()+"</td>");
					sb.append("<td><a href='deleteCareerInfo?Ca_num="+c.getCa_num()+"'>"+"삭제"+"</a></td></tr>");
				}
				mav.addObject("clist", sb.toString());*/
			}
		}
	}

	private void showPortfolioDetail(Portfolio portfolio) {
		mav=new ModelAndView();
		String view = null;
		List<Portfolio> pflist = null;
		System.out.println("포트폴리오 상세 들어옴");
		if(ss!=null && ss.getAttribute("m_id")!=null){
			int pf_num = Integer.parseInt(req.getParameter("num"));
			System.out.println(pf_num);
			if(fDao.getPortfolioDetail(pf_num)!=0){
				StringBuilder sb=new StringBuilder();
				sb.append("<table class='table table-striped' style='text-align:center; color:black;'");
				sb.append("<tr>");
				sb.append("<th style='text-align:center;'>"+"제목"+"</th>");
				sb.append("<th style='text-align:center;'>"+"기간"+"</th>");
				sb.append("<th style='text-align:center;'>"+"참여율"+"</th>");
				sb.append("<th style='text-align:center;'>"+"내용"+"</th>");
				sb.append("<th style='text-align:center;'>"+"포트폴리오"+"</th>");
				sb.append("</tr>");
				for(int i=0; i<pflist.size(); i++){
					Portfolio p=pflist.get(i);
					sb.append("<tr>");
					sb.append("<td>"+p.getPf_title()+"</td>");
					sb.append("<td>"+p.getPf_term()+"</td>");
					sb.append("<td>"+p.getPf_contribute()+"</td>");
					sb.append("<td>"+p.getPf_content()+"</td>");
					sb.append("<td>"+p.getPt_sysname()+"</td>");
					sb.append("</tr>");
				}
				sb.append("</table>");
				mav.addObject("portfolio",sb.toString());	
				System.out.println("대따");
			}
			view="portfolio";
			mav.setViewName(view);
		}
	}

	private void updatePortfolio(Portfolio portfolio) {

	}

	private void deletePortfolio(Portfolio portfolio) {
		System.out.println("포트폴리오 삭제 들어옴");
		String view=null;
		mav=new ModelAndView();
		if(ss!=null && ss.getAttribute("m_id")!=null){
			int pf_num=Integer.parseInt(req.getParameter("num"));
			if(fDao.deleteCareer(pf_num)!=0){
				System.out.println("포트폴리오 삭제 성공");
			}else{
				System.out.println("포트폴리오 삭제 실패");
			}
			view="portfolioUpdate";
			mav.setViewName(view);
		}
	}
	
	//프리랜서 상세보기내 경력정보 추출 메소드
	   private void showFreelancerCareer(Career career) {
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
	   
	   //프리랜서 페이지 프리랜서 리스트 표출 메소드
	   public ModelAndView showList() {
	      mav=new ModelAndView();
	      String view=null;
	      List<Member> flist=null;
	      flist=fDao.getFreelancer();
	      if(flist!=null){
	         StringBuilder sb=new StringBuilder();
	         sb.append("<div class='container'>");
	         sb.append("<div class='row'>");
	         sb.append("<form style='float: right' action='searchKeywordFr' id='searchForm' method='get'>");
	         sb.append("<input type='text' id='keyword' name='keyword' placeholder='프리랜서 이름'/>");
	         sb.append("<input type='button' id='search' value='검색'>");
	         sb.append("</form>");
	         sb.append("</div>");
	         for(int i=0; i<flist.size(); i++){
	            Member f=flist.get(i);
	            sb.append("<div class='col-md-3 col-sm-6 hero-feature'>");
	            sb.append("<div class='thumbnail'>");
	            sb.append("<img src='resources/upload/"+f.getMf_sysname()+"' alt=''>");
	            System.out.println(f.getMf_sysname());
	            sb.append("<div class='caption'>");
	            sb.append("<h3 style='text-align:center;'>"+f.getM_name()+"</h3>");
	            sb.append("<p style='text-align:center;'>"+f.getM_email()+"</p>");
	            sb.append("<p style='text-align:center;'><a style='color:white;' class='btn btn-default' href='goFreelancerDetail?m_id="+f.getM_id()+"'>"+"상세보기"+"</a>"+"</p>");
	            sb.append("</div>");
	            sb.append("</div>");
	            sb.append("</div>");
	         }
	         sb.append("</div>");
	         mav.addObject("flist", sb.toString());
	      }

	      view="freelancer";
	      mav.setViewName(view);
	      return mav;

	   }

	   //프리랜서 상세보기 메소드
	   public ModelAndView showDetail() {

	      mav=new ModelAndView();
	      String view=null;
	      String m_id=(String)req.getParameter("m_id");
	      List<Career> career=null;
	      System.out.println(m_id);
	      //fDao.getFreelancerDetail(m_id);
	      mav.addObject("photo",fDao.getProfilePhoto(m_id));
	      mav.addObject("freelancer",fDao.getFreelancerDetail(m_id));
	      career = fDao.getCareer(m_id);
	      FreelancerManagement showFreelancerCareer;
	      if(career!=null){
	         StringBuilder sb=new StringBuilder();
	         sb.append("<table class='table table-striped' style='text-align:center; color:black;'");
	         sb.append("<tr>");
	         sb.append("<th style='text-align:center;'>"+"경력"+"</th>");
	         sb.append("<th style='text-align:center;'>"+"회사"+"</th>");
	         sb.append("<th style='text-align:center;'>"+"직급"+"</th>");
	         sb.append("</tr>");
	         for(int i=0; i<career.size(); i++){
	            Career c=career.get(i);
	            sb.append("<tr>");
	            sb.append("<td>"+c.getCa_term()+"</td>");
	            sb.append("<td>"+c.getCa_company()+"</td>");
	            sb.append("<td>"+c.getCa_rank()+"</td>");
	            sb.append("</tr>");
	         }
	         sb.append("</table>");
	         mav.addObject("career",sb.toString());   
	      }
	      view="freelancerDetail";
	      mav.setViewName(view);

	      return mav;
	   }

	   //프리랜서 페이지에서 검색 메소드
	   public ModelAndView searchFreelancer() {
	      mav=new ModelAndView();
	      String view=null;
	      String keyword=req.getParameter("keyword");
	      System.out.println(keyword);
	      List<Member> slist=null;
	      slist=fDao.getSearchResult(keyword);
	      System.out.println("검색결과:"+slist);
	      if(slist!=null){
	         StringBuilder sb=new StringBuilder();
	         sb.append("<div class='container'>");
	         sb.append("<div class='row'>");
	         sb.append("<form style='float: right' action='searchKeywordFr' id='searchForm' method='get'>");
	         sb.append("<input type='text' id='keyword' name='keyword' placeholder='프리랜서 이름'/>");
	         sb.append("<input type='button' id='search' value='검색'>");
	         sb.append("</form>");
	         sb.append("</div>");
	         for(int i=0; i<slist.size(); i++){
	            Member r=slist.get(i);
	            sb.append("<div class='col-md-3 col-sm-6 hero-feature'>");
	            sb.append("<div class='thumbnail'>");
	            sb.append("<img src='resources/upload/"+r.getMf_sysname()+"' alt=''>");
	            
	            sb.append("<div class='caption'>");
	            sb.append("<h3 style='text-align:center;'>"+r.getM_name()+"</h3>");
	            sb.append("<p style='text-align:center;'>"+r.getM_email()+"</p>");
	            sb.append("<p style='text-align:center;'><a style='color:white;' class='btn btn-default' href='goFreelancerDetail?m_id="+r.getM_id()+"'>"+"상세보기"+"</a>"+"</p>");
	            sb.append("</div>");
	            sb.append("</div>");
	            sb.append("</div>");
	         }
	         sb.append("</div>");
	         mav.addObject("slist", sb.toString());
	      }
	      view="freelancer";
	      mav.setViewName(view);
	      return mav;
	   }
}


