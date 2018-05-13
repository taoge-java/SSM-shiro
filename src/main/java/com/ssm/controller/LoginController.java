package com.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.controller.base.BaseController;
import com.ssm.service.LoginService;
import com.ssm.service.Result;
import com.ssm.util.ImageUtil;
import com.ssm.util.ResultCode;

@Controller
public class LoginController extends BaseController{

	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/")
	public String index(){
		return "login";
	}
	
	@RequestMapping("/image")
	public void image(HttpServletRequest request,HttpServletResponse response){
		ImageUtil imageUtil = new ImageUtil();
		imageUtil.render(request, response);
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public ResultCode login(@RequestParam("username")String userName,String password){
		Result result = loginService.login(userName, password);
		return result.getResultCode();
	}
}
