package com.gupaoedu.vip.mall.search.controller;

import com.gupaoedu.mall.util.RespResult;
import com.gupaoedu.mall.util.UrlUtils;
import com.gupaoedu.vip.mall.search.feign.SkuSearchFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @ClassName: SearchController
 * @Description:
 * @Author: Du
 * @Date: 2022/5/19
 */
@Controller
@RequestMapping(value = "/web/search")
public class SearchController {

    @Autowired
    private SkuSearchFeign skuSearchFeign;

    /***
     * 搜索
     */
    @GetMapping
    public String search(@RequestParam(required = false) Map<String,Object> searchMap, Model model){
        //搜索
        RespResult<Map<String, Object>> resultMap = skuSearchFeign.search(searchMap);
//        for (Map.Entry<String, Object> entry : resultMap.getData().entrySet()) {
//            if(entry.getKey().equals("categoryList")){
//                System.out.println(entry.getValue().getClass());
//            }
//            if(entry.getKey().equals("list")){
//                System.out.println(entry.getValue().getClass());
//            }
//        }
        System.out.println(resultMap.getData());

        //组装用户访问的url
        model.addAttribute("url", UrlUtils.map2url("/web/search",searchMap,"page"));
        model.addAttribute("urlsort", UrlUtils.map2url("/web/search",searchMap,"sm","sfield","page"));
        model.addAttribute("result",resultMap.getData());
        model.addAttribute("searchMap",searchMap);
        return "search";
    }
}
