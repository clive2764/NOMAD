package com.steppe.nomad.dao;

import java.util.List;  

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.steppe.nomad.bean.Answer;
import com.steppe.nomad.bean.Test;

@Service
public class TestDao {
	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<Test> getTestList(String t_name) {
		return sqlSession.selectList("test.getTestList", t_name);
	}

	public Test showFstDetail(int t_num) {
		return sqlSession.selectOne("test.showFstDetail",t_num);
	}

	public int getTestMaxNum() {
		return sqlSession.selectOne("test.getTestMaxNum");
	}

	public int insertFst(Test test) {
		return sqlSession.insert("test.insertFst", test);
	}

	public int updateFst(Test test) {
		return sqlSession.update("test.updateFst", test);
	}

	public int deleteFst(int t_num) {
		return sqlSession.delete("test.deleteFst", t_num);
	}

	public int getTestCnt(Answer ans) {
		return sqlSession.selectOne("test.getTestCnt", ans);
	}

	public int getAnswerMaxNum() {
		return sqlSession.selectOne("test.getAnswerMaxNum");
	}

	public int getT_answer(Test test) {
		return sqlSession.selectOne("test.getT_answer", test);
	}

	public int insertAnswer(Answer ans) {
		return sqlSession.insert("test.insertAnswer", ans);
	}

	
}
