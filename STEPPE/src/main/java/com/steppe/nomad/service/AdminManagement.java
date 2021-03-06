package com.steppe.nomad.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.steppe.nomad.userClass.Paging;
import com.steppe.nomad.bean.Member;
import com.steppe.nomad.bean.Notice;
import com.steppe.nomad.bean.Project;
import com.steppe.nomad.dao.AdminDao;
import com.steppe.nomad.dao.MemberDao;
import com.steppe.nomad.dao.ProjectDao;

@Service
public class AdminManagement {

	int code;
	Notice nt=null;

	@Autowired
	private HttpSession session;//request.getSession();

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private HttpServletResponse response;

	//싱글톤
	@Autowired
	private AdminDao aDao;

	//싱글톤
	@Autowired
	private MemberDao mDao;

	//싱글톤
	@Autowired
	private ProjectDao pDao;

	private ModelAndView mav;

	public ModelAndView execute(Notice nt, int cmd) {
		switch (cmd) {
		case 1:
			noticeInsert(nt);//공지사항 입력
			break;
		case 2:
			noticeUpdate(nt);//공지사항 수정
			break;
		default:
			break;
		}
		return mav;
	}

	public ModelAndView execute(int nnum,int cmd) {
		switch (cmd) {
		case 1:
			noticeDelete(nnum);
			break;
		case 2:
			goNoticeUpdate(nnum);
			break;
			/*case 3:
			noticeUpdate(nnum);
			break;*/
		case 4:
			goNoticeDetail(nnum);
			break;
		default:
			break;
		}
		return mav;
	}

	public ModelAndView execute(int cmd) {
		switch (cmd) {
		case 1:
			getNoticeList();
			break;
		case 2:
			getMemberList();
			break;
		case 3:
			getBlackList();
			break;
		case 4:
			getClientList();
			break;
		case 5:
			getFreeLancerList();
			break;
		case 6:
			getProjectList();
			break;
		case 7:
			getDevelopList();
			break;
		case 8:
			getDesignList();
			break;
		default:
			break;
		}
		return mav;
	}

	public ModelAndView execute(String mid, int cmd) {
		switch (cmd) {
		case 1:
			addBlackList(mid);
			break;
		case 2:
			goBlackUpdate(mid);
			break;
		case 3:
			memberDelete(mid);
			break;
		default:
			break;
		}
		return mav;
	}

	public ModelAndView executes(int pnum, int cmd) {
		switch (cmd) {
		case 1:
			projectDelete(pnum);
			break;
		default:
			break;
		}
		return mav;
	}


	//회원 삭제
	private void memberDelete(String m_id) {
		mav = new ModelAndView();

		m_id = request.getParameter("m_id");
		System.out.println("m_id="+m_id);
		mDao.memberDelete(m_id);

		mav.setViewName("memberMM");
		getMemberList();
	}

	//공지사항 입력
	private void noticeInsert(Notice nt) {
		mav = new ModelAndView();
		String view = null;
		int nnum;
		String mname;
		String id = (String) session.getAttribute("m_id").toString();
		System.out.println("id="+id);
		String ntitle = request.getParameter("n_title");
		System.out.println("n_title = "+ntitle);
		String ncontent = request.getParameter("n_content");
		System.out.println("n_content = "+ncontent);


		Notice notice = new Notice();
		notice.setN_mid(id);
		/*		nnum = notice.setN_num(aDao.getNoticeMaxNum(nt)+1);
		mname = notice.setN_mname(aDao.getName(id));*/
		notice.setN_num(aDao.getNoticeMaxNum(nt)+1);
		notice.setN_mname(aDao.getName(id));
		notice.setN_title(ntitle);
		notice.setN_content(ncontent);


		if(aDao.noticeInsert(notice)!=0){//true 성공하면
			view = "notice";//성공하면 공지사항 페이지
			//mav.addObject("check",1);//회원가입 성공
			getNoticeList();
		}else{//false 실패시
			view = "noticeWrite";
		}
		mav.setViewName(view);


	}

	//공지사항 리스트 출력
	private void getNoticeList() {
		mav = new ModelAndView();
		List<Notice> nlist =null;

		int pageNum = (request.getParameter("pageNum")!=null)
				? Integer.parseInt(request.getParameter("pageNum"))
						: 1;//만약에 게시글이 없을경우 1페이지를 보여준다.
				nlist = aDao.getNoticeList(pageNum);
				StringBuilder sb = new StringBuilder();
				sb.append("<tr><th>글번호</th><th>제목</th><th>작성자</th><th>작성날짜</th>");
				if(session!=null && session.getAttribute("m_id")!=null&&session.getAttribute("m_id").equals("admin")){
					sb.append("<th>수정</th><th>삭제</th></tr>");
				}

				for(int i=0;i<nlist.size();i++){
					Notice nt = nlist.get(i);
					sb.append("<tr>");
					sb.append("<td>"+nt.getN_num()+"</td>");
					sb.append("<td><a href='./goNoticeDetail?nnum="+ nt.getNoticeNum() + "'</a>"+nt.getN_title()+"</td>");
					sb.append("<td>"+nt.getN_mname()+"</td>");
					sb.append("<td>"+nt.getN_date()+"</td>");
					if(session!=null && session.getAttribute("m_id")!=null&&session.getAttribute("m_id").equals("admin")){
						sb.append("<td><input type='button' class='btn' onclick=\"location.href='./goNoticeUpdate?nnum="+ nt.getNoticeNum() + "'\" value='수정'/></td>");
						sb.append("<td><input type='button' class='btn' onclick=\"location.href='./noticeDelete?nnum="+ nt.getNoticeNum() + "'\" value='삭제'/></td>");
					}

					sb.append("</tr>");
				}

				mav.addObject("nlist",sb.toString());

				String pagingHtml = getPagingN(pageNum);
				mav.addObject("paging",getPagingN(pageNum));
				mav.setViewName("notice");



	}

	//공지사항 페이지 번호
	private String getPagingN(int pageNum) { //현재 페이지 번호
		int maxNum = aDao.getNoticeCount(); //전체 게시글의 수
		int listCount = 10; //페이지당 글의 수
		int pageCount = 2; //그룹당 페이지 수
		String boardName = "goNotice";


		Paging paging = new Paging(maxNum,  pageNum,  listCount,  pageCount, boardName);
		return paging.makeHtmlPaging();

	}

	//공지사항 상세 보기
	private String goNoticeDetail(int nnum) {
		mav = new ModelAndView();
		List<Notice> ndlist =null;

		nnum = Integer.parseInt(request.getParameter("nnum"));

		ndlist = aDao.getNoticeDetail(nnum);
		StringBuilder sb = new StringBuilder();
		nt = ndlist.get(0);
		System.out.println("nt.getN_num()="+nt.getN_num());
		System.out.println("nt.getN_title()="+nt.getN_title());

		sb.append("<tr><td>"+nt.getN_num()+"</td><td>"+nt.getN_title()+"</td><td>"+nt.getN_mname()+"</td><td>"+nt.getN_date()+"</td></tr>");
		sb.append("<tr><td colspan='4'>"+nt.getN_content()+"</td></tr>");

		mav.addObject("ndlist",sb.toString());

		mav.setViewName("noticeDetail");
		return null;
	}

	//공지사항 삭제
	private void noticeDelete(int nnum) {
		System.out.println("공지사항 삭제 시작");
		mav = new ModelAndView();

		nnum = Integer.parseInt(request.getParameter("nnum"));
		System.out.println("nnum="+nnum);
		aDao.noticeDelete(nnum);
		mav.setViewName("notice");
		getNoticeList();

	}

	//공지사항 수정 페이지로 이동
	private String goNoticeUpdate(int nnum) {
		mav = new ModelAndView();
		List<Notice> ndlist =null;

		nnum = Integer.parseInt(request.getParameter("nnum"));
		ndlist = aDao.getNoticeDetail(nnum);
		nt = ndlist.get(0);

		int nnums = nt.getN_num();
		System.out.println("nnums="+nnums);
		String ntitle = nt.getN_title();
		System.out.println("ntitle = "+ntitle);
		String ncontent = nt.getN_content();
		System.out.println("ncontent = "+ncontent);

		mav.addObject("ndlist",nt);

		mav.setViewName("noticeUpdate");
		return null;

	}

	//공지사항 수정
	private String noticeUpdate(Notice notice) {
		System.out.println("공지사항 수정");
		mav = new ModelAndView();

		int nnum = nt.getN_num();
		System.out.println("nnum="+nnum);
		String ntitle = notice.getN_title();
		System.out.println("ntitle="+ntitle);
		String ncontent = notice.getN_content();
		System.out.println("ncontent="+ncontent);

		notice.setN_num(nnum);
		notice.setN_title(ntitle);
		notice.setN_content(ncontent);

		aDao.noticeUpdate(notice);


		mav.setViewName("notice");
		getNoticeList();
		return null;

	}

	//회원 리스트 뽑기
	private void getMemberList() {
		System.out.println("getMemberList 시작");
		mav = new ModelAndView();
		List<Member> mlist =null;

		int pageNum = (request.getParameter("pageNum")!=null)
				? Integer.parseInt(request.getParameter("pageNum"))
						: 1;//만약에 게시글이 없을경우 1페이지를 보여준다.
				mlist = mDao.getMemberList(pageNum);
				StringBuilder sb = new StringBuilder();

				for(int i=0;i<mlist.size();i++){
					Member mb = mlist.get(i);
					sb.append("<tr>");
					sb.append("<td>"+mb.getM_id()+"</td>");
					sb.append("<td>"+mb.getM_name()+"</td>");
					sb.append("<td>"+mb.getM_email()+"</td>");
					sb.append("<td>"+mb.getM_kind()+"</td>");
					sb.append("<td>"+mb.getM_status()+"</td>");
					sb.append("<td><input type='button' class='btn' onclick=\"location.href='./memberDelete?m_id="+ mb.getM_id() + "'\" value='삭제'/></td>");
					sb.append("<td><input type='button' class='btn' onclick=\"location.href='./addBlackList?m_id="+ mb.getM_id() + "'\" value='블랙'/></td>");
					sb.append("</tr>");
				}

				mav.addObject("mlist",sb.toString());

				String pagingHtml = getPagingM(pageNum);
				mav.addObject("paging",getPagingM(pageNum));
				mav.setViewName("memberMM");

	}

	//회원관리 페이지 번호
	private String getPagingM(int pageNum) { //현재 페이지 번호
		int maxNum = mDao.getMemberCount(); //전체 게시글의 수
		int listCount = 10; //페이지당 글의 수
		int pageCount = 2; //그룹당 페이지 수


		Paging paging = new Paging(maxNum,  pageNum,  listCount,  pageCount);
		return paging.makeHtmlPaging();

	}

	//블랙리스트 등록
	private String addBlackList(String m_id) {
		mav = new ModelAndView();

		m_id = request.getParameter("m_id");
		System.out.println("m_id="+m_id);
		mDao.addBlackList(m_id);
		mav.setViewName("memberMM");
		getMemberList();
		return null;

	}

	//블랙리스트 보기
	private void getBlackList() {
		System.out.println("getBlackList 시작");
		mav = new ModelAndView();
		List<Member> blist =null;

		int pageNum = (request.getParameter("pageNum")!=null)
				? Integer.parseInt(request.getParameter("pageNum"))
						: 1;//만약에 게시글이 없을경우 1페이지를 보여준다.
				blist = mDao.getBlackList(pageNum);
				StringBuilder sb = new StringBuilder();

				for(int i=0;i<blist.size();i++){
					Member mb = blist.get(i);
					sb.append("<tr>");
					sb.append("<td>"+mb.getM_id()+"</td>");
					sb.append("<td>"+mb.getM_name()+"</td>");
					sb.append("<td>"+mb.getM_email()+"</td>");
					sb.append("<td>"+mb.getM_kind()+"</td>");
					sb.append("<td>"+mb.getM_status()+"</td>");
					sb.append("<td><input type='button' class='btn' onclick=\"location.href='./goBlackUpdate?m_id="+ mb.getM_id() + "'\" value='일반회원전환'/></td>");
					sb.append("</tr>");
				}

				mav.addObject("blist",sb.toString());

				String pagingHtml = getPagingB(pageNum);
				mav.addObject("paging",getPagingB(pageNum));
				mav.setViewName("blackList");

	}

	//블랙리스트 페이지 번호
	private String getPagingB(int pageNum) { //현재 페이지 번호
		int maxNum = aDao.getNoticeCount(); //전체 게시글의 수
		int listCount = 10; //페이지당 글의 수
		int pageCount = 2; //그룹당 페이지 수


		Paging paging = new Paging(maxNum,  pageNum,  listCount,  pageCount);
		return paging.makeHtmlPaging();

	}

	//블랙회원 일반회원으로 전환
	private String goBlackUpdate(String m_id) {
		mav = new ModelAndView();

		m_id = request.getParameter("m_id");
		System.out.println("m_id="+m_id);
		mDao.goBlackUpdate(m_id);
		mav.setViewName("blackList");
		getBlackList();
		return null;

	}

	//클라이언트 리스트 보기
	private void getClientList() {
		System.out.println("getClientList 시작");
		mav = new ModelAndView();
		List<Member> clist =null;

		int pageNum = (request.getParameter("pageNum")!=null)
				? Integer.parseInt(request.getParameter("pageNum"))
						: 1;//만약에 게시글이 없을경우 1페이지를 보여준다.
				clist = mDao.getClientList(pageNum);
				StringBuilder sb = new StringBuilder();

				for(int i=0;i<clist.size();i++){
					Member mb = clist.get(i);
					sb.append("<tr>");
					sb.append("<td>"+mb.getM_id()+"</td>");
					sb.append("<td>"+mb.getM_name()+"</td>");
					sb.append("<td>"+mb.getM_email()+"</td>");
					sb.append("<td>"+mb.getM_kind()+"</td>");
					sb.append("<td>"+mb.getM_status()+"</td>");
					sb.append("<td><input type='button' class='btn' onclick=\"location.href='./memberDelete?m_id="+ mb.getM_id() + "'\" value='삭제'/></td>");
					sb.append("<td><input type='button' class='btn' onclick=\"location.href='./addBlackList?m_id="+ mb.getM_id() + "'\" value='블랙'/></td>");
					sb.append("</tr>");
				}

				mav.addObject("clist",sb.toString());

				String pagingHtml = getPagingC(pageNum);
				mav.addObject("paging",getPagingC(pageNum));
				mav.setViewName("memberMM");

	}

	//클라이언트 리스트 페이지 번호
	private String getPagingC(int pageNum) { //현재 페이지 번호
		int maxNum = aDao.getNoticeCount(); //전체 게시글의 수
		int listCount = 10; //페이지당 글의 수
		int pageCount = 2; //그룹당 페이지 수


		Paging paging = new Paging(maxNum,  pageNum,  listCount,  pageCount);
		return paging.makeHtmlPaging();

	}

	//프리랜서 리스트 보기
	private void getFreeLancerList() {
		System.out.println("getFreeLancerList 시작");
		mav = new ModelAndView();
		List<Member> flist =null;

		int pageNum = (request.getParameter("pageNum")!=null)
				? Integer.parseInt(request.getParameter("pageNum"))
						: 1;//만약에 게시글이 없을경우 1페이지를 보여준다.
				flist = mDao.getFreeLancerList(pageNum);
				StringBuilder sb = new StringBuilder();

				for(int i=0;i<flist.size();i++){
					Member mb = flist.get(i);
					sb.append("<tr>");
					sb.append("<td>"+mb.getM_id()+"</td>");
					sb.append("<td>"+mb.getM_name()+"</td>");
					sb.append("<td>"+mb.getM_email()+"</td>");
					sb.append("<td>"+mb.getM_kind()+"</td>");
					sb.append("<td>"+mb.getM_status()+"</td>");
					sb.append("<td><input type='button' class='btn' onclick=\"location.href='./memberDelete?m_id="+ mb.getM_id() + "'\" value='삭제'/></td>");
					sb.append("<td><input type='button' class='btn' onclick=\"location.href='./addBlackList?m_id="+ mb.getM_id() + "'\" value='블랙'/></td>");
					sb.append("</tr>");
				}

				mav.addObject("flist",sb.toString());

				String pagingHtml = getPagingP(pageNum);
				mav.addObject("paging",getPagingP(pageNum));
				mav.setViewName("memberMM");

	}

	//프리랜서 리스트 페이지 번호
	private String getPagingP(int pageNum) { //현재 페이지 번호
		int maxNum = aDao.getNoticeCount(); //전체 게시글의 수
		int listCount = 10; //페이지당 글의 수
		int pageCount = 2; //그룹당 페이지 수


		Paging paging = new Paging(maxNum,  pageNum,  listCount,  pageCount);
		return paging.makeHtmlPaging();

	}

	//회원 아이디 검색
	public ModelAndView searchMemberId() {
		mav=new ModelAndView();
		String keyword=request.getParameter("keyword");
		System.out.println(keyword);
		List<Member> slist=null;
		slist=mDao.getSearchResult(keyword);

		if(slist!=null){
			StringBuilder sb=new StringBuilder();
			sb.append("<div class='container'>");
			for(int i=0; i<slist.size(); i++){
				Member mb=slist.get(i);
				sb.append("<tr>");
				sb.append("<td>"+mb.getM_id()+"</td>");
				sb.append("<td>"+mb.getM_name()+"</td>");
				sb.append("<td>"+mb.getM_email()+"</td>");
				sb.append("<td>"+mb.getM_kind()+"</td>");
				sb.append("<td>"+mb.getM_status()+"</td>");
				sb.append("<td><input type='button' class='btn' onclick=\"location.href='./memberDelete?m_id="+ mb.getM_id() + "'\" value='삭제'/></td>");
				sb.append("<td><input type='button' class='btn' onclick=\"location.href='./addBlackList?m_id="+ mb.getM_id() + "'\" value='블랙'/></td>");
			}
			sb.append("</div>");
			mav.addObject("slist", sb.toString());
		}
		mav.setViewName("memberMM");
		return mav;

	}

	//프로젝트 리스트 보기
	private void getProjectList() {
		mav = new ModelAndView();
		List<Project> plist =null;

		int pageNum = (request.getParameter("pageNum")!=null)
				? Integer.parseInt(request.getParameter("pageNum"))
						: 1;//만약에 게시글이 없을경우 1페이지를 보여준다.
				plist = pDao.getProjectList(pageNum);
				StringBuilder sb = new StringBuilder();

				for(int i=0;i<plist.size();i++){
					Project pj = plist.get(i);
					sb.append("<tr>");
					sb.append("<td>"+pj.getP_num()+"</td>");
					sb.append("<td>"+pj.getP_pc1name()+"</td>");
					sb.append("<td>"+pj.getP_pc2name()+"</td>");
					sb.append("<td>"+pj.getP_mid()+"</td>");
					sb.append("<td>"+pj.getP_budget()+"</td>");
					sb.append("<td>"+pj.getP_term()+"</td>");
					sb.append("<td>"+pj.getP_title()+"</td>");
					/*sb.append("<td>"+pj.getP_content()+"</td>");*/
					/*sb.append("<td>"+pj.getP_filename()+"</td>");*/
					sb.append("<td>"+pj.getP_deadline()+"</td>");
					sb.append("<td>"+pj.getP_plnum0()+"</td>");
					sb.append("<td>"+pj.getP_plnum1()+"</td>");
					sb.append("<td>"+pj.getP_plnum2()+"</td>");
					sb.append("<td>"+pj.getP_person()+"</td>");
					sb.append("<td>"+pj.getP_status2()+"</td>");
					sb.append("<td>"+pj.getP_vol()+"</td>");
					sb.append("<td><input type='button' class='btn' onclick=\"location.href='./projectDelete?pnum="+ pj.getP_num() + "'\" value='삭제'/></td>");
					sb.append("</tr>");
				}

				mav.addObject("plist",sb.toString());

				String pagingHtml = getPagingPL(pageNum);
				mav.addObject("paging",getPagingPL(pageNum));
				mav.setViewName("projectMM");

	}

	//프로젝트 리스트 페이지 번호
	private String getPagingPL(int pageNum) { //현재 페이지 번호
		int maxNum = pDao.getProjectCount(); //전체 게시글의 수
		int listCount = 10; //페이지당 글의 수
		int pageCount = 2; //그룹당 페이지 수
		String boardName = "goProjectMM";

		Paging paging = new Paging(maxNum,  pageNum,  listCount,  pageCount, boardName);
		return paging.makeHtmlPaging();

	}

	//프로젝트 삭제
	private void projectDelete(int pnum) {
		System.out.println("프로젝트 삭제 시작");
		mav = new ModelAndView();

		pnum = Integer.parseInt(request.getParameter("pnum"));
		System.out.println("pnum="+pnum);
		aDao.projectDelete(pnum);
		mav.setViewName("projectMM");
		getProjectList();

	}

	//프로젝트 개발 리스트 보기
	private void getDevelopList() {
		mav = new ModelAndView();
		List<Project> vlist =null;

		int pageNum = (request.getParameter("pageNum")!=null)
				? Integer.parseInt(request.getParameter("pageNum"))
						: 1;//만약에 게시글이 없을경우 1페이지를 보여준다.
				vlist = pDao.getDevelopList(pageNum);
				StringBuilder sb = new StringBuilder();

				for(int i=0;i<vlist.size();i++){
					Project pj = vlist.get(i);
					sb.append("<tr>");
					sb.append("<td>"+pj.getP_num()+"</td>");
					sb.append("<td>"+pj.getP_pc1name()+"</td>");
					sb.append("<td>"+pj.getP_pc2name()+"</td>");
					sb.append("<td>"+pj.getP_mid()+"</td>");
					sb.append("<td>"+pj.getP_budget()+"</td>");
					sb.append("<td>"+pj.getP_term()+"</td>");
					sb.append("<td>"+pj.getP_title()+"</td>");
					/*sb.append("<td>"+pj.getP_content()+"</td>");*/
					/*sb.append("<td>"+pj.getP_filename()+"</td>");*/
					sb.append("<td>"+pj.getP_deadline()+"</td>");
					sb.append("<td>"+pj.getP_plnum0()+"</td>");
					sb.append("<td>"+pj.getP_plnum1()+"</td>");
					sb.append("<td>"+pj.getP_plnum2()+"</td>");
					sb.append("<td>"+pj.getP_person()+"</td>");
					sb.append("<td>"+pj.getP_status2()+"</td>");
					sb.append("<td>"+pj.getP_vol()+"</td>");
					sb.append("<td><input type='button' class='btn' onclick=\"location.href='./projectDelete?pnum="+ pj.getP_num() + "'\" value='삭제'/></td>");
					sb.append("</tr>");
				}

				mav.addObject("vlist",sb.toString());

				String pagingHtml = getPagingV(pageNum);
				mav.addObject("paging",getPagingV(pageNum));
				mav.setViewName("projectMM");

	}

	//프로젝트 개발 리스트 페이지 번호
	private String getPagingV(int pageNum) { //현재 페이지 번호
		int maxNum = aDao.getNoticeCount(); //전체 게시글의 수
		int listCount = 10; //페이지당 글의 수
		int pageCount = 2; //그룹당 페이지 수


		Paging paging = new Paging(maxNum,  pageNum,  listCount,  pageCount);
		return paging.makeHtmlPaging();

	}

	//프로젝트 디자인 리스트 보기
	private void getDesignList() {
		mav = new ModelAndView();
		List<Project> dlist =null;

		int pageNum = (request.getParameter("pageNum")!=null)
				? Integer.parseInt(request.getParameter("pageNum"))
						: 1;//만약에 게시글이 없을경우 1페이지를 보여준다.
				dlist = pDao.getDesignList(pageNum);
				StringBuilder sb = new StringBuilder();

				for(int i=0;i<dlist.size();i++){
					Project pj = dlist.get(i);
					sb.append("<tr>");
					sb.append("<td>"+pj.getP_num()+"</td>");
					sb.append("<td>"+pj.getP_pc1name()+"</td>");
					sb.append("<td>"+pj.getP_pc2name()+"</td>");
					sb.append("<td>"+pj.getP_mid()+"</td>");
					sb.append("<td>"+pj.getP_budget()+"</td>");
					sb.append("<td>"+pj.getP_term()+"</td>");
					sb.append("<td>"+pj.getP_title()+"</td>");
					/*sb.append("<td>"+pj.getP_content()+"</td>");*/
					/*sb.append("<td>"+pj.getP_filename()+"</td>");*/
					sb.append("<td>"+pj.getP_deadline()+"</td>");
					sb.append("<td>"+pj.getP_plnum0()+"</td>");
					sb.append("<td>"+pj.getP_plnum1()+"</td>");
					sb.append("<td>"+pj.getP_plnum2()+"</td>");
					sb.append("<td>"+pj.getP_person()+"</td>");
					sb.append("<td>"+pj.getP_status2()+"</td>");
					sb.append("<td>"+pj.getP_vol()+"</td>");
					sb.append("<td><input type='button' class='btn' onclick=\"location.href='./projectDelete?pnum="+ pj.getP_num() + "'\" value='삭제'/></td>");
					sb.append("</tr>");
				}

				mav.addObject("vlist",sb.toString());

				String pagingHtml = getPagingD(pageNum);
				mav.addObject("paging",getPagingD(pageNum));
				mav.setViewName("projectMM");

	}

	//프로젝트 디자인 리스트 페이지 번호
	private String getPagingD(int pageNum) { //현재 페이지 번호
		int maxNum = aDao.getNoticeCount(); //전체 게시글의 수
		int listCount = 10; //페이지당 글의 수
		int pageCount = 2; //그룹당 페이지 수


		Paging paging = new Paging(maxNum,  pageNum,  listCount,  pageCount);
		return paging.makeHtmlPaging();

	}

	public ModelAndView searchProject() {
		mav=new ModelAndView();
		String keyword=request.getParameter("keyword");
		System.out.println(keyword);
		List<Project> slist=null;
		slist=pDao.getSearchResult(keyword);

		if(slist!=null){
			StringBuilder sb=new StringBuilder();
			sb.append("<div class='container'>");
			for(int i=0; i<slist.size(); i++){
				Project pj = slist.get(i);
				sb.append("<tr>");
				sb.append("<td>"+pj.getP_num()+"</td>");
				sb.append("<td>"+pj.getP_pc1name()+"</td>");
				sb.append("<td>"+pj.getP_pc2name()+"</td>");
				sb.append("<td>"+pj.getP_mid()+"</td>");
				sb.append("<td>"+pj.getP_budget()+"</td>");
				sb.append("<td>"+pj.getP_term()+"</td>");
				sb.append("<td>"+pj.getP_title()+"</td>");
				/*sb.append("<td>"+pj.getP_content()+"</td>");*/
				/*sb.append("<td>"+pj.getP_filename()+"</td>");*/
				sb.append("<td>"+pj.getP_deadline()+"</td>");
				sb.append("<td>"+pj.getP_plnum0()+"</td>");
				sb.append("<td>"+pj.getP_plnum1()+"</td>");
				sb.append("<td>"+pj.getP_plnum2()+"</td>");
				sb.append("<td>"+pj.getP_person()+"</td>");
				sb.append("<td>"+pj.getP_status2()+"</td>");
				sb.append("<td>"+pj.getP_vol()+"</td>");
				sb.append("<td><input type='button' class='btn' onclick=\"location.href='./projectDelete?pnum="+ pj.getP_num() + "'\" value='삭제'/></td>");
				sb.append("</tr>");
			}
			sb.append("</div>");
			mav.addObject("slist", sb.toString());
		}
		mav.setViewName("projectMM");
		return mav;
	}

}















