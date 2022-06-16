package com.gupaoedu.vip.mall.permission.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gupaoedu.vip.mall.cart.model.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @InterfaceName: PermissionMapper
 * @Description:
 * @Author: Du
 * @Date: 2022/5/28
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    @Select("SELECT * FROM role_permission")
    List<Map<Integer, Integer>> allRolePermissions();
}
