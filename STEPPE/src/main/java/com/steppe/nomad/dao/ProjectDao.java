package com.steppe.nomad.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.steppe.nomad.bean.Member;
import com.steppe.nomad.bean.Project;
import com.steppe.nomad.bean.Required_Skill;

@Repository
public class ProjectDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Project> showProcess(int p_status, String m_id){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p_status", p_status);
		map.put("m_id", m_id);
		System.out.println("플래그:" + p_status);
		return sqlSession.selectList("project.showProcess", map);
	}

	public int progressUpdate(Map<String, Integer> map) {
		//System.out.println("progNum"+progNum);
		return sqlSession.update("project.progressUpdate", map);
	}

	public List<Project> showMyProjectList(String id) {
		return sqlSession.selectList("project.showMyProjectList", id);
	}

	public List<Member> showMyMemberList(Map<Object, Object> mapList) {
		return sqlSession.selectList("project.showMyMemberList", mapList);
	}
	
	public int deleteTeamMember(String mid){
		return sqlSession.delete("project.deleteTeamMember", mid);
	}

	public List<Required_Skill> getRequired_SkillList() {
		return sqlSession.selectList("project.getRequired_SkillList");
	}

	public int getProjectMaxNum() {
		return sqlSession.selectOne("project.getProjectMaxNum");
	}
	
	public int insertProject(Map<Object, Object> fMap) {
		return sqlSession.insert("project.insertProject",fMap);
	}


}
