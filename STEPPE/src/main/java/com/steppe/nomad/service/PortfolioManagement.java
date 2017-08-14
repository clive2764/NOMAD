package com.steppe.nomad.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.steppe.nomad.dao.PortfolioDao;
import com.steppe.nomad.userClass.UploadFile;

@Service
public class PortfolioManagement {
	private ModelAndView mav;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private PortfolioDao pfDao;
	@Autowired
	private HttpSession session;
	public ModelAndView execute(int code) {
		if(code==1){
			portFolio();
		}
		return mav;
	}
	public ModelAndView execute(int code, MultipartHttpServletRequest multi) {
		if(code==1){
			portFolioInsert(multi);
		}
		return mav;
	}
	private void portFolioInsert(MultipartHttpServletRequest multi) {
		mav = new ModelAndView();
		String pf_title = multi.getParameter("pf_title");
		String pf_term = multi.getParameter("pf_term");
		String pf_contribute = multi.getParameter("pf_contribute");
		String pf_content = multi.getParameter("pf_content");
		//int check = Integer.parseInt(multi.getParameter(""))
		Map<Object, Object> pfMap = null;
		UploadFile upload = new UploadFile();
		pfMap = upload.fileUp(multi);
		pfDao.portFolioInsert();
		mav.setViewName("portfolio");
	}
	private void portFolio() {
		mav = new ModelAndView();
		mav.setViewName("portfolio");
	}
}
