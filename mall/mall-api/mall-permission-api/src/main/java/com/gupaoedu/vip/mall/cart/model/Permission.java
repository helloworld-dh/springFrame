package com.gupaoedu.vip.mall.cart.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName: Permission
 * @Description:
 * @Author: Du
 * @Date: 2022/5/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "permission")
public class Permission implements Serializable {

    @TableId(type = IdType.ASSIGN_ID)
    private Integer id;
    private String sourceName;
    private String url;
    private Integer urlMatch;
    private String serviceName;
    private String method;
}
