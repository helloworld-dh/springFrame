package com.gupaoedu.vip.mall.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gupaoedu.vip.mall.cart.model.Cart;
import com.gupaoedu.vip.mall.goods.model.Sku;

import java.util.List;

/**
 * @InterfaceName: SkuService
 * @Description:
 * @Author: Du
 * @Date: 2022/5/16
 */
public interface SkuService extends IService<Sku> {
    /***
     * 根据推广产品分类ID查询Sku列表
     * @param id
     * @return
     */
    List<Sku> typeSkuItems(Integer id);

    void delTypeSkuItems(Integer id);

    List<Sku> updateSkuItems(Integer id);

    void dcount(List<Cart> carts);
}
