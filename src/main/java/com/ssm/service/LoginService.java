package com.ssm.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.ssm.util.ResultCode;

@Service
public class LoginService extends BaseService{

	public Result login(String userName,String password){
		Result result = new DefaultResult();
		ResultCode resultCode = new ResultCode(ResultCode.SUCCESS, "登录成功");
		//创建Subject实例
		Subject subject = SecurityUtils.getSubject();
		
		//判断当前用户是否登录
		if(!subject.isAuthenticated()){//没有登录
			UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
			try {
				token.setRememberMe(true);
				subject.login(token);
			} catch (Exception e) {
				if(e instanceof UnknownAccountException){
					resultCode = new ResultCode(ResultCode.FAIL, "用户不存在");
				}else{
					resultCode = new ResultCode(ResultCode.FAIL, "登录失败");
				}
			}
		}
		result.setResultCode(resultCode);
		return result;
	}
}
