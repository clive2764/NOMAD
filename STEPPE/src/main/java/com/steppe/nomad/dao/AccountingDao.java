package com.steppe.nomad.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.steppe.nomad.bean.Accounting;
import com.steppe.nomad.bean.Purchase_detail;
import com.steppe.nomad.bean.Volunteer;

@Repository
public class AccountingDao {

	@Autowired
	private SqlSessionTemplate sqlSession;


	public int Countpunum(int v_pnum) {
		return sqlSession.selectOne("accounting.Countpunum",v_pnum);
	}


	public int getPrice(int v_pnum) {
		return sqlSession.selectOne("accounting.getPrice",v_pnum);
	}

	public int getPurchaseMaxNum() {
		return sqlSession.selectOne("accounting.getPurchaseMaxNum");
	}


	public int insertPurchase(Accounting accounting) {
		return sqlSession.insert("accounting.insertPurchase",accounting);
	}


	public int getPurchase_detailMaxNum() {
		return sqlSession.selectOne("accounting.getPurchase_detailMaxNum");
	}

	public int insertPurchase_detail(Accounting accounting2) {
		return sqlSession.insert("accounting.insertPurchase_detail",accounting2);
	}


	public int CheckPurchase(int pu_pnum) {
		return sqlSession.selectOne("accounting.CheckPurchase",pu_pnum);
	}

	public int getPu_num(int pu_pnum) {
		return sqlSession.selectOne("accounting.getPu_num", pu_pnum);
	}

	public List<Purchase_detail> selectPurchase_detail(int pu_num) {
		return sqlSession.selectList("purchase_detail.selectPurchase_detail", pu_num);
	}
}
