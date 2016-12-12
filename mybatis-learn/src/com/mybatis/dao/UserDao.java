package com.mybatis.dao;

import com.mybatis.entity.User;

public interface UserDao {
	User getUserById(int id);
	User getUserByName(String name);
}
