package com.lgt.clubmanagement.service.impl;

import com.lgt.clubmanagement.dao.UserinfoMapper;
import com.lgt.clubmanagement.entity.Userinfo;
import com.lgt.clubmanagement.entity.UserinfoExample;
import com.lgt.clubmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserinfoMapper userinfoMapper;

    @Override
    public Userinfo queryUserByNumber(String number) {
        UserinfoExample example = new UserinfoExample();
        UserinfoExample.Criteria criteria = example.createCriteria();

        criteria.andNumberEqualTo(number);
        System.out.println(example.toString());
        return userinfoMapper.selectByExample(example).get(0);
    }

    @Override
    public int addUser(Userinfo user) {
        return userinfoMapper.insert(user);
    }

    @Override
    public List<Userinfo> queryUserByAll(Userinfo user) {
        UserinfoExample example = new UserinfoExample();
        UserinfoExample.Criteria criteria = example.createCriteria();

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

        List<Userinfo> list = userinfoMapper.selectByExample(example);
        return list;
    }

    @Override
    public int updateUser(Userinfo user) {
        return userinfoMapper.updateByPrimaryKey(user);
    }
}
