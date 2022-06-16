package com.gupaoedu.vip.mall.search.feign;

import com.gupaoedu.mall.util.RespResult;
import com.gupaoedu.vip.mall.search.model.SeckillGoodsEs;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @InterfaceName: SeckillGoodsSearchFeign
 * @Description:
 * @Author: Du
 * @Date: 2022/5/24
 */
@FeignClient(value = "mall-search")
public interface SeckillGoodsSearchFeign {


    /***
     * 将秒杀商品导入索引库
     */
    @PostMapping("/seckill/goods/import")
    RespResult add(@RequestBody SeckillGoodsEs seckillGoodsEs);
}
