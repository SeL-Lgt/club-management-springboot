package com.lgt.clubmanagement.dao;

import com.lgt.clubmanagement.entity.ActivitypeopleExample;
import com.lgt.clubmanagement.entity.ActivitypeopleKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ActivitypeopleMapper {
    long countByExample(ActivitypeopleExample example);

    int deleteByExample(ActivitypeopleExample example);

    int deleteByPrimaryKey(ActivitypeopleKey key);

    int insert(ActivitypeopleKey record);

    int insertSelective(ActivitypeopleKey record);

    List<ActivitypeopleKey> selectByExample(ActivitypeopleExample example);

    int updateByExampleSelective(@Param("record") ActivitypeopleKey record, @Param("example") ActivitypeopleExample example);

    int updateByExample(@Param("record") ActivitypeopleKey record, @Param("example") ActivitypeopleExample example);
}