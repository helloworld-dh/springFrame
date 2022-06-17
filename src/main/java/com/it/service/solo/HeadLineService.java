package com.it.service.solo;

import com.it.entity.bo.HeadLine;
import com.it.entity.dto.Result;

import java.util.List;

/**
 * @ClassName: HeadLineService
 * @Description:
 * @Author: Du
 * @Date: 2022/6/17
 */
public interface HeadLineService {

    //添加头条
    Result<Boolean> addHeadLine(HeadLine headLine);

    //删除头条
    Result<Boolean> removeHeadLine(int headLineId);

    //修改
    Result<Boolean> modifyHeadLine(HeadLine headLine);

    //获取某个泛型具体的信息
    Result<HeadLine> queryHeadLineById(int headLineId);

    //获取头条列表
    Result<List<HeadLine>> queryHeadLine(HeadLine headLineCondition, int pageIndex, int pageSize);
}
