package com.lgt.clubmanagement.service.impl;

import com.lgt.clubmanagement.dao.UserMapper;
import com.lgt.clubmanagement.entity.User;
import com.lgt.clubmanagement.entity.UserExample;
import com.lgt.clubmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    UserExample example = new UserExample();
    UserExample.Criteria criteria = example.createCriteria();

    @Override
    public User getUserByNumber(String number) {
        criteria.andNumberEqualTo(number);
        return userMapper.selectByExample(example).get(0);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public List<User> queryUserByAll(User user) {
        if (user.getNumber() != null && !user.getNumber().equals("")) {
            criteria.andNumberLike("%" + user.getNumber() + "%");
        }
        if (user.getName() != null && !user.getName().equals("")) {
            criteria.andNameLike("%" + user.getName() + "%");
        }
        // 电话号码要求精准匹配
        if (user.getPhone() != null && !user.getPhone().equals("")) {
            criteria.andPhoneEqualTo(user.getPhone());
        }
        if (user.getClassname() != null && !user.getClassname().equals("")) {
            criteria.andClassnameLike("%" + user.getClassname() + "%");
        }

        List<User> list = userMapper.selectByExample(example);
        return list;
    }
}
