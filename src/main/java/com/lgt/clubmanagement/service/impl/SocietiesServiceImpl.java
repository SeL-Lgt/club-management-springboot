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
        SocietiesExample.Criteria criteria = example.createCriteria();
        // 1为同意创建 0为不同意
        // 查询允许创建的
        criteria.andStatusEqualTo("1");
        return societiesMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<Societies> querySocietiesByCondition(Societies societies) {
        SocietiesExample example = new SocietiesExample();
        SocietiesExample.Criteria criteria = example.createCriteria();

        if (societies.getId() != null && !societies.getId().equals("")) {
            criteria.andIdEqualTo(societies.getId());
        }
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

        return societiesMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<Societiesjobtype> querySocietiesJobType() {
        SocietiesjobtypeExample example = new SocietiesjobtypeExample();
        example.setOrderByClause("id asc");
        return societiesjobtypeMapper.selectByExample(example);
    }

    @Override
    public List<Societiestype> querySocietiesType() {
        SocietiestypeExample example = new SocietiestypeExample();
        example.setOrderByClause("id asc");
        return societiestypeMapper.selectByExample(example);
    }

    @Override
    public int updateSocietiesInfo(Societies societies) {
        return societiesMapper.updateByPrimaryKeySelective(societies);
    }
}
