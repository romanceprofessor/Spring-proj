package com.tjoeun.ilsan.member.dao;

import java.util.List;
import java.util.Map;

public interface OrderInfoDao {
	
	public List<Map> selectOrderInfo();

	public int insertOrderInfo(Map map);
}
