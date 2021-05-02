package com.lgt.clubmanagement.service;

import com.lgt.clubmanagement.entity.Societiespersonnel;

import java.util.Date;
import java.util.List;

public interface SocietiesPersonnelService {
    /**
     * 添加社团成员
     *
     * @param societiesPersonnel
     * @return
     */
    int addSocietiesPersonnel(Societiespersonnel societiesPersonnel);

    /**
     * 根据id查询社团成员
     * 根据职位降序
     *
     * @param societiespersonnel
     * @param startTime
     * @param endTime
     * @return
     */
    List<Societiespersonnel> querySocietiesPersonnelByExample(Societiespersonnel societiespersonnel, Date startTime, Date endTime);

    /**
     * 查询相应社团所有成员
     *
     * @param sId 社团id
     * @return
     */
    List<Societiespersonnel> querySocietiesPersonnelAll(Integer sId);

    /**
     * 删除社团成员
     *
     * @param societiespersonnel 根据uId、sId删除
     * @return
     */
    int deleteSocietiesPersonnel(Societiespersonnel societiespersonnel);

    /**
     * 查询社团职位人数
     * @param sid
     * @param job
     * @return
     */
    List<Societiespersonnel> querySocietiesPersonnelByJob(int sid, int job);


    /**
     * 更新社团成员信息
     * @param societiespersonnel
     * @return
     */
    int updateSocietiesPersonnel(Societiespersonnel societiespersonnel);
}
