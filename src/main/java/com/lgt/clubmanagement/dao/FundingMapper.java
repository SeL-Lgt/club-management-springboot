package com.lgt.clubmanagement.dao;

import com.lgt.clubmanagement.entity.Funding;
import com.lgt.clubmanagement.entity.FundingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FundingMapper {
    long countByExample(FundingExample example);

    int deleteByExample(FundingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Funding record);

    int insertSelective(Funding record);

    List<Funding> selectByExampleWithBLOBs(FundingExample example);

    List<Funding> selectByExample(FundingExample example);

    Funding selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Funding record, @Param("example") FundingExample example);

    int updateByExampleWithBLOBs(@Param("record") Funding record, @Param("example") FundingExample example);

    int updateByExample(@Param("record") Funding record, @Param("example") FundingExample example);

    int updateByPrimaryKeySelective(Funding record);

    int updateByPrimaryKeyWithBLOBs(Funding record);

    int updateByPrimaryKey(Funding record);
}