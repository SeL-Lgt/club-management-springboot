package com.lgt.clubmanagement.controller;

import com.lgt.clubmanagement.entity.Funding;
import com.lgt.clubmanagement.entity.Photo;
import com.lgt.clubmanagement.service.FundingService;
import com.lgt.clubmanagement.utils.DateUtil;
import com.lgt.clubmanagement.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import java.util.Date;
import java.util.List;

@Api(tags = "经费管理")
@RestController
@RequestMapping(value = "funding", produces = "application/json")
public class FundingController {
    @Autowired
    private FundingService fundingService;

    @ApiOperation(value = "发布任务")
    @PostMapping("createFunding")
    public JsonResult createFunding(Funding funding) {
        try {
            Date data = new Date();
            funding.setUdate(DateUtil.parseDate(DateUtil.format(data, DateUtil.DEFAULT_FORMAT), DateUtil.DEFAULT_FORMAT));
            funding.setStatus("0");

            int count = fundingService.createFunding(funding);
            return JsonResult.success(count, "创建失败");
        } catch (Exception e) {
            return JsonResult.error(e, "创建失败");
        }
    }

    @ApiOperation(value = "更新任务状态")
    @PostMapping("updateFunding")
    public JsonResult updateFunding(Funding funding) {
        try {
            int count = fundingService.updateFunding(funding);
            return JsonResult.success(count, "更新成功");
        } catch (Exception e) {
            return JsonResult.error(e, "更新失败");
        }
    }

    @ApiOperation(value = "查询所有任务（模糊查询）")
    @PostMapping("queryFundingByAll")
    public JsonResult queryFundingByAll(Funding funding, Double min, Double max, String startTime, String endTime) {
        try {
            Date start = null;
            Date end = null;
            if (startTime != null && !startTime.equals("")) {
                start = DateUtil.parseDate(startTime, DateUtil.DEFAULT_FORMAT);
            }
            if (endTime != null && !endTime.equals("")) {
                end = DateUtil.parseDate(endTime, DateUtil.DEFAULT_FORMAT);
            }
            List<Funding> list = fundingService.queryFundingByAll(funding, min, max, start, end);
            return JsonResult.success(list, "查询成功");
        } catch (Exception e) {
            return JsonResult.error(e, "查询失败");
        }
    }

    @ApiOperation(value = "查询我的任务")
    @PostMapping("queryFundingByMy")
    public JsonResult queryFundingByMy(String dNumber) {
        try {
            List<Funding> list = fundingService.queryFundingByMy(dNumber);
            return JsonResult.success(list, "查询成功");
        } catch (Exception e) {
            return JsonResult.error(e, "查询失败");
        }
    }
}
