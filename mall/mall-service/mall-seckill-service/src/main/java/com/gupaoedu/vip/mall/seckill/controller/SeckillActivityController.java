package com.gupaoedu.vip.mall.seckill.controller;

import com.gupaoedu.mall.util.RespResult;
import com.gupaoedu.vip.mall.seckill.model.SeckillActivity;
import com.gupaoedu.vip.mall.seckill.service.SeckillActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: SeckillActivityController
 * @Description:
 * @Author: Du
 * @Date: 2022/5/24
 */
@RestController
@RequestMapping(value = "/activity")
public class SeckillActivityController {
    @Autowired
    private SeckillActivityService seckillActivityService;

    /****
     * 有效活动列表
     * http://localhost:8092/activity
     */
    @GetMapping
    public RespResult list(){
        //查询活动列表
        List<SeckillActivity> seckillActivities = seckillActivityService.validActivity();
        return RespResult.ok(seckillActivities);
    }

}
