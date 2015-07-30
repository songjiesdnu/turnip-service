/**
 * 
 */
package com.robot.turnip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.robot.turnip.dao.UserMapper;
import com.robot.turnip.domain.User;
import com.robot.turnip.service.IUserService;

/**
 * 
 * Function: TODO ADD FUNCTION. <br/>
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
	
	@Override
	public User selectByPrimaryKey(String userId) {
		// TODO Auto-generated method stub
		User user = userMapper.selectByPrimaryKey(userId);
		logger.debug("user:" + JSON.toJSONString(user));
		return user;
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.robot.turnip.service.IUserService#deleteByPrimaryKey(java.lang.String)
	 */
	@Override
	public int deleteByPrimaryKey(String id) {
		return 0;
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.robot.turnip.service.IUserService#insert(com.robot.turnip.domain.User)
	 */
	@Override
	public int insert(User user) {
		int result = userMapper.insert(user);
		return result;
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.robot.turnip.service.IUserService#selectAll()
	 */
	@Override
	public List<User> selectAll() {
		return null;
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.robot.turnip.service.IUserService#updateByPrimaryKey(com.robot.turnip.domain.User)
	 */
	@Override
	public int updateByPrimaryKey(User record) {
		return 0;
	}

}