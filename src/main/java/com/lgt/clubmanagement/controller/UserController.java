package com.lgt.clubmanagement.controller;

import com.lgt.clubmanagement.entity.User;
import com.lgt.clubmanagement.service.UserService;
import com.lgt.clubmanagement.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户操作")
@RestController
@RequestMapping(value = "user", produces = "application/json")
public class UserController {
    @Autowired
    private UserService userService;
    JsonResult jr = new JsonResult();

    @ApiOperation(value = "用户登录", notes = "获取用户登录信息")
    @GetMapping("login")
    public JsonResult login(User user) {
        user.setNumber(user.getNumber());
        try {
            User userDB = userService.getUserByNumber(user.getNumber());
            jr.setCode(200);
            jr.setObj(userDB);
        } catch (Exception e) {
            jr.setCode(500);
            jr.setMsg("不存在此用户");
        }
        return jr;
    }

    @ApiOperation(value = "用户注册", notes = "普通用户注册")
    @PostMapping("registered")
    public JsonResult registered(User user) {
        user.setType(1);
        try {
            jr.setCode(200);
            jr.setMsg("不存在此用户");
        } catch (Exception e) {
            jr.setCode(500);
            jr.setMsg("不存在此用户");
        }
        return jr;
    }
}
