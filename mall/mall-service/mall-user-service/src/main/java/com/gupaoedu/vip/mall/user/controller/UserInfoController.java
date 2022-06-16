package com.gupaoedu.vip.mall.user.controller;

import com.gupaoedu.mall.util.JwtToken;
import com.gupaoedu.mall.util.MD5;
import com.gupaoedu.mall.util.RespResult;
import com.gupaoedu.vip.mall.user.model.UserInfo;
import com.gupaoedu.vip.mall.user.service.UserInfoService;
import com.gupaoedu.vip.mall.util.IPUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: UserInfoController
 * @Description:
 * @Author: Du
 * @Date: 2022/5/27
 */
@RestController
@RequestMapping(value = "/user/info")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    /****
     * 登录
     */
    @PostMapping(value = "/login")
    public RespResult<String> login(@RequestParam String username,
                                    @RequestParam String pwd,
                                    HttpServletRequest request) throws Exception{
        //登录
        UserInfo userInfo = userInfoService.getById(username);
        if(userInfo!=null && pwd.equals(userInfo.getPassword())){
            //匹配密码是否一致
            if(userInfo.getPassword().equals(pwd)){
                //封装用户信息实现加密
                Map<String,Object> dataMap = new HashMap<String,Object>();
                dataMap.put("username",userInfo.getUsername());
                dataMap.put("name",userInfo.getName());
                dataMap.put("roles",userInfo.getRoles());

                //获取ip
                String ip = IPUtils.getIpAddr(request);
                dataMap.put("ip", MD5.md5(ip));

                //创建令牌
                String token = JwtToken.createToken(dataMap);
                return RespResult.ok(token);
            }
            //账号密码不匹配
            return RespResult.error("账号或者密码错误");
        }
        return RespResult.error("账号不存在");
    }
}
