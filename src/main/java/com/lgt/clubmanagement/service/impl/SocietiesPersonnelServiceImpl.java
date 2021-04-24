package com.lgt.clubmanagement.service.impl;

import com.lgt.clubmanagement.dao.SocietiespersonnelMapper;
import com.lgt.clubmanagement.entity.Societiespersonnel;
import com.lgt.clubmanagement.entity.SocietiespersonnelExample;
import com.lgt.clubmanagement.service.SocietiesPersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SocietiesPersonnelServiceImpl implements SocietiesPersonnelService {

    @Autowired
    private SocietiespersonnelMapper societiespersonnelMapper;

    @Override
    public int addSocietiesPersonnel(Societiespersonnel societiesPersonnel) {
        return societiespersonnelMapper.insert(societiesPersonnel);
    }

    @Override
    public List<Societiespersonnel> querySocietiesPersonnelByExample(Societiespersonnel societiespersonnel, Date startTime, Date endTime) {
        SocietiespersonnelExample example = new SocietiespersonnelExample();
        SocietiespersonnelExample.Criteria criteria = example.createCriteria();

        if (societiespersonnel.getSid() != null && !societiespersonnel.getSid().equals("")) {
            criteria.andSidEqualTo(societiespersonnel.getSid());
        }
        if (societiespersonnel.getUid() != null && !societiespersonnel.getUid().equals("")) {
            criteria.andUidEqualTo(societiespersonnel.getUid());
        }
        if (societiespersonnel.getJob() != null && !societiespersonnel.getJob().equals("")) {
            criteria.andJobEqualTo(societiespersonnel.getJob());
        }

        if (startTime != null && endTime != null) {
            criteria.andDateBetween(startTime, endTime);
        }
        return societiespersonnelMapper.selectByExample(example);
    }

    @Override
    public List<Societiespersonnel> querySocietiesPersonnelAll(Integer sId) {
        SocietiespersonnelExample example = new SocietiespersonnelExample();
        SocietiespersonnelExample.Criteria criteria = example.createCriteria();
        criteria.andSidEqualTo(sId);
        example.setOrderByClause("job DESC");
        return societiespersonnelMapper.selectByExample(example);
    }

    @Override
    public int deleteSocietiesPersonnel(Societiespersonnel societiespersonnel) {
        SocietiespersonnelExample example = new SocietiespersonnelExample();
        SocietiespersonnelExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(societiespersonnel.getUid());
        criteria.andSidEqualTo(societiespersonnel.getSid());
        return societiespersonnelMapper.deleteByExample(example);
    }

    @Override
    public List<Societiespersonnel> querySocietiesPersonnelByJob(int sid, int job) {
        SocietiespersonnelExample example=new SocietiespersonnelExample();
        SocietiespersonnelExample.Criteria criteria=example.createCriteria();
        criteria.andSidEqualTo(sid);
        criteria.andJobEqualTo(job);
        return societiespersonnelMapper.selectByExample(example);
    }
}
