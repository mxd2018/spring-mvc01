package com.mxd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mxd.dao.IUserDao;
import com.mxd.pojo.po.User;
import com.mxd.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private IUserDao iudao;
	@Override
	public User findUser(String username, String password) {
		return iudao.findUser(username, password);
		
	}
	
}
