package com.gupaoedu.vip.canal.listener;

import com.gupaoedu.vip.mall.goods.feign.SkuFeign;
import com.gupaoedu.vip.mall.goods.model.AdItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.javatool.canal.client.annotation.CanalTable;
import top.javatool.canal.client.handler.EntryHandler;

/**
 * @ClassName: AdItemsHandler
 * @Description:
 * @Author: Du
 * @Date: 2022/5/16
 */
@CanalTable(value = "ad_items")
@Component
public class AdItemsHandler implements EntryHandler<AdItems> {
    @Autowired
    private SkuFeign skuFeign;

    @Override
    public void insert(AdItems adItems) {
        System.out.println("insert");
        //加载缓存
        skuFeign.updateTypeItems(adItems.getType());
    }

    /***
     * 修改
     * @param before
     * @param after
     */
    @Override
    public void update(AdItems before, AdItems after) {
        System.out.println("update");
        //分类不同，则重新加载之前的缓存
        if(before.getType().intValue()!=after.getType().intValue()){
            //修改缓存
            skuFeign.updateTypeItems(before.getType());
        }
        //加载缓存
        skuFeign.updateTypeItems(after.getType());
    }

    @Override
    public void delete(AdItems adItems) {
        System.out.println("delete");
        //删除缓存
        skuFeign.deleteTypeItems(adItems.getType());
    }

}
