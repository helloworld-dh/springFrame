package com.gupaoedu.vip.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gupaoedu.vip.mall.order.model.Order;
import com.gupaoedu.vip.mall.order.model.OrderRefund;

/**
 * @InterfaceName: OrderService
 * @Description:
 * @Author: Du
 * @Date: 2022/5/21
 */
public interface OrderService extends IService<Order> {
    /***
     * 添加订单
     */
    Boolean add(Order order);

    /***
     * 退款
     */
    int refund(OrderRefund orderRefund);

    /***
     * 支付成功修改状态
     */
    int updateAfterPayStatus(String id);
}
