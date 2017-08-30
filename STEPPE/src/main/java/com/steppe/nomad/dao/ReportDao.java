package com.steppe.nomad.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.steppe.nomad.bean.Member;
import com.steppe.nomad.bean.Portfolio;
import com.steppe.nomad.bean.Project;
import com.steppe.nomad.bean.Project_pBookmark;
import com.steppe.nomad.bean.Reply;
import com.steppe.nomad.bean.Report;

@Repository 
public class ReportDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public int insertReport(Report report) {
		
		return sqlSession.insert("report.insertReport",report);
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
	
	//테이블내 댓글 최대수 계산
	public int getReplyMaxNum() {
		return sqlSession.selectOne("report.selectReplyMaxNum");
	}
	
	//댓글삽입
	public int insertReply(Reply reply) {
		return sqlSession.insert("report.insertReply", reply);
		
	}

	public List<Reply> showReply(int p_num) {
		
		return sqlSession.selectList("report.showReply", p_num);
		
		
	}

	public int deleteReply(int r_num) {
		
		return sqlSession.delete("report.deleteReply", r_num);
		
	}

	public List<Project> getHomeProjectList() {
		return sqlSession.selectList("report.getHomeProjectList");
	}

	public List<Member> getHomeFreelancerList() {
		return sqlSession.selectList("report.getHomeFreelancerList");
	}

	public List<Portfolio> getPortfolioview(String pt_sysname) {
		return sqlSession.selectList("Portfolio.getPortfolioview",pt_sysname);
	}

}
