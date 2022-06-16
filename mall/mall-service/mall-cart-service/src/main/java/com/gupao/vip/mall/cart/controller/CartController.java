package com.gupao.vip.mall.cart.controller;

import com.gupao.vip.mall.cart.service.CartService;
import com.gupaoedu.mall.util.RespResult;
import com.gupaoedu.vip.mall.cart.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: CartController
 * @Description:
 * @Author: Du
 * @Date: 2022/5/21
 */
@RestController
@RequestMapping(value = "/cart")
@CrossOrigin
public class CartController {

    @Autowired
    private CartService cartService;

    /****
     * 增加购物车方法
     */
    @GetMapping(value = "/{id}/{num}")
    public RespResult add(@PathVariable(value = "id")String id,
                          @PathVariable(value = "num")Integer num){
        String userName = "gp";
        cartService.add(id,userName,num);
        return RespResult.ok();
    }

    /****
     * 购物车列表
     */
    @GetMapping(value = "/list")
    public RespResult<List<Cart>> list(){
        String userName = "gp";
        List<Cart> list = cartService.list(userName);
        return RespResult.ok(list);
    }

    /***
     * 指定ID集合的购物车数据
     * http://localhost:8087/cart/list
     */
    @PostMapping(value = "/list")
    public RespResult<List<Cart>> list(@RequestBody List<String> ids){
        List<Cart> carts = cartService.list(ids);
        return RespResult.ok(carts);
    }

    /***
     * 删除购物车数据
     */
    @DeleteMapping
    public RespResult delete(@RequestBody List<String> ids){
        cartService.delete(ids);
        return RespResult.ok();
    }
}
