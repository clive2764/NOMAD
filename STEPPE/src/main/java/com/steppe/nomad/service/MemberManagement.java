package com.steppe.nomad.service;

import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.steppe.nomad.bean.Member;
import com.steppe.nomad.dao.MemberDao;

@Repository 
public class MemberManagement {
	@Autowired
	private HttpSession session;//request.getSession();

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private HttpServletResponse response;

	//싱글톤
	@Autowired
	private MemberDao mDao;

	private ModelAndView mav;

	public ModelAndView execute(Member mb, int cmd){
		switch (cmd) {
		case 1:
			memberAccess(mb);//로그인
			break;
		case 2:
			logout(mb);//로그아웃
			break;
		case 3:
			//memberInsert(mb);//회원가입
			break;
		default:
			break;
		}
		return mav;

	}

	private void logout(Member mb) {
		mav = new ModelAndView();
		String view = null;
		System.out.println(session.getAttribute("m_id"));
		if(session !=null){
			session.invalidate();
			System.out.println("session="+session);
			System.out.println("세션 제거 완료");
			System.out.println(session.getAttribute("m_id"));
		}	
		view = "home";
		mav.setViewName(view);
		
	}
	
	private ModelAndView memberAccess(Member mb) {
		mav=new ModelAndView();
		String view=null;
		
		String m_id=request.getParameter("m_id");
		String m_pass=request.getParameter("m_pw");
		
		String passC=mDao.getPwd(m_id);
		System.out.println(m_pass);
		System.out.println(passC);
		if(m_pass!=null){
			if(m_pass.equals(passC)){
				
				String m_kind=mDao.getKind(m_id);
				session.setAttribute("m_kind", m_kind);
				session.getAttribute("m_kind");
				
				System.out.println("로그인성공");
				session.setAttribute("m_id",m_id);
				session.getAttribute("m_id");
				
				session.setAttribute("m_pw", m_pass);
				session.getAttribute("m_pw");
				
				session.setAttribute("member", mb);
				session.getAttribute("member");

				System.out.println(mDao.getKind(m_id));
				System.out.println("아이디:"+session.getAttribute("m_id"));
				System.out.println("패스워드:"+session.getAttribute("m_pw"));
				System.out.println("회원종류:"+session.getAttribute("m_kind"));
				System.out.println("세션:"+session.getId());

				view="redirect:/";
				mav.setViewName(view);
				
			}
			else{
				view="login";
				mav.setViewName(view);
			}
		}
		return mav;
		
	}
	public void sendCode() {
		System.out.println("mm.sendCode() 시작");
		MemberDao dao = new MemberDao();

		int flag = Integer.valueOf(request.getParameter("flag"));
		System.out.println("flag: "+flag);
		String email = request.getParameter("userEmail");
		String msgEmail;
		String msgSend = "";

		if(flag == 1)
		{
			// 중복 이메일 체크

			if(dao.isEmail(email))
				msgEmail = "중복된 이메일이 있습니다.";
			else
			{
				msgEmail = "";
				msgSend = "이메일의 인증번호를 확인해주세요.";

				// 인증번호 생성

				Random random = new Random();
				int code = random.nextInt(1000000) + 100000;

				if(code > 1000000)
					code = code - 100000;

				// 메일 보내기

				EmailManagement mail = new EmailManagement();
				mail.sendCode(email, code);

				HttpSession session = request.getSession();
				session.setAttribute("code", code);
			}
		}
		else
		{
			if(!dao.isEmail(email))
				msgEmail = "가입된 이메일 정보가 없습니다.";
			else
			{
				msgEmail = "";
				msgSend = "이메일의 인증번호를 확인해주세요.";

				// 인증번호 생성

				Random random = new Random();
				int code = random.nextInt(1000000) + 100000;

				if(code > 1000000)
					code = code - 100000;

				// 메일 보내기

				EmailManagement mail = new EmailManagement();
				mail.sendCode(email, code);

				HttpSession session = request.getSession();
				session.setAttribute("code", code);
			}
		}

		try 
		{
			response.getWriter().write(msgEmail + msgSend);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();

		}

		//dao.close();

	}



}
