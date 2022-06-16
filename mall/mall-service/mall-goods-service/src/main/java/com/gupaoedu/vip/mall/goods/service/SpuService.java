package com.gupaoedu.vip.mall.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gupaoedu.vip.mall.goods.model.Product;
import com.gupaoedu.vip.mall.goods.model.Spu;

/**
 * @InterfaceName: SpuService
 * @Description:
 * @Author: Du
 * @Date: 2022/5/15
 */
public interface SpuService extends IService<Spu> {
    /****
     * 产品保存
     */
    void saveProduct(Product product);

    Product findBySpuId(String id);
}
