package com.lgt.clubmanagement.service;

import com.lgt.clubmanagement.entity.Activity;
import com.lgt.clubmanagement.entity.ActivityWithBLOBs;
import com.lgt.clubmanagement.entity.Activitypeople;
import com.lgt.clubmanagement.entity.Activitytype;

import java.util.List;

public interface ActivityService {

    /**
     * 创建活动
     *
     * @param activity
     * @return
     */
    int createActivity(ActivityWithBLOBs activity);

    /**
     * 获取所有社团活动
     *
     * @return
     */
    List<ActivityWithBLOBs> queryActivityByAll();

    /**
     * 按条件查询信息
     *
     * @param activity
     * @return
     */
    List<ActivityWithBLOBs> queryActivityByExample(ActivityWithBLOBs activity);

    /**
     * 删除社团信息
     *
     * @param activity
     * @return
     */
    int deleteActivity(ActivityWithBLOBs activity);

    /**
     * 更新社团信息
     *
     * @param activity
     * @return
     */
    int updateActivity(ActivityWithBLOBs activity);

    /**
     * 查询所有活动类型
     *
     * @return
     */
    List<Activitytype> queryActivityTypeByAll();

    /**
     * 添加活动成员
     *
     * @param activitypeople
     * @return
     */
    int insertActivityPeople(Activitypeople activitypeople);

    /**
     * 查看活动成员
     *
     * @param id
     * @return
     */
    List<Activitypeople> queryActivityPeopleByAll(Integer id);

    /**
     * 查询我的活动
     *
     * @param uid
     * @return
     */
    List<Activitypeople> queryActivityPeopleByMy(Integer uid);

    /**
     * 退出活动
     *
     * @param id
     * @param uid
     * @return
     */
    int deleteActivityPeople(Integer id, Integer uid);

    /**
     * 删除所有活动人员
     *
     * @param id
     * @return
     */
    int deleteActivityPeople(Integer id);

}
