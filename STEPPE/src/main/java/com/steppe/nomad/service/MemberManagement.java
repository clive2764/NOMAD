package com.steppe.nomad.service;

import java.io.IOException;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.steppe.nomad.bean.Member;
import com.steppe.nomad.dao.MemberDao;
import com.steppe.nomad.userClass.UploadFile;

@Service
public class MemberManagement {
	
	int code;
	
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
		default:
			break;
		}
		return mav;

	}
	

	public ModelAndView execute(MultipartHttpServletRequest multi, int cmd){
		switch (cmd) {
		case 1:
			memberInsert(multi);//회원가입
			break;
		default:
			break;
		}
		return mav;

	}

	private void memberInsert(MultipartHttpServletRequest multi) {
		mav = new ModelAndView();
		String view = null;
		String message = null;
		
		//BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();

		String id = multi.getParameter("userId");
		System.out.println("id="+id);
		String pw = multi.getParameter("pw");
		System.out.println("pw="+pw);
		String name = multi.getParameter("userName");
		System.out.println("name="+name);
		String email = multi.getParameter("userEmail");
		System.out.println("email="+email);
		String kind = multi.getParameter("m_kind");
		System.out.println("m_kind="+kind);
		String userCode = multi.getParameter("userCode");
		System.out.println("userCode= "+userCode);
				
		int check = Integer.parseInt(multi.getParameter("fileCheck"));
		System.out.println("check="+check);
		
		Map<String, String> fMap = null;

		if(check==1){
			UploadFile upload = new UploadFile();//교수님이 나줘준다.
			//서버에 파일을 업로드 한뒤, 오리지널 파일명, 시스템파일명을 리턴후 맵에 저장
			fMap = upload.fileUp(multi);
		}
		
		if(Integer.parseInt(userCode) == code){
			Member member = new Member();
			member.setM_id(id);
			member.setM_pw(pw);
			member.setM_name(name);
			member.setM_email(email);
			member.setM_kind(kind);
			member.setMf_file(fMap.get("sysFileName"));
			
			if(mDao.memberInsert(member,fMap)!=0){//true 성공하면
				view = "home";//성공하면 로그인 페이지
				mav.addObject("check",1);//회원가입 성공
			}else{//false 실패시
				view = "join";
			}
			mav.setViewName("home");
		}else{
			message = "인증 번호가 틀립니다";
			view = "join";
		}
		mav.setViewName("home");
				
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

	}	
	@Autowired
	private JavaMailSenderImpl javaMailSenderImpl;
	public String sendCode() throws Exception{

		int flag = Integer.valueOf(request.getParameter("flag"));
		System.out.println("flag: "+flag);
		String email = request.getParameter("userEmail");
		System.out.println("userEmail="+ email);
		String msgEmail;
		String msgSend = "";

		if(flag == 1)
		{
			// 중복 이메일 체크
			System.out.println("중복 이메일 체크 시작 email="+email);
			if(email.equals(mDao.isEmail(email))){
				System.out.println("사용중인 EMAIL");
				msgEmail = "중복된 이메일이 있습니다.";
			}else{
				System.out.println("사용 할 수 있는 EMAIL");
				msgEmail = "";
				msgSend = "이메일의 인증번호를 확인해주세요.";

				// 인증번호 생성

				Random random = new Random();
				code = random.nextInt(10000) + 1000;

				if(code > 10000)
					code = code - 1000;

				// 메일 보내기


				HttpSession session = request.getSession();
				session.setAttribute("code", code);
				
				//일반 텍스트메일
				SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
				simpleMailMessage.setFrom("emailtest20170314@gmail.com");
				simpleMailMessage.setTo(email);
				simpleMailMessage.setSubject("Steppe 이메일 인증 코드 입니다.");
				simpleMailMessage.setText("인증 코드는 "+code+"입니다.");

				javaMailSenderImpl.send(simpleMailMessage);
			}
		}
		else
		{
			if(!email.equals(mDao.isEmail(email))){
				msgEmail = "가입된 이메일 정보가 없습니다.";
			}else{
				msgEmail = "";
				msgSend = "이메일의 인증번호를 확인해주세요.";

				// 인증번호 생성

				Random random = new Random();
				int code = random.nextInt(10000) + 1000;

				if(code > 10000)
					code = code - 1000;

				// 메일 보내기


				HttpSession session = request.getSession();
				session.setAttribute("code", code);
				
				//일반 텍스트메일
				SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
				simpleMailMessage.setFrom("emailtest20170314@gmail.com");
				simpleMailMessage.setTo(email);
				simpleMailMessage.setSubject("Steppe 이메일 인증 코드 입니다.");
				simpleMailMessage.setText("인증 코드는 "+code+"입니다.");

				javaMailSenderImpl.send(simpleMailMessage);
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
		return null;
		
		
		
		

		/*//HTML 메일

		MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();
		mimeMessage.setFrom(new InternetAddress("emailtest20170314@gmail.com"));
		mimeMessage.addRecipient(RecipientType.TO, new InternetAddress("jiwon.ha0513@gamil.com"));
		mimeMessage.setSubject("Mime 테스트 메일");
		mimeMessage.setText("<b>메일 내용입니다.</b>", "UTF-8", "html");

		javaMailSenderImpl.send(mimeMessage);
		 */
		//return null;

	}
	

}
