package com.lgt.clubmanagement.service;

import com.lgt.clubmanagement.entity.Userinfo;

import java.util.List;

public interface UserService {

    /**
     * 根据Id查用户信息
     * @param id
     * @return
     */
    Userinfo queryUserById(Integer id);


    /**
     * 根据用户学号查用户信息
     *
     * @param number
     * @return
     */
    Userinfo queryUserByNumber(String number);

    /**
     * 模糊查询
     * @param userinfo
     * @return
     */
    List<Userinfo> queryUserByExample(Userinfo userinfo);

    /**
     * 添加用户信息
     *
     * @param user
     * @return
     */
    int addUser(Userinfo user);

    /**
     * 查询所有用户信息
     *
     * @param user
     * @return
     */
    List<Userinfo> queryUserByAll(Userinfo user);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    int updateUser(Userinfo user);
}
