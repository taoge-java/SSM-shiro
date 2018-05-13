package com.ssm.mapper;

import com.ssm.entity.UserInfo;

//@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo>{
	
	//@Select("select * from user_info where name =#{name}")
	//public UserInfo selectOne(String name);
}
