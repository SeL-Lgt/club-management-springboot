package com.lgt.clubmanagement.dao;

import com.lgt.clubmanagement.entity.Activity;
import com.lgt.clubmanagement.entity.ActivityExample;
import com.lgt.clubmanagement.entity.ActivityKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivityMapper {
    long countByExample(ActivityExample example);

    int deleteByExample(ActivityExample example);

    int deleteByPrimaryKey(ActivityKey key);

    int insert(Activity record);

    int insertSelective(Activity record);

    List<Activity> selectByExampleWithBLOBs(ActivityExample example);

    List<Activity> selectByExample(ActivityExample example);

    Activity selectByPrimaryKey(ActivityKey key);

    int updateByExampleSelective(@Param("record") Activity record, @Param("example") ActivityExample example);

    int updateByExampleWithBLOBs(@Param("record") Activity record, @Param("example") ActivityExample example);

    int updateByExample(@Param("record") Activity record, @Param("example") ActivityExample example);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKeyWithBLOBs(Activity record);

    int updateByPrimaryKey(Activity record);
}