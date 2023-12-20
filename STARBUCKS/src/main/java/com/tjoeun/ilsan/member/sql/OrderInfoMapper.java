package com.tjoeun.ilsan.member.sql;

import java.util.List;
import java.util.Map;

public interface OrderInfoMapper {
	
	public List<Map> selectOrderInfo();
	
	public int insertOrderInfo(Map map);

}
