package com.lgt.clubmanagement.dao;

import com.lgt.clubmanagement.entity.Photo;
import com.lgt.clubmanagement.entity.PhotoExample;
import com.lgt.clubmanagement.entity.PhotoWithBLOBs;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PhotoMapper {
    long countByExample(PhotoExample example);

    int deleteByExample(PhotoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PhotoWithBLOBs record);

    int insertSelective(PhotoWithBLOBs record);

    List<PhotoWithBLOBs> selectByExampleWithBLOBs(PhotoExample example);

    List<Photo> selectByExample(PhotoExample example);

    PhotoWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PhotoWithBLOBs record, @Param("example") PhotoExample example);

    int updateByExampleWithBLOBs(@Param("record") PhotoWithBLOBs record, @Param("example") PhotoExample example);

    int updateByExample(@Param("record") Photo record, @Param("example") PhotoExample example);

    int updateByPrimaryKeySelective(PhotoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PhotoWithBLOBs record);

    int updateByPrimaryKey(Photo record);
}