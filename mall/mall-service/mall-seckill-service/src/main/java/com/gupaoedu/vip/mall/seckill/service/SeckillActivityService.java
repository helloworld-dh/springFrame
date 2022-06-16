package com.gupaoedu.vip.mall.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gupaoedu.vip.mall.seckill.model.SeckillActivity;

import java.util.List;

/**
 * @InterfaceName: SeckillActivityService
 * @Description:
 * @Author: Du
 * @Date: 2022/5/24
 */
public interface SeckillActivityService extends IService<SeckillActivity> {
    /***
     * 有效活动列表
     * @return
     */
    List<SeckillActivity> validActivity();
}
