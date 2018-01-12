package com.mxd.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.mxd.dao.IUserDao;
import com.mxd.pojo.po.User;


public class UserDaoImpl extends JdbcDaoSupport implements IUserDao{
	
	@Override
	public User findUser(String username, String password) {
		String sql="select * from user where username=? and password=?";
		User user = this.getJdbcTemplate().queryForObject(sql, 
				new Object[]{username,password},
				new RowMapper<User>(){
				public User mapRow(ResultSet resultSet,int index) throws SQLException{
					return mapRowHandler(resultSet);
				}
			});

		return user;
	}
	
	private User mapRowHandler(ResultSet resultSet) throws SQLException{
		User user = new User();
        user.setPassword(resultSet.getString("password"));
        user.setUsername(resultSet.getString("username"));
        return  user;
 }

	@Override
	public void saveUser(User user) {
		String sql="insert into user values(?,?)";
		this.getJdbcTemplate().update(sql, user.getUsername(),user.getPassword());
		
	}
	
}
