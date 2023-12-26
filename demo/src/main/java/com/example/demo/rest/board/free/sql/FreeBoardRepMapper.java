package com.example.demo.rest.board.free.sql;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FreeBoardRepMapper {

	public int insert(Map map);
	
	public List<Map> select(Map map);
}
