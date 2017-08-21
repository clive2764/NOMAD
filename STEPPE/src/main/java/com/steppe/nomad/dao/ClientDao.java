package com.steppe.nomad.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientDao {
	//마이바티스 설정
	@Autowired
	private SqlSessionTemplate sqlSession;

	public String getSenderEmail(String sender) {
		return sqlSession.selectOne("client.getSenderEmail",sender);
	}
	public String getReciverEmail(String reciver) {
		return sqlSession.selectOne("client.getReciverEmail",reciver);
	}
}
