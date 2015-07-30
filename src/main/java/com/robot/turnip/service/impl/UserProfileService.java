/**
 * Date:2015年7月30日下午11:12:32
 * Copyright (c) 2015, songjiesdnu@163.com All Rights Reserved.
 */
package com.robot.turnip.service.impl;

import java.util.List;

import com.robot.turnip.domain.UserProfile;
import com.robot.turnip.service.IUserProfileService;

/**
 * Function: TODO ADD FUNCTION. <br/>
 * date: 2015年7月30日 下午11:12:32 <br/>
 *
 * @author songjiesdnu@163.com
 * @version 
 */
public class UserProfileService implements IUserProfileService {

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.robot.turnip.service.IUserProfileService#deleteByPrimaryKey(java.lang.String)
	 */
	@Override
	public int deleteByPrimaryKey(String id) {
		return 0;
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.robot.turnip.service.IUserProfileService#insert(com.robot.turnip.domain.UserProfile)
	 */
	@Override
	public int insert(UserProfile record) {
		return 0;
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.robot.turnip.service.IUserProfileService#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public UserProfile selectByPrimaryKey(String id) {
		return null;
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.robot.turnip.service.IUserProfileService#selectAll()
	 */
	@Override
	public List<UserProfile> selectAll() {
		return null;
	}

	/**
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.robot.turnip.service.IUserProfileService#updateByPrimaryKey(com.robot.turnip.domain.UserProfile)
	 */
	@Override
	public int updateByPrimaryKey(UserProfile record) {
		return 0;
	}

}

