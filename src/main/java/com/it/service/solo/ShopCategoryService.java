package com.it.service.solo;

import com.it.entity.bo.ShopCategory;
import com.it.entity.dto.Result;

import java.util.List;

/**
 * @ClassName: ShopCategoryService
 * @Description:
 * @Author: Du
 * @Date: 2022/6/17
 */
public interface ShopCategoryService {

    Result<Boolean> addShopCateGory(ShopCategory shopCategory);

    Result<Boolean> removeShopCategory(int shopCategoryId);

    Result<Boolean> modifyShopCategory(ShopCategory shopCategory);

    Result<ShopCategory> queryShopCategoryById(int shopCategoryId);

    Result<List<ShopCategory>> queryShopCategory(ShopCategory shopCategoryCondition, int pageIndex, int pageSize);
}
