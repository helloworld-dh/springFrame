package com.it.entity.bo;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName: ShopCategory
 * @Description:
 * @Author: Du
 * @Date: 2022/6/16
 */
@Data
public class ShopCategory {
    private Long shopCategoryId;
    private String shopCategoryName;
    private String shopCategoryDesc;
    private String shopCategoryImg;
    private Integer priority;
    private Date createTime;
    private Date lastEditTime;
    private ShopCategory parent;
}
