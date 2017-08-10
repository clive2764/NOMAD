package com.steppe.nomad.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository 
public class MemberDao {

	//마이바티스 설정
	@Autowired
	private SqlSessionTemplate sqlSession;

	public boolean isEmail(String email) {//로그인한 사람의 모든 정보를 가져온다

		return sqlSession.selectOne("member.isEmail", email);
	}


	/*Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;

	public boolean isEmail(String email)
	{
		boolean result = false;

		try
		{
			String sql = "SELECT * FROM MEMBER WHERE EMAIL=?";

			pstmt = con.prepareStatement(sql);

			pstmt.setNString(1, email);

			rs = pstmt.executeQuery();

			if(rs.next())
			{
				result = true;
				System.out.println("사용중인 EMAIL");
			}
			else
				System.out.println("사용 할 수 있는 EMAIL");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("isMember 실패");
		}

		return result;
	}*/

}
