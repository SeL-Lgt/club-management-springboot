package com.lgt.clubmanagement.dao;

import com.lgt.clubmanagement.entity.Societiesjobtype;
import com.lgt.clubmanagement.entity.SocietiesjobtypeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SocietiesjobtypeMapper {
    long countByExample(SocietiesjobtypeExample example);

    int deleteByExample(SocietiesjobtypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Societiesjobtype record);

    int insertSelective(Societiesjobtype record);

    List<Societiesjobtype> selectByExample(SocietiesjobtypeExample example);

    Societiesjobtype selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Societiesjobtype record, @Param("example") SocietiesjobtypeExample example);

    int updateByExample(@Param("record") Societiesjobtype record, @Param("example") SocietiesjobtypeExample example);

    int updateByPrimaryKeySelective(Societiesjobtype record);

    int updateByPrimaryKey(Societiesjobtype record);
}