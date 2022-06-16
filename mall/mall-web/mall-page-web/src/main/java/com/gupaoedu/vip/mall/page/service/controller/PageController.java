package com.gupaoedu.vip.mall.page.service.controller;

import com.gupaoedu.mall.util.RespResult;
import com.gupaoedu.vip.mall.page.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: PageController
 * @Description:
 * @Author: Du
 * @Date: 2022/5/20
 */
@RestController
@RequestMapping(value = "/page")
public class PageController {
    @Autowired
    private PageService pageService;

    /****
     * 生成静态页
     */
    @GetMapping(value = "/{id}")
    public RespResult html(@PathVariable(value = "id")String id) throws Exception {
        System.out.println(id);
        pageService.html(id);
        return RespResult.ok();
    }
}
