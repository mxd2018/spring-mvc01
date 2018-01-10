package com.mxd.dao;

import com.mxd.pojo.po.User;

public interface IUserDao {
	User findUser(String username,String password);
}
