package com.lgt.clubmanagement.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Api(tags = "社团成员操作")
@RestController
@RequestMapping(value = "societiesPersonnel", produces = "application/json")
public class SocietiesPersonnelController {

    @Autowired
    private SocietiesPersonnelService societiesPersonnelService;
    @Autowired
    private SocietiesService societiesService;
    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;

    @ApiOperation(value = "添加社团成员")
    @PostMapping("addSocietiesPersonnel")
    public JsonResult addSocietiesPersonnel(Societiespersonnel societiespersonnel, String name) {
        // 1:社团成员
        societiespersonnel.setJob(1);
        //社团成员状态：未允许加入
        societiespersonnel.setStatus(0);
        Date data = new Date();
        societiespersonnel.setDate(DateUtil.parseDate(DateUtil.format(data, DateUtil.DEFAULT_FORMAT), DateUtil.DEFAULT_FORMAT));

        // 添加至事务
        // 是否允许加入社团
        Task task = new Task();
        task.setName(name + "申请加入社团");
        // 事务类型：1、申请加入社团。2、申请创建社团。3、经费申请。4、社团任务
        task.setType(1);
        // 发布人
//        task.setPublisher(societiespersonnel.getUid());
        try {
            societiesPersonnelService.addSocietiesPersonnel(societiespersonnel);
            return JsonResult.success("", "添加成功");
        } catch (Exception e) {
            return JsonResult.error(e, "添加失败");
        }
    }

    @ApiOperation(value = "根据id查询社团成员")
    @PostMapping("querySocietiesPersonnelByOne")
    public JsonResult querySocietiesPersonnelByOne(Societiespersonnel societiespersonnel) {
        try {
            List<Societiespersonnel> list = societiesPersonnelService.querySocietiesPersonnelByExample(societiespersonnel, null, null);
            for (int i = 0; i < list.size(); i++) {
                Societies temp = new Societies();
                temp.setId(list.get(i).getSid());
                list.get(i).setSocieties(societiesService.querySocietiesByCondition(temp).get(0));
                list.get(i).setUserinfo(userService.queryUserById(list.get(i).getUid()));
            }
            return JsonResult.success(list, "查询成功");
        } catch (Exception e) {
            return JsonResult.error(e, "查询失败");
        }
    }

    @ApiOperation(value = "模糊查询社团成员")
    @PostMapping("querySocietiesPersonnelByExample")
    public JsonResult querySocietiesPersonnelByExample(Integer sid, Integer job, String startTime, String endTime, String name) {
        try {
            Userinfo userinfo = new Userinfo();
            userinfo.setName(name);
            Date start = null;
            Date end = null;
            if (!startTime.equals("") && startTime != null) {
                start = DateUtil.parseDate(startTime, DateUtil.DEFAULT_FORMAT);
                System.out.println(startTime);
            }
            if (!endTime.equals("") && endTime != null) {
                end = DateUtil.parseDate(endTime, DateUtil.DEFAULT_FORMAT);
                System.out.println(endTime);
            }
            List<Userinfo> list = userService.queryUserByExample(userinfo);
            for (int i = 0; i < list.size(); i++) {
                Societiespersonnel societiespersonnel = new Societiespersonnel();
                societiespersonnel.setUid(list.get(i).getId());
                societiespersonnel.setSid(sid);
                societiespersonnel.setJob(job);
                List<Societiespersonnel> sList = societiesPersonnelService.querySocietiesPersonnelByExample(societiespersonnel, start, end);
                list.get(i).setSocietiesPersonnel(sList);
            }

            return JsonResult.success(list, "查询成功");
        } catch (Exception e) {
            return JsonResult.error(e, "查询失败");
        }
    }

    @ApiOperation(value = "查询相应社团所有成员")
    @PostMapping("querySocietiesPersonnelAll")
    public JsonResult querySocietiesPersonnelAll(Integer sId) {
        try {
            List<Societiespersonnel> list = societiesPersonnelService.querySocietiesPersonnelAll(sId);
            return JsonResult.success(list, "查询成功");
        } catch (Exception e) {
            return JsonResult.error(e, "查询失败");
        }
    }

    @ApiOperation(value = "删除社团成员")
    @PostMapping("deleteSocietiesPersonnel")
    public JsonResult deleteSocietiesPersonnel(Societiespersonnel societiespersonnel) {
        try {
            int count = societiesPersonnelService.deleteSocietiesPersonnel(societiespersonnel);
            return JsonResult.success(count, "删除成功");
        } catch (Exception e) {
            System.out.println(e);
            return JsonResult.error(e, "删除失败");
        }
    }
}
