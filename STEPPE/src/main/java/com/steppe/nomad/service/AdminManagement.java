package com.steppe.nomad.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.steppe.nomad.userClass.Paging;
import com.steppe.nomad.bean.Notice;
import com.steppe.nomad.dao.AdminDao;

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

	private ModelAndView mav;

	public ModelAndView execute(Notice nt, int cmd) {
		switch (cmd) {
		case 1:
			noticeInsert(nt);//로그인
			break;
		case 2:
			noticeUpdate(nt);//로그인
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
		default:
			break;
		}
		return mav;
	}

	//공지사항 입력
	private void noticeInsert(Notice nt) {
		mav = new ModelAndView();
		String view = null;
		int nnum;
		String mname;
		String id = (String) session.getAttribute("id").toString();
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
				if(session!=null && session.getAttribute("id")!=null&&session.getAttribute("id").equals("admin")){
					sb.append("<th>수정</th><th>삭제</th></tr>");
				}

				for(int i=0;i<nlist.size();i++){
					Notice nt = nlist.get(i);
					sb.append("<tr>");
					sb.append("<td>"+nt.getN_num()+"</td>");
					sb.append("<td><a href='./goNoticeDetail?nnum="+ nt.getNoticeNum() + "'</a>"+nt.getN_title()+"</td>");
					sb.append("<td>"+nt.getN_mname()+"</td>");
					sb.append("<td>"+nt.getN_date()+"</td>");
					if(session!=null && session.getAttribute("id")!=null&&session.getAttribute("id").equals("admin")){
						sb.append("<td><input type='button' onclick=\"location.href='./goNoticeUpdate?nnum="+ nt.getNoticeNum() + "'\" value='수정'/></td>");
						sb.append("<td><input type='button' onclick=\"location.href='./noticeDelete?nnum="+ nt.getNoticeNum() + "'\" value='삭제'/></td>");
					}

					sb.append("</tr>");
					System.out.println("m_id="+nt.getN_mid());
				}

				mav.addObject("nlist",sb.toString());

				String pagingHtml = getPaging(pageNum);
				mav.addObject("paging",getPaging(pageNum));
				mav.setViewName("notice");



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

	//페이지 번호
	private String getPaging(int pageNum) { //현재 페이지 번호
		int maxNum = aDao.getNoticeCount(); //전체 게시글의 수
		int listCount = 10; //페이지당 글의 수
		int pageCount = 2; //그룹당 페이지 수


		Paging paging = new Paging(maxNum,  pageNum,  listCount,  pageCount);
		//String pagingHtml = paging.makeHtmlPaging();
		//return pagingHtml;
		return paging.makeHtmlPaging();

	}

}












