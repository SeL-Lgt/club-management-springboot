package com.lgt.clubmanagement.dao;

import com.lgt.clubmanagement.entity.Activitytype;
import com.lgt.clubmanagement.entity.ActivitytypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivitytypeMapper {
    long countByExample(ActivitytypeExample example);

    int deleteByExample(ActivitytypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Activitytype record);

    int insertSelective(Activitytype record);

    List<Activitytype> selectByExampleWithBLOBs(ActivitytypeExample example);

    List<Activitytype> selectByExample(ActivitytypeExample example);

    Activitytype selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Activitytype record, @Param("example") ActivitytypeExample example);

    int updateByExampleWithBLOBs(@Param("record") Activitytype record, @Param("example") ActivitytypeExample example);

    int updateByExample(@Param("record") Activitytype record, @Param("example") ActivitytypeExample example);

    int updateByPrimaryKeySelective(Activitytype record);

    int updateByPrimaryKeyWithBLOBs(Activitytype record);

    int updateByPrimaryKey(Activitytype record);
}