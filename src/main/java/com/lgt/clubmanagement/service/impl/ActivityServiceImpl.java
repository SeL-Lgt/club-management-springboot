package com.lgt.clubmanagement.service.impl;

import com.lgt.clubmanagement.dao.ActivityMapper;
import com.lgt.clubmanagement.dao.ActivitypeopleMapper;
import com.lgt.clubmanagement.dao.ActivitytypeMapper;
import com.lgt.clubmanagement.entity.*;
import com.lgt.clubmanagement.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private ActivitytypeMapper activitytypeMapper;

    @Autowired
    private ActivitypeopleMapper activitypeopleMapper;

    @Override
    public int createActivity(ActivityWithBLOBs activity) {
        return activityMapper.insert(activity);
    }

    @Override
    public List<ActivityWithBLOBs> queryActivityByAll() {
        ActivityExample example = new ActivityExample();
        ActivityExample.Criteria criteria = example.createCriteria();
        return activityMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<ActivityWithBLOBs> queryActivityByExample(ActivityWithBLOBs activity) {
        ActivityExample example = new ActivityExample();
        ActivityExample.Criteria criteria = example.createCriteria();

        if (activity.getId() != null && !activity.getId().equals("")) {
            criteria.andIdEqualTo(activity.getId());
        }

        if (activity.getSid() != null && !activity.getSid().equals("")) {
            criteria.andSidEqualTo(activity.getSid());
        }
        if (activity.getName() != null && !activity.getName().equals("")) {
            criteria.andNameLike("%" + activity.getName() + "%");
        }

        if (activity.getPrincipal() != null && !activity.getPrincipal().equals("")) {
            criteria.andPrincipalEqualTo(activity.getPrincipal());
        }

        if (activity.getType() != null && !activity.getType().equals("")) {
            criteria.andTypeEqualTo(activity.getType());
        }

        if (activity.getStarttime() != null && !activity.getStarttime().equals("")) {
            criteria.andStarttimeGreaterThanOrEqualTo(activity.getStarttime());
        }
        if (activity.getEndtime() != null && !activity.getEndtime().equals("")) {
            criteria.andEndtimeLessThanOrEqualTo(activity.getEndtime());
        }

        return activityMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public int deleteActivity(ActivityWithBLOBs activity) {
        return activityMapper.deleteByPrimaryKey(activity.getId());
    }

    @Override
    public int updateActivity(ActivityWithBLOBs activity) {
        return activityMapper.updateByPrimaryKey(activity);
    }

    @Override
    public List<Activitytype> queryActivityTypeByAll() {
        ActivitytypeExample example = new ActivitytypeExample();
        ActivitytypeExample.Criteria criteria = example.createCriteria();
        return activitytypeMapper.selectByExample(example);
    }

    @Override
    public int insertActivityPeople(Activitypeople activitypeople) {
        return activitypeopleMapper.insert(activitypeople);
    }

    @Override
    public List<Activitypeople> queryActivityPeopleByAll(Integer id) {
        ActivitypeopleExample example = new ActivitypeopleExample();
        ActivitypeopleExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        return activitypeopleMapper.selectByExample(example);
    }

    @Override
    public List<Activitypeople> queryActivityPeopleByMy(Integer uid) {
        ActivitypeopleExample example = new ActivitypeopleExample();
        ActivitypeopleExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(uid);
        return activitypeopleMapper.selectByExample(example);
    }

    @Override
    public int deleteActivityPeople(Integer id, Integer uid) {
        ActivitypeopleExample example = new ActivitypeopleExample();
        ActivitypeopleExample.Criteria criteria=example.createCriteria();
        criteria.andUidEqualTo(uid);
        criteria.andIdEqualTo(id);
        return activitypeopleMapper.deleteByExample(example);
    }
}
