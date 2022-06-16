package com.gupaoedu.vip.mall.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gupaoedu.vip.mall.order.model.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @InterfaceName: OrderMapper
 * @Description:
 * @Author: Du
 * @Date: 2022/5/21
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
