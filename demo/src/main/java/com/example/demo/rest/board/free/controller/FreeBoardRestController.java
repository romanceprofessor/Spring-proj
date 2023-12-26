package com.example.demo.rest.board.free.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.rest.board.free.service.FreeBoardService;

@RestController
public class FreeBoardRestController {
	
	@Autowired
	FreeBoardService freeBoardService;

	@GetMapping("/board/free/list")
	public ResponseEntity getBoardList(@RequestParam Map map) {
		return ResponseEntity.ok(freeBoardService.list(map));
	}
	
	@GetMapping("/board/free/detail/{seq}")
	public ResponseEntity getBoardDetail(
			@PathVariable("seq") String seq) {
		Map map = new HashMap();
		map.put("seq", seq);
		return ResponseEntity.ok(freeBoardService.list(map).get(0));
	}
	
	
	
	
	
	
	
	
}
