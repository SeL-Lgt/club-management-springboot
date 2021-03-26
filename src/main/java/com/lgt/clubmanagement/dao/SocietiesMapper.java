package com.lgt.clubmanagement.dao;

import com.lgt.clubmanagement.entity.Societies;
import com.lgt.clubmanagement.entity.SocietiesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SocietiesMapper {
    long countByExample(SocietiesExample example);

    int deleteByExample(SocietiesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Societies record);

    int insertSelective(Societies record);

    List<Societies> selectByExampleWithBLOBs(SocietiesExample example);

    List<Societies> selectByExample(SocietiesExample example);

    Societies selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Societies record, @Param("example") SocietiesExample example);

    int updateByExampleWithBLOBs(@Param("record") Societies record, @Param("example") SocietiesExample example);

    int updateByExample(@Param("record") Societies record, @Param("example") SocietiesExample example);

    int updateByPrimaryKeySelective(Societies record);

    int updateByPrimaryKeyWithBLOBs(Societies record);

    int updateByPrimaryKey(Societies record);
}