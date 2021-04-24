package com.lgt.clubmanagement.service.impl;

import com.lgt.clubmanagement.dao.ActivityMapper;
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

        criteria.andSidEqualTo(activity.getSid());

        if (activity.getName() != null && !activity.getName().equals("")) {
            criteria.andNameLike("%" + activity.getName() + "%");
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

//    @Override
//    public int insertActivityPeople() {
//        return 0;
//    }
}
