package com.steppe.nomad.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.steppe.nomad.bean.Project;
import com.steppe.nomad.bean.Report;

@Repository 
public class ReportDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public int insertReport(Report report) {
		
		return sqlSession.insert("report.insertProject",report);
	}

	public int getMaxNum() {
		return sqlSession.selectOne("report.selectMaxNum");
		
	}

	public List<Report> getReportList() {
		return sqlSession.selectList("report.getReportList");
		
		
	}

	public List<Project> getProjectList() {
		return sqlSession.selectList("report.getProjectList");
	}

	public Project getProjectDetail(int p_num) {
		return sqlSession.selectOne("report.getProjectDetail", p_num);
		
	}

	public int deleteReport(int r_num) {
		return sqlSession.delete("report.deleteReport", r_num);
		
	}

	public List<Project> searchProject(String keyowrd) {
		return sqlSession.selectList("report.searchProject", keyowrd);
	}

}
