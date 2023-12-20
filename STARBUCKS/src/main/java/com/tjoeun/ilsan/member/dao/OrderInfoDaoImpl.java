package com.tjoeun.ilsan.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tjoeun.ilsan.member.sql.OrderInfoMapper;

@Repository
public class OrderInfoDaoImpl implements OrderInfoDao {
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<Map> selectOrderInfo() {
		OrderInfoMapper mapper = sqlSession.getMapper(OrderInfoMapper.class);
		return mapper.selectOrderInfo();
	}

	@Override
	public int insertOrderInfo(Map map) {
		OrderInfoMapper mapper = sqlSession.getMapper(OrderInfoMapper.class);
		return mapper.insertOrderInfo(map);
	}

}
