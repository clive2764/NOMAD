package com.steppe.nomad.service;

import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

import com.steppe.nomad.dao.MemberDao;

@Repository 
public class MemberManagement {

	private HttpServletRequest request;
	private HttpServletResponse response;
	
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
