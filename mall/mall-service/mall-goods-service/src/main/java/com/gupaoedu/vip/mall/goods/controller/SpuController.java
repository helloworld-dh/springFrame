package com.gupaoedu.vip.mall.goods.controller;

import com.gupaoedu.mall.util.RespResult;
import com.gupaoedu.vip.mall.goods.model.Product;
import com.gupaoedu.vip.mall.goods.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: SpuController
 * @Description:
 * @Author: Du
 * @Date: 2022/5/16
 */
@RestController
@RequestMapping(value = "/spu")
@CrossOrigin
public class SpuController {
    @Autowired
    private SpuService spuService;

    /*****
     * 产品保存
     */
    @PostMapping(value = "/save")
    public RespResult save(@RequestBody Product product){
        spuService.saveProduct(product);
        return RespResult.ok();
    }

    /***
     * 根据ID查询product
     */
    @GetMapping(value = "/product/{id}")
    public RespResult<Product> one(@PathVariable(value = "id")String id){
        Product product = spuService.findBySpuId(id);
        return RespResult.ok(product);
    }
}
