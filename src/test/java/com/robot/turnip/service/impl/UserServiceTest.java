/**
 * Date:2015年7月30日下午11:20:52
 * Copyright (c) 2015, songjiesdnu@163.com All Rights Reserved.
 */
package com.robot.turnip.service.impl;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.robot.turnip.domain.User;
import com.robot.turnip.util.MD5Utils;
import com.robot.turnip.util.UUIDUtils;

/**
 * Function: TODO ADD FUNCTION. <br/>
 * date: 2015年7月30日 下午11:20:52 <br/>
 *
 * @author songjiesdnu@163.com
 */
@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class UserServiceTest {
	@Resource
	UserService userService;

	@Test
	public void testInsert_null(){
		User user = null;
		userService.insert(user);
		
	}
	
	@Test
	public void testInsert_notNull(){
		User user = createUser();
		int count = userService.insert(user);
		assertEquals(1, count);
	}
	
	/**
	 * 创建一个用户
	 * @author songjiesdnu@163.com
	 * @return
	 * @throws NoSuchAlgorithmException 
	 * @since JDK 1.6
	 */
	private User createUser() {
		User user = new User();
		
		String id = UUIDUtils.getUUID();
		String name = "name_test";
		String plainPassword = "123456";
		String salt = UUIDUtils.getUUID();
		String password = MD5Utils.encrypt(plainPassword + salt);
		String registerTime = DateFormatUtils.format(new Date(), "yyyy:mm:dd HH:mm:ss");
		
		user.setId(id);
		user.setName(name);
		user.setPassword(password);
		user.setSalt(salt);
		user.setRegisterTime(registerTime);
		user.setStatus("1");
		
		return user;
	}
	
	public static void main(String[] args) {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid.length());
		System.out.println(uuid);
	}

}

