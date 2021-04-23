package com.lgt.clubmanagement.service;

import com.lgt.clubmanagement.entity.Task;

import java.util.Date;
import java.util.List;

public interface TaskService {
    /**
     * 查询任务列表
     *
     * @param task
     * @return
     */
    List<Task> queryTaskList(Task task, Date startTime, Date endTime);

    /**
     * 新增任务
     *
     * @param task
     * @return
     */
    int createTask(Task task);

    /**
     * 删除任务列表
     *
     * @param id
     * @return
     */
    int deleteTask(Integer id);

    /**
     * 更新任务
     *
     * @param task
     * @return
     */
    int updateTask(Task task);

}
