package com.gupaoedu.vip.mall.goods.controller;

import com.gupaoedu.mall.util.RespResult;
import com.gupaoedu.vip.mall.cart.model.Cart;
import com.gupaoedu.vip.mall.goods.model.Sku;
import com.gupaoedu.vip.mall.goods.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: SkuController
 * @Description:
 * @Author: Du
 * @Date: 2022/5/16
 */
@RestController
@RequestMapping(value = "/sku")
@CrossOrigin
public class SkuController {
    @Autowired
    private SkuService skuService;

    /****
     * 指定分类下的推广产品列表
     */
    @GetMapping(value = "/aditems/type/{id}")
    public List<Sku> typeItems(@PathVariable(value = "id")Integer id){
        //查询
        List<Sku> adSkuItems = skuService.typeSkuItems(id);
        return adSkuItems;
    }

    /****
     * 删除指定分类下的推广产品列表
     */
    @DeleteMapping(value = "/aditems/type")
    public RespResult deleteTypeItems(@RequestParam(value = "id") Integer id){
        //清理缓存
        skuService.delTypeSkuItems(id);
        return RespResult.ok();
    }

    @PutMapping(value = "/aditems/type")
    public RespResult updateTypeItems(@RequestParam(value = "id") Integer id){
        //修改
        System.out.println("update");
        skuService.updateSkuItems(id);
        return RespResult.ok();
    }

    /****
     * 根据ID获取Sku(商品详情)
     */
    @GetMapping(value = "/{id}")
    public RespResult<Sku> one(@PathVariable(value = "id") String id){
        Sku sku = skuService.getById(id);
        return RespResult.ok(sku);
    }

    /***
     * 库存递减
     */
    @PostMapping(value = "/dcount")
    public RespResult dcount(@RequestBody List<Cart> carts){
        skuService.dcount(carts);
        return RespResult.ok();
    }
}
