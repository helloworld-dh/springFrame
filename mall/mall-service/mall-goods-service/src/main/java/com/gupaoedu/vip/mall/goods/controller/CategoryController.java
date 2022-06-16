package com.gupaoedu.vip.mall.goods.controller;

import com.gupaoedu.mall.util.RespResult;
import com.gupaoedu.vip.mall.goods.model.Category;
import com.gupaoedu.vip.mall.goods.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: CategoryController
 * @Description:
 * @Author: Du
 * @Date: 2022/5/15
 */
@RestController
@RequestMapping(value = "/category")
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /****
     * 根据父ID查询子分类
     */
    @GetMapping(value = "/parent/{pid}")
    public RespResult<List<Category>> list(@PathVariable(value = "pid")Integer pid){
        List<Category> categories = categoryService.queryByParentId(pid);
        return RespResult.ok(categories);
    }

    /****
     * 根据分类ID查询
     */
    @GetMapping(value = "/{id}")
    public RespResult<Category> one(@PathVariable(value = "id")Integer id){
        Category category = categoryService.getById(id);
        return RespResult.ok(category);
    }
}
