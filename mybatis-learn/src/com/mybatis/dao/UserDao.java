package com.mybatis.dao;

import java.util.List;

import com.mybatis.entity.User;

public interface UserDao {                        
	User getUserById(int id);
	List<User> getUserByName(String name);
	User updateUser(User user);
	User insertUser(User user);
	void deleteUser(int id);
}
