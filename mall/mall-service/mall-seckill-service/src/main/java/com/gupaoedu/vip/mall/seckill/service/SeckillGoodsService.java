package com.gupaoedu.vip.mall.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gupaoedu.vip.mall.seckill.model.SeckillGoods;

import java.util.List;

/**
 * @InterfaceName: SeckillGoodsService
 * @Description:
 * @Author: Du
 * @Date: 2022/5/24
 */
public interface SeckillGoodsService extends IService<SeckillGoods> {
    //根据活动ID查询商品信息
    List<SeckillGoods> actGoods(String acid);

    //热门商品分离  uri:商品ID
    void isolation(String uri);
}
