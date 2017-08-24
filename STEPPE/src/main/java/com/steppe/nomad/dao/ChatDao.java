package com.steppe.nomad.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class ChatDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int chatSubmit(Map<String, String> map){
		return sqlSession.insert("chat.chatSubmit", map);
	}
}
