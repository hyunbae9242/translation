package com.translation.hyunbae.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.translation.hyunbae.dao.LikeDao;
import com.translation.hyunbae.vo.LikeVO;

@Repository
public class LikeDaoImpl implements LikeDao {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	
	@Override
	public LikeVO selectLike(LikeVO like) {
		try(SqlSession session = sqlSessionFactory.openSession()) {
			return session.selectOne("com.translation.hyunbae.dao.LikeDao.selectLike",like);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
