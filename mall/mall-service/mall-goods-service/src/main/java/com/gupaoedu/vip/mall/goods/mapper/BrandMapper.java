package com.gupaoedu.vip.mall.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gupaoedu.vip.mall.goods.model.Brand;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @InterfaceName: BrandMapper
 * @Description:
 * @Author: Du
 * @Date: 2022/5/15
 */
public interface BrandMapper extends BaseMapper<Brand> {
    //根据分类ID查询品牌集合
    @Select("select brand_id from category_brand where category_id=#{id}")
    List<Integer> queryBrandIds(Integer id);
}
