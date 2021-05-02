package com.lgt.clubmanagement.controller;

import com.github.pagehelper.PageHelper;
import com.lgt.clubmanagement.entity.*;
import com.lgt.clubmanagement.service.SocietiesPersonnelService;
import com.lgt.clubmanagement.service.SocietiesService;
import com.lgt.clubmanagement.service.TaskService;
import com.lgt.clubmanagement.service.UserService;
import com.lgt.clubmanagement.utils.DateUtil;
import com.lgt.clubmanagement.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.Date;
import java.util.List;

@Api(tags = "社团操作")
@RestController
@RequestMapping(value = "societies", produces = "application/json")
public class SocietiesController {

    @Autowired
    private SocietiesService societiesService;
    @Autowired
    private SocietiesPersonnelService societiesPersonnelService;
    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;

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

    @ApiOperation(value = "获取职位类型")
    @GetMapping("getSocietiesJobs")
    public JsonResult getSocietiesJobs() {
        try {
            List<Societiesjobtype> list = societiesService.querySocietiesJobType();
            return JsonResult.success(list, "查询职位类型");
        } catch (Exception e) {
            return JsonResult.error("", e.toString());
        }
    }

    @ApiOperation(value = "创建社团")
    @PostMapping("createSocieties")
    public JsonResult createSocieties(Societies societies, Integer uId) {
        Date data = new Date();
        societies.setDate(DateUtil.parseDate(DateUtil.format(data, DateUtil.DEFAULT_FORMAT), DateUtil.DEFAULT_FORMAT));
        // 1为同意创建 0为不同意
        societies.setStatus("0");
        societies.setMoney(0.0);

        Userinfo userinfo = userService.queryUserById(uId);

        try {
            Integer value = societiesService.addSocieties(societies);

            Integer sId = societiesService.querySocietiesByCondition(societies).get(0).getId();

            // 录入成员信息---职位社长
            Societiespersonnel societiesPersonnel = new Societiespersonnel();
            societiesPersonnel.setUid(uId);
            societiesPersonnel.setSid(sId);
            societiesPersonnel.setDate(data);
            societiesPersonnel.setJob(3);
            societiesPersonnel.setStatus(1);
            societiesPersonnelService.addSocietiesPersonnel(societiesPersonnel);

            // 添加任务--创建社团任务
            Task task = new Task();
            task.setSid(sId);
            task.setName("申请创建" + societies.getSname());
            task.setIntroduction(userinfo.getName() + "申请创建" + societies.getSname());
            task.setDate(data);
            // 事务状态：0-未完成
            task.setStatus(0);
            // 事务类型：1、申请加入社团。2、申请创建社团。3、经费申请。4、社团任务
            task.setType(2);
            // 发布人
            task.setPublisher(uId);
            task.setNumber(3);
            taskService.createTask(task);


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

    @ApiOperation(value = "按条件查询社团信息")
    @GetMapping("querySocietiesByCondition")
    public JsonResult querySocietiesByCondition(Societies societies) {
        try {
            List<Societies> data = societiesService.querySocietiesByCondition(societies);
            return JsonResult.success(data, "查询成功");
        } catch (Exception e) {
            return JsonResult.success("", "查询失败");
        }
    }

    @ApiOperation(value = "修改社团信息")
    @PostMapping("updateSocietiesInfo")
    public JsonResult updateSocietiesInfo(Societies societies) {
        try {
            System.out.println(societies);
            Integer value = societiesService.updateSocietiesInfo(societies);
            return JsonResult.success(value, "修改成功");
        } catch (Exception e) {
            return JsonResult.error("", "修改失败");
        }
    }
}
