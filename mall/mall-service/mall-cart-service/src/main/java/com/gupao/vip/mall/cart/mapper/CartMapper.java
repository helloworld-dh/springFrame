package com.gupao.vip.mall.cart.mapper;

import com.gupaoedu.vip.mall.cart.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @InterfaceName: CartMapper
 * @Description:
 * @Author: Du
 * @Date: 2022/5/21
 */
public interface CartMapper extends MongoRepository<Cart,String> {
}
