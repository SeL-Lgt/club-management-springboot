package com.lgt.clubmanagement.dao;

import com.lgt.clubmanagement.entity.Societiestype;
import com.lgt.clubmanagement.entity.SocietiestypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SocietiestypeMapper {
    long countByExample(SocietiestypeExample example);

    int deleteByExample(SocietiestypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Societiestype record);

    int insertSelective(Societiestype record);

    List<Societiestype> selectByExample(SocietiestypeExample example);

    Societiestype selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Societiestype record, @Param("example") SocietiestypeExample example);

    int updateByExample(@Param("record") Societiestype record, @Param("example") SocietiestypeExample example);

    int updateByPrimaryKeySelective(Societiestype record);

    int updateByPrimaryKey(Societiestype record);
}