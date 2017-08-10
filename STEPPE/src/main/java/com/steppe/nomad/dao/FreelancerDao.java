package com.steppe.nomad.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.steppe.nomad.bean.Career;

@Repository
public class FreelancerDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int careerInsert(Career career) {
		return sqlSession.insert("Career.careerInsert", career);
		
	}
	
	public int getCareerMaxNum() {
		return sqlSession.selectOne("Career.getCareerMaxNum");
	}
	
}
