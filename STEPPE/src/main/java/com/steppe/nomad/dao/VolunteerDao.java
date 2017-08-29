package com.steppe.nomad.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

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

	public List<Volunteer> chatRoomList(String mid) {
		return sqlSession.selectList("volunteer.chatRoomList",mid);
	}

	public int volunteerCheck(String p_mid) {
		return sqlSession.selectOne("volunteer.volunteerCheck",p_mid);
	}

	public int getPerson(int v_pnum) {
		return sqlSession.selectOne("volunteer.getPerson",v_pnum);
	}

	public List<Volunteer> getVolunteerList(int v_pnum) {//라이트 박스에서 띄우기 위한 지원자 리스트
		return sqlSession.selectList("volunteer.getVolunteerList",v_pnum);
	}
}
