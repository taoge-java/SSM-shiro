package com.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.service.IndexService;

@Controller
public class IndexController {
	
	@Autowired
	private IndexService indexService;
	
	@RequestMapping("/index")
	public String index(){
		indexService.select("java");
		return "index";
	}
}
