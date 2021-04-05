package com.lgt.clubmanagement.service;

import com.lgt.clubmanagement.entity.Societies;
import com.lgt.clubmanagement.entity.Societiesjobtype;
import com.lgt.clubmanagement.entity.Societiespersonnel;
import com.lgt.clubmanagement.entity.Societiestype;

import java.util.List;

public interface SocietiesService {
    /**
     * 创建社团
     *
     * @param societies
     * @return
     */
    int addSocieties(Societies societies);

    /**
     * 查询所有社团
     *
     * @return
     */
    List<Societies> querySocietiesByAll();

    /**
     * 查询单一社团信息
     *
     * @param societies
     * @return
     */
    Societies querySocietiesByCondition(Societies societies);

    /**
     * 查询社团职位列表
     *
     * @return
     */
    List<Societiesjobtype> querySocietiesJobType();

    /**
     * 查询所有社团类型
     *
     * @return
     */
    List<Societiestype> querySocietiesType();

    /**
     * 查询社团人数及信息
     *
     * @param sId
     * @return
     */
    List<Societiespersonnel> querySocietiesPersonnel(Integer sId);

}
