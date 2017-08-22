package com.steppe.nomad.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.steppe.nomad.bean.Project;
import com.steppe.nomad.bean.Required_Skill;

@Repository
public class ProjectDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Project> showProcess(int p_status){
		System.out.println("플래그:" + p_status);
		return sqlSession.selectList("project.showProcess", p_status);
	}

	public int progressUpdate(int progNum) {
		System.out.println("progNum"+progNum);
		return sqlSession.update("project.progressUpdate", progNum);
		
	}

	public List<Required_Skill> getRequired_SkillList() {
		return sqlSession.selectList("project.getRequired_SkillList");
	}

	public int getProjectMaxNum() {
		return sqlSession.selectOne("project.getProjectMaxNum");
	}
	
	public int insertProject(Map<String, Object> fMap) {
		return sqlSession.insert("project.insertProject",fMap);
	}

	//public String getProjectInfo(String m_id) {
		//return sqlSession.selectOne("project.getProjectInfo",m_id);
	//}

	public List<Project> getProjectList(String m_id) {
		return sqlSession.selectList("project.getProjectList", m_id);
	}

	public int UpdateProject(int v_pnum) {
		return sqlSession.update("project.UpdateProject", v_pnum);
	}

	public int checkedProject(int p_num) {
		return sqlSession.selectOne("project.checkedProject", p_num);
	}

	public int deleteProject(int p_num) {
		return sqlSession.delete("project.deleteProject", p_num);
	}

	public int getPerson(int v_pnum) {
		return sqlSession.selectOne("project.getPerson", v_pnum);
	}

	/*public List<Project> getProjectList(Object attribute) {
		// TODO Auto-generated method stub
		return null;
	}*/

	

	

	


}
