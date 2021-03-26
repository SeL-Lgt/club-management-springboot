package com.lgt.clubmanagement.service;

import com.lgt.clubmanagement.entity.User;

public interface UserService {
    /**
     * 根据用户学号查用户信息
     *
     * @param number
     * @return
     */
    public User getUserByNumber(String number);

    public int addUser(User user);
}
