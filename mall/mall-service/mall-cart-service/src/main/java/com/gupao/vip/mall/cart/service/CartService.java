package com.gupao.vip.mall.cart.service;

import com.gupaoedu.vip.mall.cart.model.Cart;

import java.util.List;

/**
 * @InterfaceName: CartService
 * @Description:
 * @Author: Du
 * @Date: 2022/5/21
 */
public interface CartService {
    /**
     * 加入购物车
     * @param id :skuid
     * @param userName:用户名
     * @param num ： 加入购物车数量
     */
    void add(String id,String userName,Integer num);

    /***
     * 购物车列表
     */
    List<Cart> list(String userName);

    /***
     * 查询指定购物车ID集合的列表
     */
    List<Cart> list(List<String> ids);

    /***
     * 根据集合ID删除指定的购物车列表
     */
    void delete(List<String> ids);

}
