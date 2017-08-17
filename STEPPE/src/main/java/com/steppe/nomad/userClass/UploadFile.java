package com.steppe.nomad.userClass;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.steppe.nomad.dao.FreelancerDao;
import com.steppe.nomad.service.FreelancerManagement;

public class UploadFile {
	
	FreelancerDao fDao = new FreelancerDao();
	FreelancerManagement pfmm = new FreelancerManagement();
	public UploadFile() {

	}
	//파일 업로드 메소드	
	//String fullPath="D:/NOMAD/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/STEPPE/resources/upload";

	public List<String> fileUp(MultipartHttpServletRequest multi, MultipartFile[] files){
	      //1.저장경로 찾기
	      String root=multi.getSession().getServletContext().getRealPath("/");//물리적이 주소 찾음/위의 Spring-board까지 찾음
	      String path=root+"resources/upload/";
	      //2.폴더 생성을 꼭 할것...
	      File dir=new File(path);
	      if(!dir.isDirectory()){  //폴더 없다면
	         dir.mkdir();  //upload폴더 생성
	      } 
	      //List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
	      
	      //Iterator<String> fileList = multi.getFileNames();
	      //System.out.println("Iterator:"+fileList);
	      //Map<String,Object> fMap=new HashMap<String, Object>();
	      MultipartFile mf;
	      //Iterator<String> files1 = multi.getFileNames();
	      //List<MultipartFile> list = multi.getFiles("pf_image[]");
	      List<String> listStr = new ArrayList<String>();
	            //multi.getFiles("pf_image[]");
	      /*while(files1.hasNext()){
	         String fileTagName=files1.next();
	         System.out.println("fileTagName"+fileTagName);
	      }*/
	      for(MultipartFile file : files){
	         byte[] bytes;
	         try {
	            bytes = file.getBytes();
	         //String fileTagName = file.getName();
	         String oriFileName=file.getOriginalFilename();
	         System.out.println("filetagname:"+file);
	         mf = multi.getFile(oriFileName);
	         //fMap.put("oriFileName", oriFileName);
	         String sysFileName=System.currentTimeMillis()+"."
	               +oriFileName.substring(oriFileName.lastIndexOf(".")+1);
	         //fMap.put("sysFileName", sysFileName);
	         System.out.println("sysFileName:"+sysFileName+"path:"+path);
	         File serverFile = new File(path+sysFileName);
	            BufferedOutputStream stream = new BufferedOutputStream(
	                     new FileOutputStream(serverFile));
	            stream.write(bytes);
	            stream.close();
	         //mapList.add(fMap);
	         //sendSysFileName(mapList);
	         listStr.add(sysFileName);
	         } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }
	      }
	      return listStr;
	   }
}