package com.gupaoedu.vip.mall.cart.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: RoleInfo
 * @Description:
 * @Author: Du
 * @Date: 2022/5/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "role_info")
public class RoleInfo implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String roleName;
    private String description;

    @TableField(exist = false)
    private List<Permission> permissions;

}
