package com.lgt.clubmanagement.dao;

import com.lgt.clubmanagement.entity.Societiespersonnel;
import com.lgt.clubmanagement.entity.SocietiespersonnelExample;
import com.lgt.clubmanagement.entity.SocietiespersonnelKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SocietiespersonnelMapper {
    long countByExample(SocietiespersonnelExample example);

    int deleteByExample(SocietiespersonnelExample example);

    int deleteByPrimaryKey(SocietiespersonnelKey key);

    int insert(Societiespersonnel record);

    int insertSelective(Societiespersonnel record);

    List<Societiespersonnel> selectByExample(SocietiespersonnelExample example);

    Societiespersonnel selectByPrimaryKey(SocietiespersonnelKey key);

    int updateByExampleSelective(@Param("record") Societiespersonnel record, @Param("example") SocietiespersonnelExample example);

    int updateByExample(@Param("record") Societiespersonnel record, @Param("example") SocietiespersonnelExample example);

    int updateByPrimaryKeySelective(Societiespersonnel record);

    int updateByPrimaryKey(Societiespersonnel record);
}