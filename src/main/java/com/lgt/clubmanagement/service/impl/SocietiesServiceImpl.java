package com.lgt.clubmanagement.service.impl;

import com.lgt.clubmanagement.dao.SocietiesMapper;
import com.lgt.clubmanagement.dao.SocietiesjobtypeMapper;
import com.lgt.clubmanagement.dao.SocietiespersonnelMapper;
import com.lgt.clubmanagement.dao.SocietiestypeMapper;
import com.lgt.clubmanagement.entity.*;
import com.lgt.clubmanagement.service.SocietiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocietiesServiceImpl implements SocietiesService {

    @Autowired
    private SocietiesMapper societiesMapper;
    @Autowired
    private SocietiesjobtypeMapper societiesjobtypeMapper;
    @Autowired
    private SocietiestypeMapper societiestypeMapper;
    @Autowired
    private SocietiespersonnelMapper societiespersonnelMapper;

    @Override
    public int addSocieties(Societies societies) {
        return societiesMapper.insert(societies);
    }

    @Override
    public List<Societies> querySocietiesByAll() {
        SocietiesExample example = new SocietiesExample();
        return societiesMapper.selectByExample(example);
    }

    @Override
    public Societies querySocietiesByCondition(Societies societies) {
        SocietiesExample example = new SocietiesExample();
        SocietiesExample.Criteria criteria = example.createCriteria();

        if (societies.getSname() != null && !societies.getSname().equals("")) {
            criteria.andSnameLike("%" + societies.getSname() + "%");
        }
        if (societies.getAssociation() != null && !societies.getAssociation().equals("")) {
            criteria.andAssociationEqualTo(societies.getAssociation());
        }
        if (societies.getFounder() != null && !societies.getFounder().equals("")) {
            criteria.andFounderEqualTo(societies.getFounder());
        }
        if (societies.getInstructor() != null && !societies.getInstructor().equals("")) {
            criteria.andInstructorEqualTo(societies.getInstructor());
        }

        return societiesMapper.selectByExample(example).get(0);
    }

    @Override
    public List<Societiesjobtype> querySocietiesJobType() {
        SocietiesjobtypeExample example = new SocietiesjobtypeExample();
        return societiesjobtypeMapper.selectByExample(example);
    }

    @Override
    public List<Societiestype> querySocietiesType() {
        SocietiestypeExample example = new SocietiestypeExample();
        return societiestypeMapper.selectByExample(example);
    }

    @Override
    public List<Societiespersonnel> querySocietiesPersonnel(Integer sId) {
        SocietiespersonnelExample example = new SocietiespersonnelExample();
        return societiespersonnelMapper.selectByExample(example);
    }
}
