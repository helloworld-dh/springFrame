package com.gupaoedu.vip.mall.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gupaoedu.vip.mall.goods.model.Sku;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @InterfaceName: SkuMapper
 * @Description:
 * @Author: Du
 * @Date: 2022/5/15
 */
public interface SkuMapper extends BaseMapper<Sku> {
    /***
     * 库存递减
     */
    @Update("update sku set num=num-#{num} where id=#{id} and num>=#{num}")
    int dcount(@Param("id")String id, @Param("num")Integer num);
}
