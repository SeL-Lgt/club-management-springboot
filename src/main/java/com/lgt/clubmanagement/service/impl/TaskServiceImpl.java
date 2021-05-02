package com.lgt.clubmanagement.service.impl;

import com.lgt.clubmanagement.dao.TaskMapper;
import com.lgt.clubmanagement.entity.Task;
import com.lgt.clubmanagement.entity.TaskExample;
import com.lgt.clubmanagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskMapper taskMapper;

    @Override
    public Task queryTaskById(Integer id) {
        return taskMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Task> queryTaskList(Task task, Date startTime, Date endTime) {
        TaskExample taskExample = new TaskExample();
        TaskExample.Criteria criteria = taskExample.createCriteria();

        if(task.getPublisher()!= null && !task.getPublisher().equals("")){
            criteria.andPublisherEqualTo(task.getPublisher());
        }
        if(task.getNumber()!= null && !task.getNumber().equals("")){
            criteria.andNumberEqualTo(task.getNumber());
        }

        if (task.getId() != null && !task.getId().equals("")) {
            criteria.andIdEqualTo(task.getId());
        }
        if (task.getType() != null && !task.getType().equals("")) {
            criteria.andTypeEqualTo(task.getType());
        }
        if (task.getStatus() != null && !task.getStatus().equals("")) {
            criteria.andStatusEqualTo(task.getStatus());
        }
        if (startTime != null && endTime != null) {
            criteria.andDateBetween(startTime, endTime);
        }

        if (task.getSid() != null && !task.getSid().equals("")) {
            criteria.andSidEqualTo(task.getSid());
        }

        if (task.getName() != null && !task.getName().equals("")) {
            criteria.andNameLike("%" + task.getName() + "%");
        }

        return taskMapper.selectByExampleWithBLOBs(taskExample);
    }

    @Override
    public int createTask(Task task) {
        return taskMapper.insert(task);
    }

    @Override
    public int deleteTask(Integer id) {
        return taskMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateTask(Task task) {
        return taskMapper.updateByPrimaryKey(task);
    }
}
