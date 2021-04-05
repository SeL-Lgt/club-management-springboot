package com.lgt.clubmanagement.controller;

import com.lgt.clubmanagement.entity.Userinfo;
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
    @PostMapping("login")
    public JsonResult login(Userinfo user) {
        try {
            Userinfo userDB = userService.queryUserByNumber(user.getNumber());
            if (!userDB.getPassword().equals(user.getPassword())) {
                return JsonResult.error("", "密码不正确");
            }
            return JsonResult.success(userDB, "登录成功");
        } catch (Exception e) {
            return JsonResult.error("", e.toString());
        }
    }

    @ApiOperation(value = "查询用户信息(根据学号)", notes = "获取用户信息")
    @PostMapping("queryUserByNumber")
    public JsonResult queryUserByNumber(String number) {
        try {
            Userinfo userDB = userService.queryUserByNumber(number);
            return JsonResult.success(userDB, "查询成功");
        } catch (Exception e) {
            return JsonResult.error("", e.toString());
        }
    }

    @ApiOperation(value = "用户注册", notes = "普通用户注册")
    @PostMapping("registered")
    public JsonResult registered(Userinfo user) {
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
    public JsonResult queryUserByAll(Userinfo user) {
        try {
            List<Userinfo> value = userService.queryUserByAll(user);
            return JsonResult.success(value, "查询成功");
        } catch (Exception e) {
            return JsonResult.error(e, "查询失败");
        }
    }

    @ApiOperation(value = "修改用户信息", notes = "修改所有用户信息")
    @PostMapping("updateUser")
    public JsonResult updateUser(Userinfo user) {
        try {
            Integer value = userService.updateUser(user);
            return JsonResult.success(value, "修改成功");
        } catch (Exception e) {
            return JsonResult.error("", "修改失败");
        }
    }
}
