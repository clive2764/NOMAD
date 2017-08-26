package com.steppe.nomad.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public int checkVolunteerList(Volunteer volunteer) {
		return sqlSession.selectOne("volunteer.checkVolunteerList", volunteer);
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
	
	public int insertVolunteer(Volunteer volunteer) {
		return sqlSession.insert("volunteer.insertVolunteer",volunteer);
	}

	public int getVolunteerMaxNum() {
		return sqlSession.selectOne("volunteer.getVolunteerMaxNum");
	}
	
	public int updateBid(int v_bid,String m_id){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("v_bid", v_bid);
		map.put("v_mid", m_id);
		return sqlSession.update("volunteer.updateBid",map);
	}
}
