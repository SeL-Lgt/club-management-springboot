package com.lgt.clubmanagement.controller;


import com.lgt.clubmanagement.entity.Societies;
import com.lgt.clubmanagement.entity.Societiespersonnel;
import com.lgt.clubmanagement.entity.Task;
import com.lgt.clubmanagement.entity.Userinfo;
import com.lgt.clubmanagement.service.SocietiesPersonnelService;
import com.lgt.clubmanagement.service.SocietiesService;
import com.lgt.clubmanagement.service.TaskService;
import com.lgt.clubmanagement.service.UserService;
import com.lgt.clubmanagement.utils.DateUtil;
import com.lgt.clubmanagement.utils.JsonResult;
import com.lgt.clubmanagement.utils.ListUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Api(tags = "事务操作")
@RestController
@RequestMapping(value = "task", produces = "application/json")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    @Autowired
    private SocietiesService societiesService;

    @Autowired
    private SocietiesPersonnelService societiesPersonnelService;

    @ApiOperation(value = "查询任务信息", notes = "查询任务信息")
    @PostMapping("queryTask")
    public JsonResult queryTask(Task task, String startTime, String endTime) {
        try {
            Date start = null;
            Date end = null;

            if (startTime != null && !startTime.equals("")) {
                start = DateUtil.parseDate(startTime, DateUtil.DEFAULT_FORMAT);
                System.out.println(startTime);
            }
            if (endTime != null && !endTime.equals("")) {
                end = DateUtil.parseDate(endTime, DateUtil.DEFAULT_FORMAT);
                System.out.println(endTime);
            }

            List<Task> list = taskService.queryTaskList(task, start, end);

            for (Task t : list) {
                Userinfo n = new Userinfo();
                Userinfo p = new Userinfo();
                p.setId(t.getPublisher());
                n.setId(t.getNumber());
                n = userService.queryUserByExample(n).get(0);
                p = userService.queryUserByExample(p).get(0);

                t.setPublisherInfo(p);
                t.setNumberInfo(n);

                Societies societies = new Societies();
                societies.setId(t.getSid());
                societies = societiesService.querySocietiesByCondition(societies).get(0);

                t.setSocieties(societies);
            }

            return JsonResult.success(list, "查询成功");
        } catch (Exception e) {
            return JsonResult.error(e, "查询失败");
        }
    }

    @ApiOperation(value = "查询我的任务信息", notes = "查询我的任务信息")
    @PostMapping("queryMyTask")
    public JsonResult queryMyTask(String name, Integer sid, Integer type, Integer id, String startTime, Integer status, String endTime) {
        try {
            Date start = null;
            Date end = null;

            if (startTime != null && !startTime.equals("")) {
                start = DateUtil.parseDate(startTime, DateUtil.DEFAULT_FORMAT);
                System.out.println(startTime);
            }
            if (endTime != null && !endTime.equals("")) {
                end = DateUtil.parseDate(endTime, DateUtil.DEFAULT_FORMAT);
                System.out.println(endTime);
            }

            Task pTask = new Task();
            pTask.setPublisher(id);

            Task nTask = new Task();
            nTask.setNumber(id);

            pTask.setSid(sid);
            pTask.setName(name);
            pTask.setType(type);
            pTask.setStatus(status);

            nTask.setSid(sid);
            nTask.setName(name);
            nTask.setType(type);
            nTask.setStatus(status);


            List<Task> plist = taskService.queryTaskList(pTask, start, end);
            List<Task> nlist = taskService.queryTaskList(nTask, start, end);


            List pId = new ArrayList();

            for (Task p : plist) {
                pId.add(p.getId());
            }
            for (Task n : nlist) {
                pId.add(n.getId());
            }
            List<Integer> idList = ListUtil.joinList(pId);

            List<Task> list = new ArrayList();
            for (Integer temp : idList) {
                Task task = taskService.queryTaskById(temp);
                list.add(task);
            }


            for (Task t : list) {
                Userinfo n = new Userinfo();
                Userinfo p = new Userinfo();
                p.setId(t.getPublisher());
                n.setId(t.getNumber());
                n = userService.queryUserByExample(n).get(0);
                p = userService.queryUserByExample(p).get(0);

                t.setPublisherInfo(p);
                t.setNumberInfo(n);

                Societies societies = new Societies();
                societies.setId(t.getSid());
                societies = societiesService.querySocietiesByCondition(societies).get(0);

                t.setSocieties(societies);
            }


            return JsonResult.success(list, "查询成功");
        } catch (Exception e) {
            return JsonResult.error(e, "查询失败");
        }
    }

    @ApiOperation(value = "发布任务信息", notes = "发布任务信息")
    @PostMapping("createTask")
    public JsonResult createTask(Task task) {
        try {
            // 任务状态：未开始---0
            task.setStatus(0);
            Integer value = taskService.createTask(task);
            return JsonResult.success(value, "创建任务成功");
        } catch (Exception e) {
            return JsonResult.error(e, "创建任务失败");
        }
    }

    @ApiOperation(value = "删除任务", notes = "删除任务")
    @PostMapping("deleteTask")
    public JsonResult deleteTask(Integer id) {
        try {
            Integer value = taskService.deleteTask(id);
            return JsonResult.success(value, "删除任务成功");
        } catch (Exception e) {
            return JsonResult.error(e, "删除任务失败");
        }
    }

    @ApiOperation(value = "更新任务", notes = "更新任务")
    @PostMapping("updateTask")
    public JsonResult updateTask(Task task) {
        try {
            // status --- 0未开始1未完成2已完成3已拒绝
            int type = task.getType();
            if (task.getStatus() == 2) {
                if (type == 1) {
                    // 加入社团
                    // 发布人即id
                    Societiespersonnel societiespersonnel = new Societiespersonnel();
                    societiespersonnel.setUid(task.getPublisher());
                    societiespersonnel.setSid(task.getSid());
                    societiespersonnel = societiesPersonnelService.querySocietiesPersonnelByExample(societiespersonnel, null, null).get(0);
                    societiespersonnel.setStatus(1);
                    societiesPersonnelService.updateSocietiesPersonnel(societiespersonnel);

                } else if (type == 2) {
                    // 创建社团
                    Societies societies = new Societies();
                    societies.setId(task.getSid());
                    societies = societiesService.querySocietiesByCondition(societies).get(0);
                    societies.setStatus("1");

                    Userinfo userinfo = userService.queryUserByNumber(societies.getFounder());
                    Societiespersonnel societiespersonnel = new Societiespersonnel();
                    societiespersonnel.setSid(task.getSid());
                    societiespersonnel.setUid(userinfo.getId());

                    societiespersonnel = societiesPersonnelService.querySocietiesPersonnelByExample(societiespersonnel, null, null).get(0);
                    societiespersonnel.setStatus(1);
                    societiesPersonnelService.updateSocietiesPersonnel(societiespersonnel);

                    societiesService.updateSocietiesInfo(societies);
                }
            }

            Integer value = taskService.updateTask(task);
            return JsonResult.success(value, "更新任务成功");
        } catch (Exception e) {
            return JsonResult.error(e, "更新任务失败");
        }
    }
}
