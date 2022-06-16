package com.gupaoedu.vip.canal.listener;

import com.alibaba.fastjson.JSON;
import com.gupaoedu.vip.mall.page.feign.SeckillPageFeign;
import com.gupaoedu.vip.mall.search.feign.SeckillGoodsSearchFeign;
import com.gupaoedu.vip.mall.search.model.SeckillGoodsEs;
import com.gupaoedu.vip.mall.seckill.model.SeckillGoods;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.javatool.canal.client.annotation.CanalTable;
import top.javatool.canal.client.handler.EntryHandler;

/**
 * @ClassName: SeckillGoodsHandler
 * @Description:
 * @Author: Du
 * @Date: 2022/5/24
 */
@CanalTable(value = "seckill_goods")
@Component
public class SeckillGoodsHandler implements EntryHandler<SeckillGoods> {
    @Autowired
    private SeckillGoodsSearchFeign seckillGoodsSearchFeign;

    @Autowired
    private SeckillPageFeign seckillPageFeign;

    /***
     * 增加商品
     * @param seckillGoods
     */
    @SneakyThrows
    @Override
    public void insert(SeckillGoods seckillGoods) {
        //索引导入
        seckillGoodsSearchFeign.add(JSON.parseObject(JSON.toJSONString(seckillGoods), SeckillGoodsEs.class));

        //生成/更新静态页
        seckillPageFeign.page(seckillGoods.getId());
    }


    /****
     * 修改商品
     * @param before
     * @param after
     */
    @SneakyThrows
    @Override
    public void update(SeckillGoods before, SeckillGoods after) {

        System.out.println(before.toString());
        System.out.println(after.toString());
        //索引导入
        seckillGoodsSearchFeign.add(JSON.parseObject(JSON.toJSONString(after), SeckillGoodsEs.class));

        //生成/更新静态页
        seckillPageFeign.page(after.getId());
    }
}
