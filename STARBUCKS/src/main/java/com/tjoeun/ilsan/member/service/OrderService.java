package com.tjoeun.ilsan.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

public interface OrderService {
	
	public List<Map> getOrderList();
	
	public void order(Map map) throws Exception;

}
