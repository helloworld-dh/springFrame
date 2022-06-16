package com.gupaoedu.vip.canal.listener;

import com.alibaba.fastjson.JSON;
import com.gupaoedu.vip.mall.goods.model.Sku;
import com.gupaoedu.vip.mall.page.feign.PageFeign;
import com.gupaoedu.vip.mall.search.feign.SkuSearchFeign;
import com.gupaoedu.vip.mall.search.model.SkuEs;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.javatool.canal.client.annotation.CanalTable;
import top.javatool.canal.client.handler.EntryHandler;

/**
 * @ClassName: SkuHandler
 * @Description:
 * @Author: Du
 * @Date: 2022/5/17
 */
@CanalTable(value = "sku")
@Component
public class SkuHandler implements EntryHandler<Sku> {

    @Autowired
    private SkuSearchFeign skuSearchFeign;

    @Autowired
    private PageFeign pageFeign;

    /***
     * 增加产品
     * @param sku
     */
    @Override
    public void insert(Sku sku) {
        if(sku.getStatus().intValue()==1){
            //导入索引
            skuSearchFeign.add(JSON.parseObject(JSON.toJSONString(sku), SkuEs.class));
        }
        //生成静态页
        try {
            pageFeign.html(sku.getSpuId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /***
     * 修改
     * @param before
     * @param after
     */
    @SneakyThrows
    @Override
    public void update(Sku before, Sku after) {
        System.out.println("update");
        if(after.getStatus().intValue()==2){
            //导入索引
            skuSearchFeign.del(after.getId());
        }else{
            skuSearchFeign.add(JSON.parseObject(JSON.toJSONString(after), SkuEs.class));
        }
        //生成静态页
        System.out.println(after.getSpuId().getClass());
        pageFeign.html(after.getSpuId());
    }

    /***
     *
     * @param sku
     */
    @Override
    public void delete(Sku sku) {
        skuSearchFeign.del(sku.getId());
    }
}
