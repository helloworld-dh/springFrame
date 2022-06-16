package com.gupaoedu.vip.mall.goods.feign;

import com.gupaoedu.mall.util.RespResult;
import com.gupaoedu.vip.mall.cart.model.Cart;
import com.gupaoedu.vip.mall.goods.model.Sku;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @InterfaceName: SkuFeign
 * @Description:
 * @Author: Du
 * @Date: 2022/5/16
 */
@FeignClient(value = "mall-goods")
public interface SkuFeign {

    /****
     * 指定分类下的推广产品列表
     */
//    @GetMapping(value = "/sku/aditems/type")
//    List<Sku> typeItems(@RequestParam(value = "id") Integer id);
    @GetMapping(value = "/sku/aditems/type/{id}")
    List<Sku> typeItems(@PathVariable(value = "id")Integer id);
    /****
     * 删除指定分类下的推广产品列表
     */
//    @DeleteMapping(value = "/sku/aditems/type/{id}")
//    RespResult deleteTypeItems(@PathVariable(value = "id")Integer id);
    @DeleteMapping(value = "/sku/aditems/type")
    RespResult deleteTypeItems(@RequestParam(value = "id") Integer id);
    /****
     * 修改指定分类下的推广产品列表
     */
//    @PutMapping(value = "/sku/aditems/type/{id}")
//    RespResult updateTypeItems(@PathVariable(value = "id")Integer id);
    @PutMapping(value = "/sku/aditems/type")
    RespResult updateTypeItems(@RequestParam(value = "id") Integer id);

    /****
     * 根据ID获取Sku
     */
    @GetMapping(value = "/sku/{id}")
    RespResult<Sku> one(@PathVariable(value = "id") String id);

    /***
     * 库存递减
     */
    @PostMapping(value = "/sku/dcount")
    RespResult dcount(@RequestBody List<Cart> carts);
}
