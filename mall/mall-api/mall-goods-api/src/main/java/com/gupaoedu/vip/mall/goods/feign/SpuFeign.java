package com.gupaoedu.vip.mall.goods.feign;

import com.gupaoedu.mall.util.RespResult;
import com.gupaoedu.vip.mall.goods.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @InterfaceName: SpuFeign
 * @Description:
 * @Author: Du
 * @Date: 2022/5/20
 */
@FeignClient(value = "mall-goods")
public interface SpuFeign {

    /***
     * 根据ID查询product
     */
    @GetMapping(value = "/spu/product/{id}")
    RespResult<Product> one(@PathVariable(value = "id")String id);
}
