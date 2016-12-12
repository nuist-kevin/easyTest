package com.mybatis.util;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mybatis.dao.UserDao;
import com.mybatis.entity.User;

public class DBToolTest {

	// 使用最原始的方法进行查询
	@Test
	public void basicTestGetUserById() {
		SqlSession sqlSession = DBTool.getSession();
		User user = sqlSession.selectOne("test.getUserById", 1);
		sqlSession.close();
		Assert.assertEquals("王五", user.getUsername());
	}

	// 使用Mapper代理的方法进行查询
	@Test
	public void testGetUserById() {
		SqlSession sqlSession = DBTool.getSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		User user = userDao.getUserById(1);
		sqlSession.close();
		Assert.assertEquals("王五", user.getUsername());
	}
	
	@Test
	public void basicTestGetUserByName() {
		SqlSession sqlSession = DBTool.getSession();
		List<User> userList = sqlSession.selectList("test.getUserByName", "王五");
		sqlSession.close();
		Assert.assertEquals(1 , userList.get(0).getId());
	}
	
	@Test
	public void testGetUserByName() {
		SqlSession sqlSession = DBTool.getSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		List<User> userList = userDao.getUserByName("王五");
		sqlSession.close();
		Assert.assertEquals(1 , userList.get(0).getId());
}
	
	@Test
	public void basicTestInsertUser() {
		SqlSession sqlSession = DBTool.getSession();
		User user = new User();
//		user.setId(100);
		user.setUsername("蔡文");
		user.setAddress("翡翠公园");
		user.setBirthday(new Date());
		user.setSex("1");
		sqlSession.insert("test.insertUser", user);
//		sqlSession.selectOne("test.getUserById", arg1);
		sqlSession.commit();
		sqlSession.close();
	}
	
	
	@Test
	public void testDeleteUser() {
		SqlSession sqlSession = DBTool.getSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		userDao.deleteUser(100);
		sqlSession.commit();
		sqlSession.close();
}
}
