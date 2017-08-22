package com.steppe.nomad.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.steppe.nomad.bean.Volunteer;

@Repository
public class VolunteerDao {
	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<Volunteer> showApplyList(int p_num) {
		return sqlSession.selectList("volunteer.showApplyList",p_num);
	}

	public int UpdateVolunteer(int v_pnum) {
		System.out.println("DAO확인");
		return sqlSession.update("volunteer.UpdateVolunteer",v_pnum);
	}
}
