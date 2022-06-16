package com.gupaoedu.vip.mall.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gupaoedu.vip.mall.goods.model.Category;

import java.util.List;

/**
 * @InterfaceName: CategoryService
 * @Description:
 * @Author: Du
 * @Date: 2022/5/15
 */
public interface CategoryService extends IService<Category> {
    /**
     * 根据父ID查询子分类
     * @param pid
     * @return
     */
    List<Category> queryByParentId(Integer pid);
}
