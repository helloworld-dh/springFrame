package com.gupaoedu.vip.mall.search.service;

import com.gupaoedu.vip.mall.search.model.SkuEs;

import java.util.Map;

/**
 * @InterfaceName: SkuSearchService
 * @Description:
 * @Author: Du
 * @Date: 2022/5/17
 */
public interface SkuSearchService {
    //添加索引
    void add(SkuEs skuEs);
    //删除索引
    void del(String id);

    /***
     * 商品搜索
     * @param searchMap
     * @return
     */
    Map<String,Object> search(Map<String, Object> searchMap);
}
