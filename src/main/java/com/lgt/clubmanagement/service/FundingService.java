package com.lgt.clubmanagement.service;

import com.lgt.clubmanagement.entity.Funding;

import java.util.Date;
import java.util.List;

public interface FundingService {

    /**
     * 申请经费
     *
     * @param funding
     * @return
     */
    int createFunding(Funding funding);

    /**
     * 更改经费状态
     *
     * @param funding
     * @return
     */
    int updateFunding(Funding funding);

    /**
     * 查询社团经费
     *
     * @param funding
     * @return
     */
    List<Funding> queryFundingByAll(Funding funding, Double min, Double max, Date startTime, Date endTime);

    /**
     * 查询个人分配信息
     *
     * @param dNumber
     * @return
     */
    List<Funding> queryFundingByMy(String dNumber);
}
