package com.rong.block.dao;

import com.rong.block.pojo.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    UserDto findUserByName(String name);
}