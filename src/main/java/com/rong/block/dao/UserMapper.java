package com.rong.block.dao;

import com.rong.block.pojo.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
}