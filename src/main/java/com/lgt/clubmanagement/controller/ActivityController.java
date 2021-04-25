package com.lgt.clubmanagement.controller;


import com.lgt.clubmanagement.entity.*;
import com.lgt.clubmanagement.service.ActivityService;
import com.lgt.clubmanagement.service.SocietiesService;
import com.lgt.clubmanagement.service.UserService;
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

    @Autowired
    private UserService userService;

    @Autowired
    private SocietiesService societiesService;

    @ApiOperation(value = "创建社团活动")
    @PostMapping("createActivity")
    public JsonResult createActivity(ActivityWithBLOBs activity, String userName) {
        try {
            int count = activityService.createActivity(activity);
            Activitypeople activitypeople = new Activitypeople();
            activitypeople.setUid(activity.getPrincipal());
            activitypeople.setName(userName);
            activitypeople.setId(activity.getId());
            activityService.insertActivityPeople(activitypeople);
            return JsonResult.success(count, "创建成功");
        } catch (Exception e) {
            return JsonResult.error("", e.toString());
        }
    }

    @ApiOperation(value = "查询所有社团活动")
    @GetMapping("queryActivityByAll")
    public JsonResult queryActivityByAll() {
        try {
            List<ActivityWithBLOBs> list = activityService.queryActivityByAll();

            for (ActivityWithBLOBs a : list) {
                Societies societies = new Societies();
                societies.setId(a.getSid());
                Societies db = societiesService.querySocietiesByCondition(societies).get(0);
                a.setSocieties(db);

                Userinfo userinfo = userService.queryUserById(a.getPrincipal());
                a.setUserinfo(userinfo);
            }

            return JsonResult.success(list, "查询成功");
        } catch (Exception e) {
            return JsonResult.error("", e.toString());
        }
    }

    @ApiOperation(value = "查询相应社团活动")
    @PostMapping("queryActivityByExample")
    public JsonResult queryActivityByExample(ActivityWithBLOBs activity) {
        try {
            List<ActivityWithBLOBs> list = activityService.queryActivityByExample(activity);
            return JsonResult.success(list, "查询成功");
        } catch (Exception e) {
            return JsonResult.error("", e.toString());
        }
    }

    @ApiOperation(value = "查询我的活动")
    @PostMapping("queryActivityByMy")
    public JsonResult queryActivityByMy(Integer uid) {
        try {
            List<Activitypeople> list = activityService.queryActivityPeopleByMy(uid);
            for (Activitypeople a : list) {
                ActivityWithBLOBs activity = new ActivityWithBLOBs();
                System.out.println(a.getId());
                activity.setId(a.getId());
                Activity db = activityService.queryActivityByExample(activity).get(0);

                Userinfo userinfo = userService.queryUserById(db.getPrincipal());

                a.setActivity(db);
                a.setUserinfo(userinfo);
            }
            return JsonResult.success(list, "查询成功");
        } catch (Exception e) {
            return JsonResult.error("查询失败", e.toString());
        }
    }

    @ApiOperation(value = "删除活动")
    @PostMapping("deleteActivity")
    public JsonResult deleteActivity(ActivityWithBLOBs activity) {
        try {
            int count = activityService.deleteActivity(activity);
            return JsonResult.success(count, "删除成功");
        } catch (Exception e) {
            return JsonResult.error("", "删除失败");
        }
    }

    @ApiOperation(value = "退出活动")
    @PostMapping("deleteActivityPeople")
    public JsonResult deleteActivityPeople(Integer id, Integer uid) {
        try {
            int count = activityService.deleteActivityPeople(id, uid);
            return JsonResult.success(count, "删除成功");
        } catch (Exception e) {
            return JsonResult.error("", "删除失败");
        }
    }

    @ApiOperation(value = "参加活动")
    @PostMapping("addActivityPeople")
    public JsonResult addActivityPeople(int id, int uid, String name) {
        try {
            Activitypeople activitypeople = new Activitypeople();
            activitypeople.setId(id);
            activitypeople.setUid(uid);
            activitypeople.setName(name);
            int count = activityService.insertActivityPeople(activitypeople);
            return JsonResult.success(count, "加入成功");
        } catch (Exception e) {
            return JsonResult.error("", "加入失败");
        }
    }

    @ApiOperation(value = "更新活动信息")
    @PostMapping("updateActivity")
    public JsonResult updateActivity(ActivityWithBLOBs activity) {
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
