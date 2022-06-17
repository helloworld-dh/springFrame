package com.it.entity.dto;

import com.it.entity.bo.HeadLine;
import com.it.entity.bo.ShopCategory;
import lombok.Data;

import java.util.List;

/**
 * @ClassName: MainPageInfoDTO
 * @Description:
 * @Author: Du
 * @Date: 2022/6/17
 */
@Data
public class MainPageInfoDTO {
    private List<HeadLine> headLineList;
    private List<ShopCategory> shopCategoryList;
}
