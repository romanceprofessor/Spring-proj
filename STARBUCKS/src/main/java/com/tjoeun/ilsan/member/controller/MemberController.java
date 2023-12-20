package com.tjoeun.ilsan.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tjoeun.ilsan.member.service.MemberServiceImpl;

@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberServiceImpl memberService;
	
	@RequestMapping(value="/member/list", method=RequestMethod.GET)
	public String memberList(
			@RequestParam("memberId") String memberId
			,Model model
			,HttpServletRequest req
			) {
		
		logger.debug("memberId:" + memberId);
		
		memberService.getMemberList();
		
		model.addAttribute("memberId", memberId);
		
		return "member/memberList";
	}

}
