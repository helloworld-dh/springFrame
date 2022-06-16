package com.gupaoedu.vip.mall.order.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.annotation.SqlParser;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gupaoedu.mall.util.RespResult;
import com.gupaoedu.vip.mall.cart.feign.CartFeign;
import com.gupaoedu.vip.mall.cart.model.Cart;
import com.gupaoedu.vip.mall.goods.feign.SkuFeign;
import com.gupaoedu.vip.mall.order.mapper.OrderMapper;
import com.gupaoedu.vip.mall.order.mapper.OrderRefundMapper;
import com.gupaoedu.vip.mall.order.mapper.OrderSkuMapper;
import com.gupaoedu.vip.mall.order.model.Order;
import com.gupaoedu.vip.mall.order.model.OrderRefund;
import com.gupaoedu.vip.mall.order.model.OrderSku;
import com.gupaoedu.vip.mall.order.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.keyvalue.core.IterableConverter;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: OrderServiceImpl
 * @Description:
 * @Author: Du
 * @Date: 2022/5/21
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderSkuMapper orderSkuMapper;

    @Autowired
    private CartFeign cartFeign;

    @Autowired
    private SkuFeign skuFeign;

    @Autowired
    private OrderRefundMapper orderRefundMapper;


    /***
     * 添加订单
     * 作业：
     *      1)价格如何校验？
     */
    @GlobalTransactional
    @Override
    public Boolean add(Order order) {
        //用户名字
        String userName = "gp";
        order.setUsername(userName);
        order.setCreateTime(new Date());
        order.setUpdateTime(order.getCreateTime());
        order.setId(IdWorker.getIdStr());
        order.setOrderStatus(0);
        order.setPayStatus(0);
        order.setIsDelete(0);

        //1.查询购物车记录
        RespResult<List<Cart>> cartResp = cartFeign.list(order.getCartIds());
        List<Cart> carts = IterableConverter.toList(cartResp.getData());
        if(carts.size()==0){
            return false;
        }
        //2.库存递减   20000  成功
        skuFeign.dcount(carts);

        //3.增加订单明细
        int totlNum = 0;    //商品个数
        int payMoney = 0;   //支付总金额
        for (Cart cart : carts) {
            //类型转换
            OrderSku orderSku = JSON.parseObject(JSON.toJSONString(cart), OrderSku.class);
            orderSku.setId(IdWorker.getIdStr());
            orderSku.setMoney(orderSku.getPrice()*orderSku.getNum());
            orderSku.setSkuId(cart.getSkuId());
            orderSku.setOrderId(order.getId());
            orderSkuMapper.insert(orderSku);

            //统计数据
            totlNum+=cart.getNum();
            payMoney+=orderSku.getMoney();
        }
        //4.增加订单
        order.setTotalNum(totlNum);
        order.setMoneys(payMoney);
        orderMapper.insert(order);

//        int q =10/0;

        //5.删除购物车记录
        cartFeign.delete(order.getCartIds());
        return true;
    }

    @Override
    public int refund(OrderRefund orderRefund) {
        //1记录退款申请
        orderRefundMapper.insert(orderRefund);

        //2修改订单状态
        Order order = new Order();
        order.setOrderStatus(4);    //申请退款

        //构建条件
        QueryWrapper<Order> queryWrapper = new QueryWrapper<Order>();
        queryWrapper.eq("id",orderRefund.getOrderNo()); //订单ID
        queryWrapper.eq("username",orderRefund.getUsername()); //用户名
        queryWrapper.eq("order_status",1);
        queryWrapper.eq("pay_status",1);
        int count = orderMapper.update(order, queryWrapper);
        return count;
    }


    /****
     * 支付成功后状态修改
     * @param id
     * @return
     */
    @Override
    public int updateAfterPayStatus(String id) {
        //修改后的状态
        Order order = new Order();
        order.setId(id);
        order.setOrderStatus(1);    // 待发货
        order.setPayStatus(1);  //已支付

        //修改条件
        QueryWrapper<Order> queryWrapper = new QueryWrapper<Order>();
        queryWrapper.eq("id",id);
        queryWrapper.eq("order_status",0);
        queryWrapper.eq("pay_status",0);
        return orderMapper.update(order,queryWrapper);
    }


}
