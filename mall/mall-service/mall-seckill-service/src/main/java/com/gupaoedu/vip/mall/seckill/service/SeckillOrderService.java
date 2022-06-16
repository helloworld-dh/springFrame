package com.gupaoedu.vip.mall.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gupaoedu.vip.mall.seckill.model.SeckillOrder;

import java.util.Map;

/**
 * @InterfaceName: SeckillOrderService
 * @Description:
 * @Author: Du
 * @Date: 2022/5/24
 */
public interface SeckillOrderService extends IService<SeckillOrder> {

    /***
     * 抢单操作
     */
    int add(Map<String,Object> dataMap);
}
