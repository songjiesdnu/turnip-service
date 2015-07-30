package com.robot.turnip.dao;

import com.robot.turnip.domain.UserProfile;
import java.util.List;

public interface UserProfileMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserProfile record);

    UserProfile selectByPrimaryKey(String id);

    List<UserProfile> selectAll();

    int updateByPrimaryKey(UserProfile record);
}