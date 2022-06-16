package com.gupaoedu.vip.mall.user.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName: Address
 * @Description:
 * @Author: Du
 * @Date: 2022/5/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//MyBatisPlus表映射注解
@TableName(value = "address")
public class Address implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String provinceid;
    private String cityid;
    private String areaid;
    private String phone;
    private String address;
    private String contact;
    private Integer isDefault;
}
