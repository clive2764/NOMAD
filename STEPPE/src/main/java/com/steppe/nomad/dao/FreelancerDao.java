package com.steppe.nomad.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.steppe.nomad.bean.Career;
import com.steppe.nomad.bean.Profile;
import com.steppe.nomad.bean.Test;

@Repository
public class FreelancerDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int insertCareer(Career career) {
		return sqlSession.insert("Career.careerInsert", career);	
	}
	
	public int getCareerMaxNum() {
		return sqlSession.selectOne("Career.getCareerMaxNum");
	}
	
	public int deleteCareer(int ca_num) {
		return sqlSession.delete("board.articleDelete", ca_num);
	}
	
	public List<Career> getCareerList(int ca_num) {
		return sqlSession.selectList("Career.getCareerList", ca_num);
	}

	public List<Profile> getProfileList(int pro_num) {
		return sqlSession.selectList("Profile.getPRofileList", pro_num);
	}
}
