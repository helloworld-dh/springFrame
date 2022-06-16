package com.gupaoedu.vip.mall.search.service;

import com.gupaoedu.vip.mall.search.model.SeckillGoodsEs;

/**
 * @InterfaceName: SeckillGoodsSearchService
 * @Description:
 * @Author: Du
 * @Date: 2022/5/24
 */
public interface SeckillGoodsSearchService {
    //导入到索引库
    void add(SeckillGoodsEs seckillGoodsEs);
}
