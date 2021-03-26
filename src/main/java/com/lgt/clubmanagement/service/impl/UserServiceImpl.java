package com.lgt.clubmanagement.service.impl;

import com.lgt.clubmanagement.dao.UserMapper;
import com.lgt.clubmanagement.entity.User;
import com.lgt.clubmanagement.entity.UserExample;
import com.lgt.clubmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return 0;
    }
}
