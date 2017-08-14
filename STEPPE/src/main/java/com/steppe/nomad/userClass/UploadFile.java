package com.steppe.nomad.userClass;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class UploadFile {
		 public UploadFile() {
		
		}
	//파일 업로드 메소드	
		String fullPath="D:/NOMAD/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/STEPPE/resources/upload";
		
		public Map<Object,Object> fileUp(MultipartHttpServletRequest multi){
			System.out.println("fileUp");
			//1.저장경로 찾기
			String root=multi.getSession().getServletContext().getRealPath("/");//물리적이 주소 찾음/위의 Spring-board까지 찾음
			String path=root+"resources/upload/";
			//2.폴더 생성을 꼭 할것...
			File dir=new File(path);
			if(!dir.isDirectory()){  //폴더 없다면
				dir.mkdir();  //upload폴더 생성
			}
			Iterator<String> files=multi.getFileNames();
			Map<Object, Object> fMap=new HashMap<Object, Object>();
			while(files.hasNext()){
				String fileTagName=files.next();
				MultipartFile mf=multi.getFile(fileTagName);
				String oriFileName=mf.getOriginalFilename();
				//fMap.put("oriFileName", oriFileName);
				
				String sysFileName=System.currentTimeMillis()+"."
						+oriFileName.substring(oriFileName.lastIndexOf(".")+1);
				fMap.put("sysFileName", sysFileName);
				
				try {
					mf.transferTo(new File(path+sysFileName));
				}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return fMap;
		}
}
