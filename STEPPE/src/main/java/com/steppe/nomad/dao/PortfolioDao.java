package com.steppe.nomad.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PortfolioDao {
	private SqlSessionTemplate sqlSession;
	
	public void portFolioInsert(Map<Object, Object> map) {
		int pfNum = portFolioMaxNum();
		
		return sqlSession.insert("portfolio.portFolioInsert");
	}
	public int portFolioMaxNum(){	
		return sqlSession.selectOne("portfolio.portFolioMaxNum");
	}
	
}
