package com.steppe.nomad.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.steppe.nomad.bean.Volunteer;

@Service
public class VolunteerDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Volunteer> chatRoomList(String mid){
		return sqlSession.selectList("volunteer.chatRoomList", mid);
	}
}
