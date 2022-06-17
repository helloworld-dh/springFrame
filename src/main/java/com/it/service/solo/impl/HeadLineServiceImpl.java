package com.it.service.solo.impl;

import com.it.entity.bo.HeadLine;
import com.it.entity.dto.Result;
import com.it.service.solo.HeadLineService;

import java.util.List;

/**
 * @ClassName: HeadLineServiceImpl
 * @Description:
 * @Author: Du
 * @Date: 2022/6/17
 */
public class HeadLineServiceImpl implements HeadLineService {

    @Override
    public Result<Boolean> addHeadLine(HeadLine headLine) {
        return null;
    }

    @Override
    public Result<Boolean> removeHeadLine(int headLineId) {
        return null;
    }

    @Override
    public Result<Boolean> modifyHeadLine(HeadLine headLine) {
        return null;
    }

    @Override
    public Result<HeadLine> queryHeadLineById(int headLineId) {
        return null;
    }

    @Override
    public Result<List<HeadLine>> queryHeadLine(HeadLine headLineCondition, int pageIndex, int pageSize) {
        return null;
    }
}
