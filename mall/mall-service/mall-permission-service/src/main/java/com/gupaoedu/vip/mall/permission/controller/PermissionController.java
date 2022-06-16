package com.gupaoedu.vip.mall.permission.controller;

import com.gupaoedu.vip.mall.cart.model.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: PermissionController
 * @Description:
 * @Author: Du
 * @Date: 2022/5/28
 */
@RestController
@RequestMapping(value = "/permission")
public class PermissionController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping
    public void redisTest(){
        List<Permission> permissionMatch0 = (List<Permission>) redisTemplate.boundHashOps("RolePermissionAll").get("PermissionListMatch0");
        for (Permission permission : permissionMatch0) {
            System.out.println("=========================");
            System.out.println(permission);
        }
    }

}
