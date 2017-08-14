package com.steppe.nomad.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.steppe.nomad.bean.Member;
import com.steppe.nomad.bean.Project;

@Repository
public class ProjectDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Project> showProcess(int p_status){
		System.out.println("플래그:" + p_status);
		return sqlSession.selectList("project.showProcess", p_status);
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
}
