package com.lgt.clubmanagement.service;

import com.lgt.clubmanagement.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 根据用户学号查用户信息
     *
     * @param number
     * @return
     */
    public User getUserByNumber(String number);

    /**
     * 添加用户信息
     *
     * @param user
     * @return
     */
    public int addUser(User user);

    /**
     * 查询所有用户信息
     *
     * @param user
     * @return
     */
    public List<User> queryUserByAll(User user);
}
