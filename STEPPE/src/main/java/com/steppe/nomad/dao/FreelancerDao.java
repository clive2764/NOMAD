package com.steppe.nomad.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.steppe.nomad.bean.Career;
import com.steppe.nomad.bean.Member;
import com.steppe.nomad.bean.Portfolio;
import com.steppe.nomad.bean.Profile;
import com.steppe.nomad.bean.Skill;

@Repository
public class FreelancerDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Career> getCareerList(String m_id) {
		return sqlSession.selectList("Career.getCareerList", m_id);
	}

	
	public int getCareerMaxNum() {
		return sqlSession.selectOne("Career.getCareerMaxNum");
	}
	
	public int insertCareer(Career career) {
		return sqlSession.insert("Career.insertCareer", career);	
	}
	

	public int deleteCareer(int ca_num) {
		return sqlSession.delete("Career.deleteCareer", ca_num);
	}
	
	public List<Profile> getProfileList(String m_id) {
		return sqlSession.selectList("Profile.getProfileList", m_id);
	}
		
	public int getProfileMaxNum() {
		return sqlSession.selectOne("Profile.getProfileMaxNum");
	}
	
	public int insertProfile(Profile profile) {
		return sqlSession.insert("Profile.insertProfile", profile);
	}
	
	public int deleteProfile(int pro_num) {
		System.out.println(pro_num);
		return sqlSession.delete("Profile.deleteProfile", pro_num);
	}
	
	public List<Skill> getSkillList(String m_id) {
		return sqlSession.selectList("Skill.getSkillList", m_id);
	}
	
	public int getSkillMaxNum() {
		return sqlSession.selectOne("Skill.getSkillMaxNum");
	}
	
	public int insertSkill(Skill skill) {
		return sqlSession.insert("Skill.insertSkill", skill);
	}
	
	public int deleteSKill(int sk_num) {
		return sqlSession.delete("Skill.deleteSkill", sk_num);
	}

	public List<Portfolio> getPortfolioList(String pf_mid) {
		return sqlSession.selectList("Portfolio.getPortfolioList", pf_mid);
	}
	
	public int getPortfolioDetail(int pf_num) {
		return sqlSession.selectOne("Portfolio.getPortfolioDetail", pf_num);
	}
	
	public int getPortfolioMaxNum() {
		return sqlSession.selectOne("Portfolio.getPortfolioMaxNum");
	}
	
	public int insertPortfolio(Portfolio portfolio) {
		return sqlSession.insert("Portfolio.insertPortfolio", portfolio);
	}
	
	public int getPortfolioCount() {
		return sqlSession.selectOne("Portfolio.getPortfolioCount");
	}
	
	public int updatePortfolio(Portfolio portfolio) {
		return sqlSession.update("Portfolio.updatePortfolio", portfolio);
	}
	
	public int deletePortfolio(int pf_num) {
		return sqlSession.delete("Portfolio.deletePortfolio", pf_num);
	}
	
	public int portfolioFileInsert(List<String> mapList, int pfNum) {
		int result = 0;
		Map<String,Object> map = new HashMap<String, Object>();
	      for(int i=0; i<mapList.size(); i++){
	         String str = mapList.get(i);
	         map.put("sysFileName", str);
	         map.put("pfNum", pfNum);
	         result = sqlSession.insert("Portfolio.portfolioFileInsert", map);
	      }
	      
	      /*System.out.println("insert확인="+mapList.size());
	      Map<String, Object> pfMap = null;
	      int fileInsert = 0;
	      for(int i=0; i<mapList.size(); i++){
	         pfMap = mapList.get(i);
	         pfMap.put("pfNum", pfNum);
	         result = sqlSession.insert("portfolio.portfolioFileInsert", pfMap);
	      }*/
	      return result;
	   }
	
	public List<Member> getFreelancer() {
		return sqlSession.selectList("Career.getFreelancerList");
	}

	public Member getFreelancerDetail(String m_id) {
		
		return sqlSession.selectOne("Career.getFreelancerDetail", m_id);
	}

	public List<Career> getCareerList(int ca_num) {
		return sqlSession.selectList("Career.getCareerList", ca_num);
	}

	public List<Career> getCareer(String m_id) {
		
		return sqlSession.selectList("Career.getCareer", m_id);
	}

	public List<Member> getSearchResult(String keyword){

		
		return sqlSession.selectList("Career.getSearchResult", keyword);
	}
	
	//사진가져오기
	public String getProfilePhoto(String m_id) {
		return sqlSession.selectOne("Career.getProfilePhoto", m_id);

	}

	public List<Member> getPhoto() {
		return sqlSession.selectList("Career.getPhoto");
	}
	

}
