package com.it.service.solo.impl;

import com.it.entity.bo.ShopCategory;
import com.it.entity.dto.Result;
import com.it.service.solo.ShopCategoryService;

import java.util.List;

/**
 * @ClassName: ShopCategoryServiceImpl
 * @Description:
 * @Author: Du
 * @Date: 2022/6/17
 */
public class ShopCategoryServiceImpl implements ShopCategoryService {
    @Override
    public Result<Boolean> addShopCateGory(ShopCategory shopCategory) {
        return null;
    }

    @Override
    public Result<Boolean> removeShopCategory(int shopCategoryId) {
        return null;
    }

    @Override
    public Result<Boolean> modifyShopCategory(ShopCategory shopCategory) {
        return null;
    }

    @Override
    public Result<ShopCategory> queryShopCategoryById(int shopCategoryId) {
        return null;
    }

    @Override
    public Result<List<ShopCategory>> queryShopCategory(ShopCategory shopCategoryCondition, int pageIndex, int pageSize) {
        return null;
    }
}
