package com.gupaoedu.vip.mall.cart.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * @ClassName: Cart
 * @Description:
 * @Author: Du
 * @Date: 2022/5/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart implements Serializable {

    @Id
    private String _id;  //主键
    private String userName;  //用户名字
    private String name;  //当前商品名字
    private Integer price; //商品单价
    private String image;  //商品图片
    private String skuId;  //商品id
    private Integer num;   //商品数量
}
