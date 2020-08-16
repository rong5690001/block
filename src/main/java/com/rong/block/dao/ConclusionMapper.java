package com.rong.block.dao;

import com.rong.block.pojo.Conclusion;

public interface ConclusionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Conclusion record);

    int insertSelective(Conclusion record);

    Conclusion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Conclusion record);

    int updateByPrimaryKey(Conclusion record);
}