package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import com.itheima.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:deconglin
 * @date:2023-08-08-14:48
 * @description:
 */
@Slf4j
@RestController
public class LoginController {
    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("员工登录:{}",emp);
        Emp e = empService.login(emp);
        //登录成功 下发令牌
        if(e !=null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id",e.getId());
            claims.put("username",e.getUsername());
            claims.put("name",e.getName());

            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        //登录失败 返回错误信息
        return Result.error("用户名或密码错误");
    }
}
