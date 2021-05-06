package com.lgt.clubmanagement.service.impl;

import com.lgt.clubmanagement.dao.FundingMapper;
import com.lgt.clubmanagement.entity.Funding;
import com.lgt.clubmanagement.entity.FundingExample;
import com.lgt.clubmanagement.service.FundingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FundingServiceImpl implements FundingService {
    @Autowired
    private FundingMapper fundingMapper;

    @Override
    public int createFunding(Funding funding) {
        return fundingMapper.insert(funding);
    }

    @Override
    public int updateFunding(Funding funding) {
        return fundingMapper.updateByPrimaryKeyWithBLOBs(funding);
    }

    @Override
    public List<Funding> queryFundingByAll(Funding funding, Double min, Double max, Date startTime, Date endTime) {
        FundingExample example = new FundingExample();
        FundingExample.Criteria criteria = example.createCriteria();
        criteria.andSidEqualTo(funding.getSid());
        if (funding.getStatus() != null && !funding.getStatus().equals("")) {
            criteria.andStatusEqualTo(funding.getStatus());
        }
        if (max != null && min != null) {
            criteria.andMoneyBetween(min, max);
        } else if (min != null) {
            criteria.andMoneyGreaterThanOrEqualTo(min);
        }
        if (startTime != null && endTime != null) {
            criteria.andUdateBetween(startTime, endTime);
        }

        return fundingMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<Funding> queryFundingByMy(String dNumber) {
        FundingExample example = new FundingExample();
        FundingExample.Criteria criteria = example.createCriteria();
        criteria.andDnumberEqualTo(dNumber);
        return fundingMapper.selectByExampleWithBLOBs(example);
    }
}
