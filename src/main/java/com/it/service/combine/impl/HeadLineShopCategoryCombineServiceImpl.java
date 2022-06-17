package com.it.service.combine.impl;

import com.it.entity.bo.HeadLine;
import com.it.entity.bo.ShopCategory;
import com.it.entity.dto.MainPageInfoDTO;
import com.it.entity.dto.Result;
import com.it.service.combine.HeadLineShopCategoryCombineService;
import com.it.service.solo.HeadLineService;
import com.it.service.solo.ShopCategoryService;

import java.util.List;

/**
 * @ClassName: HeadLineShopCategoryCombineServiceImpl
 * @Description:
 * @Author: Du
 * @Date: 2022/6/17
 */
public class HeadLineShopCategoryCombineServiceImpl implements HeadLineShopCategoryCombineService {

    private HeadLineService headLineService;

    private ShopCategoryService shopCategoryService;
    @Override
    public Result<MainPageInfoDTO> getMainPageInfo() {
        //获取头条列表
        HeadLine headLineCondition = new HeadLine();
        headLineCondition.setEnableStatus(1);
        Result<List<HeadLine>> headLineResult = headLineService.queryHeadLine(headLineCondition, 1, 4);
        //获取店铺类别列表
        ShopCategory shopCategoryCondition = new ShopCategory();
        Result<List<ShopCategory>> shopCategoryResult = shopCategoryService.queryShopCategory(shopCategoryCondition, 1, 100);
        //合并两者并返回
        Result<MainPageInfoDTO> result = mergeMainPageInfoResult(headLineResult, shopCategoryResult);
        return result;
    }

    private Result<MainPageInfoDTO> mergeMainPageInfoResult(Result<List<HeadLine>> headLineResult,
                                                            Result<List<ShopCategory>> shopCategoryResult){
        return null;
    }
}
