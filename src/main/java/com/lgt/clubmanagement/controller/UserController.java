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

import java.util.List;

@Api(tags = "用户操作")
@RestController
@RequestMapping(value = "user", produces = "application/json")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户登录", notes = "获取用户登录信息")
    @GetMapping("login")
    public JsonResult login(User user) {
        user.setNumber(user.getNumber());
        try {
            User userDB = userService.getUserByNumber(user.getNumber());
            return JsonResult.success(userDB, "登录成功");
        } catch (Exception e) {
            return JsonResult.error("", e.toString());
        }
    }

    @ApiOperation(value = "用户注册", notes = "普通用户注册")
    @PostMapping("registered")
    public JsonResult registered(User user) {
        //普通用户的类型
        user.setType(1);
        try {
            Integer value = userService.addUser(user);
            return JsonResult.success(value, "注册成功");
        } catch (Exception e) {
            return JsonResult.error("", e.toString());
        }
    }

    @ApiOperation(value = "查询所有用户信息（模糊查询）", notes = "查询所有用户信息（模糊查询）")
    @PostMapping("queryUserByAll")
    public JsonResult queryUserByAll(User user) {
        try {
            List<User> value = userService.queryUserByAll(user);
            return JsonResult.success(value, "查询成功");
        } catch (Exception e) {
            return JsonResult.error(e, "查询失败");
        }
    }
}
