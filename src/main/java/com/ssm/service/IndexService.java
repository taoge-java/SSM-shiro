package com.ssm.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.ssm.entity.UserInfo;
import com.ssm.mapper.UserInfoMapper;

@Service
public class IndexService {
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	public void select(String userName){
		UserInfo userInfo = userInfoMapper.findByUserName(userName);
		System.out.println(userInfo.getId());
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
		IndexService indexService = (IndexService) applicationContext.getBean("indexService");
		System.out.println(indexService);
	}
}
