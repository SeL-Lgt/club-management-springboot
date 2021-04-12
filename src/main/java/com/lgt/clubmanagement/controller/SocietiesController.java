package com.lgt.clubmanagement.controller;

import com.github.pagehelper.PageHelper;
import com.lgt.clubmanagement.entity.Societies;
import com.lgt.clubmanagement.entity.Societiestype;
import com.lgt.clubmanagement.service.SocietiesService;
import com.lgt.clubmanagement.utils.DateUtil;
import com.lgt.clubmanagement.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Api(tags = "社团操作")
@RestController
@RequestMapping(value = "societies", produces = "application/json")
public class SocietiesController {

    @Autowired
    private SocietiesService societiesService;

    @ApiOperation(value = "查询社团类型")
    @GetMapping("getSocietiesType")
    public JsonResult getSocietiesType() {
        try {
            List<Societiestype> societiestypes = societiesService.querySocietiesType();
            return JsonResult.success(societiestypes, "查询社团类型");
        } catch (Exception e) {
            return JsonResult.error("", e.toString());
        }
    }

    @ApiOperation(value = "创建社团")
    @PostMapping("createSocieties")
    public JsonResult createSocieties(Societies societies) {
        Date data = new Date();
        societies.setDate(DateUtil.parseDate(DateUtil.format(data, DateUtil.DEFAULT_FORMAT), DateUtil.DEFAULT_FORMAT));
        // 1为同意创建 0为不同意
        societies.setStatus("1");
        societies.setMoney(0.0);
        try {
            Integer value = societiesService.addSocieties(societies);
            return JsonResult.success(value, "创建成功");
        } catch (Exception e) {
            return JsonResult.error("", e.toString());
        }
    }

    @ApiOperation(value = "查询所有社团")
    @GetMapping("getSocietiesByAll")
    public JsonResult getSocietiesByAll() {
        try {
            List<Societies> societies = societiesService.querySocietiesByAll();
            return JsonResult.success(societies, "查询成功");
        } catch (Exception e) {
            return JsonResult.error("", e.toString());
        }
    }
}
