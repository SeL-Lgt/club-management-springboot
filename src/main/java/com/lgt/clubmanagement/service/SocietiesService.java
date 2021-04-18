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
     * 查询社团信息
     *
     * @param societies
     * @return
     */
    List<Societies> querySocietiesByCondition(Societies societies);

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
     * 更新社团信息
     * @param societies
     * @return
     */
    int updateSocietiesInfo(Societies societies);

}
