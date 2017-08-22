package com.steppe.nomad.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.steppe.nomad.bean.Career;
import com.steppe.nomad.bean.Member;
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

	public List<Member> getFreelancer() {
		return sqlSession.selectList("Career.getFreelancerList");
	}

	public Member getFreelancerDetail(String m_id) {


		return sqlSession.selectOne("Career.getFreelancerDetail", m_id);

	}

	public List<Career> getCareer(String m_id) {

		
		return sqlSession.selectList("Career.getCareer", m_id);
		
	}


	public List<Member> getSearchResult(String keyword){

		
		return sqlSession.selectList("Career.getSearchResult", keyword);
	}

	

}
