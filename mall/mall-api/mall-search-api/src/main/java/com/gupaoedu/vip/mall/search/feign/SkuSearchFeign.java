package com.gupaoedu.vip.mall.search.feign;

import com.gupaoedu.mall.util.RespResult;
import com.gupaoedu.vip.mall.search.model.SkuEs;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName: SkuSearchFeign
 * @Description:
 * @Author: Du
 * @Date: 2022/5/17
 */
@FeignClient(value = "mall-search")
public interface SkuSearchFeign {
    /****
     * 单个导入
     * @param skuEs
     * @return
     */
    @PostMapping(value = "/search/add")
    RespResult add(@RequestBody SkuEs skuEs);


    /***
     * 根据ID删除
     * @param id
     * @return
     */
    @DeleteMapping(value = "/search/del/{id}")
    RespResult del(@PathVariable("id")String id);


    /****
     * 商品搜索
     */
    @GetMapping("/search")
    RespResult<Map<String,Object>> search(@RequestParam Map<String,Object> searchMap);
}
