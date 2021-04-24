package com.lgt.clubmanagement.controller;


import com.lgt.clubmanagement.entity.Activity;
import com.lgt.clubmanagement.entity.ActivityWithBLOBs;
import com.lgt.clubmanagement.entity.Activitytype;
import com.lgt.clubmanagement.service.ActivityService;
import com.lgt.clubmanagement.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import java.util.List;

@Api(tags = "活动操作")
@RestController
@RequestMapping(value = "activity", produces = "application/json")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @ApiOperation(value = "创建社团活动")
    @PostMapping("createActivity")
    public JsonResult createActivity(ActivityWithBLOBs activity) {
        try {
            int count = activityService.createActivity(activity);
            return JsonResult.success(count, "创建成功");
        } catch (Exception e) {
            return JsonResult.error("", e.toString());
        }
    }

    @ApiOperation(value = "查询所有社团活动")
    @GetMapping("queryActivityByAll")
    public JsonResult queryActivityByAll() {
        try {
            List<Activity> list = activityService.queryActivityByAll();
            return JsonResult.success(list, "查询成功");
        } catch (Exception e) {
            return JsonResult.error("", e.toString());
        }
    }

    @ApiOperation(value = "查询相应社团活动")
    @PostMapping("queryActivityByExample")
    public JsonResult queryActivityByExample(Activity activity) {
        try {
            List<Activity> list = activityService.queryActivityByExample(activity);
            return JsonResult.success(list, "查询成功");
        } catch (Exception e) {
            return JsonResult.error("", e.toString());
        }
    }

    @ApiOperation(value = "删除活动")
    @PostMapping("deleteActivity")
    public JsonResult deleteActivity(Activity activity) {
        try {
            int count = activityService.deleteActivity(activity);
            return JsonResult.success(count, "删除成功");
        } catch (Exception e) {
            return JsonResult.error("", "删除失败");
        }
    }

    @ApiOperation(value = "更新活动信息")
    @PostMapping("updateActivity")
    public JsonResult updateActivity(Activity activity) {
        try {
            int count = activityService.updateActivity(activity);
            return JsonResult.success(count, "更新成功");
        } catch (Exception e) {
            return JsonResult.error("", "更新失败");
        }
    }

    @ApiOperation(value = "查询所有活动类型")
    @GetMapping("queryActivityTypeByAll")
    public JsonResult queryActivityTypeByAll() {
        try {
            List<Activitytype> list = activityService.queryActivityTypeByAll();
            return JsonResult.success(list, "查询成功");
        } catch (Exception e) {
            return JsonResult.error("", "查询失败");
        }
    }
}
