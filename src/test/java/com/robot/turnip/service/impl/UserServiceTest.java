/**
 * Date:2015年7月30日下午11:20:52
 * Copyright (c) 2015, songjiesdnu@163.com All Rights Reserved.
 */
package com.robot.turnip.service.impl;

import static org.junit.Assert.assertEquals;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.ibatis.session.RowBounds;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.robot.turnip.dao.UserMapper;
import com.robot.turnip.domain.User;
import com.robot.turnip.service.IUserService;
import com.robot.turnip.util.MD5Utils;
import com.robot.turnip.util.UUIDUtils;

/**
 * UserService的单测. <br/>
 * date: 2015年7月30日 下午11:20:52 <br/>
 *
 * @author songjiesdnu@163.com
 */
@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
@Transactional
public class UserServiceTest {
	private static Logger logger = LoggerFactory.getLogger(UserServiceTest.class);
	
	private static String NAME1 = "name1";
	private static String PLAINPASSWORD1 = "111111";
	private static String MOBILENO1 = "13311111111";
	private static String EAMIL1 = "1111@163.com";
	private static String NAME2 = "name2";
	private static String PLAINPASSWORD2 = "222222";
	private static String MOBILENO2 = "13322222222";
	private static String EAMIL2 = "2222@163.com";
	
	@Autowired
	IUserService userService;
	
	@Autowired
	UserMapper userMapper;
	
	private User user1 = null;
	private User user2 = null;
	
	@Before
	public void before(){
		user1 = createUser(NAME1, PLAINPASSWORD1, MOBILENO1, EAMIL1);
		user2 = createUser(NAME2, PLAINPASSWORD2, MOBILENO2, EAMIL2);
		userService.insert(user1);
	}
	
	
	@Test(expected = NullPointerException.class)
	public void testSelectByPrimaryKey_null(){
		String userId = null;
		userService.selectByPrimaryKey(userId);
	}
	
	@Test(expected = NullPointerException.class)
	public void testSelectByPrimaryKey_emptyString(){
		String userId = "";
		userService.selectByPrimaryKey(userId);
	}
	
	@Test
	public void testSelectByPrimaryKey_notNull(){
		User user = userService.selectByPrimaryKey(user1.getId());
		assertEquals(user1.getId(), user.getId());
		assertEquals(user1.getEmail(), user.getEmail());
		assertEquals(user1.getMobileNo(), user.getMobileNo());
		assertEquals(user1.getRealName(), user.getRealName());
	}
	
	@Test(expected = NullPointerException.class)
	public void testDeleteByPrimaryKey_null(){
		String userId = null;
		userService.deleteByPrimaryKey(userId);
	}
	
	@Test(expected = NullPointerException.class)
	public void testDeleteByPrimaryKey_emptyString(){
		String userId = "";
		userService.deleteByPrimaryKey(userId);
	}
	
	@Test
	public void testDeleteByPrimaryKey_notNull(){
		int count = userService.deleteByPrimaryKey(user1.getId());
		User user = userService.selectByPrimaryKey(user1.getId());
		assertEquals(1, count);
		assertEquals(user, null);
	}

	@Test(expected = NullPointerException.class)
	public void testInsert_null(){
		User user = null;
		userService.insert(user);
	}
	
	@Test
	public void testInsert_notNull(){
		int count = userService.insert(user2);
		userService.deleteByPrimaryKey(user2.getId());
		assertEquals(1, count);
	}
	
	@Test(expected = NullPointerException.class)
	public void testUpdateByPrimaryKey_null(){
		User user = null;
		userService.updateByPrimaryKey(user);
	}
	
	@Test
	public void testUpdateByPrimaryKey_notNull(){
		String newMobileNo = "13333333333";
		user1.setMobileNo(newMobileNo);
		userService.updateByPrimaryKey(user1);
		User user = userService.selectByPrimaryKey(user1.getId());
		assertEquals(user.getMobileNo(), newMobileNo);
	}
	
	@Test
	public void testSelectByPage(){
		RowBounds rb = new RowBounds(3, 3);
		List<User> userList = userService.selectByPage(rb);
		logger.debug("size:{}", userList.size());
		Iterator<User> it = userList.iterator();
		while(it.hasNext()){
			User user = it.next();
			logger.debug("userName:{}", user.getName());
		}
	}
	
	@After
	public void after(){
	}

	/**
	 * 创建一个用户
	 * @author songjiesdnu@163.com
	 * @return
	 * @throws NoSuchAlgorithmException 
	 * @since JDK 1.6
	 */
	private User createUser(String name, String plainPassword, String mobileNo, String email) {
		User user = new User();
		
		String id = UUIDUtils.getUUID();
		String salt = UUIDUtils.getUUID();
		String password = MD5Utils.encrypt(plainPassword + salt);
		String registerTime = DateFormatUtils.format(new Date(), "yyyy:mm:dd HH:mm:ss");
		
		user.setId(id);
		user.setName(name);
		user.setPassword(password);
		user.setSalt(salt);
		user.setMobileNo(mobileNo);
		user.setEmail(email);
		user.setRegisterTime(registerTime);
		user.setStatus("1");
		
		return user;
	}
	
	@Test
	public void insertManyUsers(){
		String plainPassword = "111111";
		for(int i=10; i<55; i++){
			String name = "pager_name_" + i;
			String mobileNo = "138000000" + i;
			String email = "pager_email_" + i;
			User user = createUser(name, plainPassword, mobileNo, email);
			userService.insert(user);
		}
	}
}