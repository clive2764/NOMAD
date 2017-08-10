package com.steppe.nomad.dao;

import java.util.List; 

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.steppe.nomad.bean.Test;

@Service
public class TestDao {
	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<Test> getTestList(String t_name) {
		return sqlSession.selectList("test.getTestList", t_name);
	}

	public Test showFstDetail(String t_num) {
		return sqlSession.selectOne("test.showFstDetail",t_num);
	}
	
}
