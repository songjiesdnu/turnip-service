/**
 * 
 */
package com.robot.turnip.service.impl;

/**
 * @author songjie
 *
 */
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.robot.turnip.dao.IUserDao;
import com.robot.turnip.domain.User;
import com.robot.turnip.service.IUserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Resource
	private IUserDao userDao;
	
	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		User user = userDao.selectByPrimaryKey(userId);
		logger.debug("user:" + JSON.toJSONString(user));
		return user;
	}

}