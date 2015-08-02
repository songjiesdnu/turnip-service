/**
 * Date:2015年7月30日下午11:20:52
 * Copyright (c) 2015, songjiesdnu@163.com All Rights Reserved.
 */
package com.robot.turnip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.robot.turnip.dao.UserMapper;
import com.robot.turnip.domain.User;
import com.robot.turnip.service.IUserService;

/**
 * IUserService的实现类. <br/>
 * date: 2015年7月30日 下午11:18:04 <br/>
 *
 * @author songjiesdnu@163.com
 */
@Service("userService")
@Transactional
public class UserService implements IUserService {
	private Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Resource
	private UserMapper userMapper;
	
	/**
	 * 查询.
	 * @see com.robot.turnip.service.IUserService#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public User selectByPrimaryKey(String userId) {
		if(userId == null  ||  userId.equals("")){
			logger.error("userId不能为空");
			throw new NullPointerException("userId不能为空");
		}
		User user = userMapper.selectByPrimaryKey(userId);
		return user;
	}

	/**
	 * 删除.
	 * @see com.robot.turnip.service.IUserService#deleteByPrimaryKey(java.lang.String)
	 */
	@Override
	public int deleteByPrimaryKey(String userId) {
		if(userId == null  ||  userId.equals("")){
			logger.error("userId不能为空");
			throw new NullPointerException("userId不能为空");
		}
		int count = userMapper.deleteByPrimaryKey(userId);
		return count;
	}

	/**
	 * 插入.
	 * @see com.robot.turnip.service.IUserService#insert(com.robot.turnip.domain.User)
	 */
	@Override
	public int insert(User user) {
		if(user == null){
			logger.error("User不能为null");
			throw new NullPointerException("User不能为null");
		}
		int result = userMapper.insert(user);
		return result;
	}

	/**
	 * 更新.
	 * @see com.robot.turnip.service.IUserService#updateByPrimaryKey(com.robot.turnip.domain.User)
	 */
	@Override
	public int updateByPrimaryKey(User user) {
		if(user == null){
			logger.error("User不能为null");
			throw new NullPointerException("User不能为null");
		}
		int count = userMapper.updateByPrimaryKey(user);
		return count;
	}

	/**
	 * 分页查询.
	 * @see com.robot.turnip.service.IUserService#selectByPage()
	 */
	@Override
	public List<User> selectByPage(RowBounds rb1) {
		RowBounds rb = new RowBounds(10, 5);
		List<User> list = userMapper.selectByPage(rb);
		
		
		
		return userMapper.selectByPage(rb1);
	}
}