package com.it.controller.frontend;

import com.it.entity.dto.MainPageInfoDTO;
import com.it.entity.dto.Result;
import com.it.service.combine.HeadLineShopCategoryCombineService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: MainPageController
 * @Description:
 * @Author: Du
 * @Date: 2022/6/17
 */
public class MainPageController {
    private HeadLineShopCategoryCombineService headLineShopCategoryCombineService;

    public Result<MainPageInfoDTO> getMainPageInfo(HttpServletRequest req, HttpServletResponse resp){
        return headLineShopCategoryCombineService.getMainPageInfo();
    }
}
