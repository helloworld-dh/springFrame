package com.it.controller.superadmin;

import com.it.entity.bo.HeadLine;
import com.it.entity.dto.Result;
import com.it.service.solo.HeadLineService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName: HeadLineOperationController
 * @Description:
 * @Author: Du
 * @Date: 2022/6/17
 */
public class HeadLineOperationController {
    private HeadLineService headLineService;

    //添加头条
    public Result<Boolean> addHeadLine(HttpServletRequest req, HttpServletResponse resp){
        //TODO:参数校验以及请求参数转化

        return headLineService.addHeadLine(new HeadLine());
    }

    //删除头条
    public Result<Boolean> removeHeadLine(HttpServletRequest req, HttpServletResponse resp){
        //TODO:参数校验以及请求参数转化
        return headLineService.removeHeadLine(1);
    }

    //修改
    public Result<Boolean> modifyHeadLine(HttpServletRequest req, HttpServletResponse resp){
        //TODO:参数校验以及请求参数转化
        return headLineService.modifyHeadLine(new HeadLine());
    }

    //获取某个泛型具体的信息
    public Result<HeadLine> queryHeadLineById(HttpServletRequest req, HttpServletResponse resp){
        //TODO:参数校验以及请求参数转化
        return headLineService.queryHeadLineById(1);
    }

    //获取头条列表
    public Result<List<HeadLine>> queryHeadLine(HttpServletRequest req, HttpServletResponse resp){
        //TODO:参数校验以及请求参数转化
        return headLineService.queryHeadLine(null,1,100);
    }
}
