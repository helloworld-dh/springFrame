package com.gupaoedu.vip.mall.goods.feign;

import com.gupaoedu.mall.util.RespResult;
import com.gupaoedu.vip.mall.goods.model.Category;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @InterfaceName: CategoryFeign
 * @Description:
 * @Author: Du
 * @Date: 2022/5/20
 */
@FeignClient(value = "mall-goods")
public interface CategoryFeign {
    /****
     * 根据ID查询
     */
    @GetMapping(value = "/category/{id}")
    RespResult<Category> one(@PathVariable(value = "id")Integer id);
}
