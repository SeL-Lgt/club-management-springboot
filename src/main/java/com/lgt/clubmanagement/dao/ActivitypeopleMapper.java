package com.lgt.clubmanagement.dao;

import com.lgt.clubmanagement.entity.Activitypeople;
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

    int insert(Activitypeople record);

    int insertSelective(Activitypeople record);

    List<Activitypeople> selectByExample(ActivitypeopleExample example);

    Activitypeople selectByPrimaryKey(ActivitypeopleKey key);

    int updateByExampleSelective(@Param("record") Activitypeople record, @Param("example") ActivitypeopleExample example);

    int updateByExample(@Param("record") Activitypeople record, @Param("example") ActivitypeopleExample example);

    int updateByPrimaryKeySelective(Activitypeople record);

    int updateByPrimaryKey(Activitypeople record);
}