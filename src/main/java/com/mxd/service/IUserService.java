package com.mxd.service;

import com.mxd.pojo.po.User;

public interface IUserService {
	User findUser(String username,String password);
	
	void saveUser(User user);
}
