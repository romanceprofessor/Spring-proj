package com.example.demo.rest.board.free.sql;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FreeBoardMapper {
	
	public Map selectTotalCnt(Map map);
	
	public List<Map> select(Map map);
	
	public int write(Map map);
	
	public int delete(Map map);
	
	public int update(Map map);
	
	public int updateRec(Map map);
}
