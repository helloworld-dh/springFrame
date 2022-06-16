package com.gupaoedu.vip.mall.goods.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: CategoryBrand
 * @Description:
 * @Author: Du
 * @Date: 2022/5/15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//MyBatisPlus表映射注解
@TableName(value = "category_brand")
public class CategoryBrand {
    @TableField
    private Integer categoryId;

    @TableField
    private Integer brandId;
}
