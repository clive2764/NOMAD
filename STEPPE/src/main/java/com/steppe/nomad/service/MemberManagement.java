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
		session.invalidate();

		view = "home";
		mav.setViewName(view);

	}
	
	private void memberAccess(Member mb) {
		System.out.println("memberAccess(Member mb) 시작");
		mav = new ModelAndView();
		String view = null;
		
		session.setAttribute("pwd", mb.getM_pw());
		String pwd = (String)session.getAttribute("pwd");
		
		session.setAttribute("id", mb.getM_id());
		String id = (String)session.getAttribute("id");
		
		String pw = mDao.getPwd(mb.getM_id());
		System.out.println("pw= "+pw);
		
		if(pwd!=null){
			if(pwd.equals(pw)){
				
				System.out.println("로그인 성공");
				System.out.println("입력 id = "+id);
				System.out.println("입력 pwd = "+pwd);
				view = "home";
				mav.setViewName(view);
				return;
		
				
			}
		
		}
		System.out.println("로그인 실패");
		view = "login";
		mav.setViewName(view);

		/*//필요할때마다 잠깐 생성해서 쓰고 없애버리기 때문에 method에서 새로 생성한다.
		mav = new ModelAndView();
		String view = null;
		//비밀번호를 암호화(Encoding) 할 수는 있지만 복호화(Decoding)는 불가능하다.
		BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
		//암호화된 코드 얻어오기
		String pwdEncode = mDao.getSecurityPwd(mb.getM_id());
		System.out.println("pwdEncode="+pwdEncode);
		if(pwdEncode!=null){
			if(pwdEncoder.matches(mb.getM_id(), pwdEncode)){
				session.setAttribute("id", mb.getM_id());
				//로그인 성공시(pw, id 일치시) 멤버의 정보를 반환
				mb = mDao.getMemberInfo(mb.getM_id());

				//로그인 되어있는 동안 회원 정보를 화면에 출력
				//밑의 두줄이 같은 의미
				//mav.addObject("mb",mb);//회원정보를 화면에 출력
				session.setAttribute("mb", mb);
				//DB에서 게시글 리스트를 가져와야 한다.
				//mav.addObject("test","redirect Test");

				//jsp방식
				//view = "boardList";//boardList.jsp로 이동

				//redirect/forward 방식
				//url을 발생 시킨다
				//DB에서 게시글 리스트를 가져와야 되지
				//이미 처리된 잡이있으므로 url로 요청함
				//view = "redirect:/boardList" //redirect:url GET 방식만 가능;//dispatcher forwarding
				//dispatcher fowarding 이기 때문에 addObject의 값을 가져갈 수있다.
				//view = "forward:/boardList" //forward:url POST 방식만 가능;
				//view = "redirect:/boardList";//redirect:url

				view = "home";
				mav.setViewName(view);
				return;
			}
		}
		mav.addObject("check",2);//로그인 실패
		view = "home";
		mav.setViewName(view);*/


		/*if(mDao.getLoginResult(mb)!=0){//true 성공하면
			session.setAttribute("id", mb.getM_id());
			//로그인 성공시(pw, id 일치시) 멤버의 정보를 반환
			mb = mDao.getMemberInfo(mb.getM_id());
			mav.addObject("mb",mb);//회원정보를 화면에 출력
			view = "boardList";//boardList.jsp로 이동 //id, pw, ...g_name까지 출력
		}else{
			mav.addObject("check",2);//로그인 실패
			view = "home";

		}
		mav.setViewName(view);*/

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
