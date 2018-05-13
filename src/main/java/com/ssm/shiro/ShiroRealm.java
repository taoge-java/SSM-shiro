package com.ssm.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.entity.SystemAdmin;
import com.ssm.mapper.SystemAdminMapper;
import com.ssm.util.Md5Utils;


public class ShiroRealm extends AuthorizingRealm{

	@Autowired
	private SystemAdminMapper systemAdminMapper;
	
	
	/**
	 * 用户认证
	 */
	@SuppressWarnings("unused")
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
		String userName = usernamePasswordToken.getUsername();
		SystemAdmin admin = systemAdminMapper.findByUserName(userName);
		String password = Md5Utils.getMd5(new String(usernamePasswordToken.getPassword()), admin.getEncrypt());
		usernamePasswordToken.setPassword(password.toCharArray());
		if(admin == null){
			throw new UnknownAccountException("用户不存在");
		}
		//以下数据属于数据库中的用户名密码
		return  new SimpleAuthenticationInfo(userName, admin.getPassword(), getName());
	}

	
	/**
	 * 用户授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}
}
