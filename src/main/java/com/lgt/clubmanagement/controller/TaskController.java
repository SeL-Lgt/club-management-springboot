package com.lgt.clubmanagement.controller;

import com.lgt.clubmanagement.entity.Societiespersonnel;
import com.lgt.clubmanagement.entity.Task;
import com.lgt.clubmanagement.entity.Userinfo;
import com.lgt.clubmanagement.service.SocietiesPersonnelService;
import com.lgt.clubmanagement.service.TaskService;
import com.lgt.clubmanagement.service.UserService;
import com.lgt.clubmanagement.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private SocietiesPersonnelService societiesPersonnelService;

    @ApiOperation(value = "查询任务信息", notes = "查询任务信息")
    @PostMapping("queryTask")
    public JsonResult queryTask(Task task, String publisher, String receiver) {
        try {
            /**
             * 模糊查询 发布人名字
             */
//            if (publisher != null && !publisher.equals("")) {
//                Userinfo publisherInfo = new Userinfo();
//                publisherInfo.setName(publisher);
//                List<Userinfo> publisherDB = userService.queryUserByExample(publisherInfo);
//                for (Userinfo db : publisherDB) {
//                    Societiespersonnel societiespersonnel = new Societiespersonnel();
//                    societiespersonnel.setSid(task.getSid());
//                    societiespersonnel.setUid(db.getId());
//                    societiespersonnel.setStatus(1);
//                    List<Societiespersonnel> list = societiesPersonnelService.querySocietiesPersonnelByExample(societiespersonnel, null, null);
//                }
//            }
//
//            if (receiver != null && !receiver.equals("")) {
//                Userinfo receiverInfo = new Userinfo();
//                receiverInfo.setName(receiver);
//            }
            return JsonResult.success("", "查询成功");
        } catch (Exception e) {
            return JsonResult.error(e, "查询失败");
        }
    }

    @ApiOperation(value = "发布任务信息", notes = "发布任务信息")
    @PostMapping("createTask")
    public JsonResult createTask(Task task) {
        try {
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
            Integer value = taskService.updateTask(task);
            return JsonResult.success(value, "更新任务成功");
        } catch (Exception e) {
            return JsonResult.error(e, "更新任务失败");
        }
    }
}
