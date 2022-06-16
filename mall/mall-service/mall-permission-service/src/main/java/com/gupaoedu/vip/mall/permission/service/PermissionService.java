package com.gupaoedu.vip.mall.permission.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gupaoedu.vip.mall.cart.model.Permission;

import java.util.List;
import java.util.Map;

/**
 * @InterfaceName: PermissionService
 * @Description:
 * @Author: Du
 * @Date: 2022/5/28
 */
public interface PermissionService extends IService<Permission> {

    //不同匹配方式的权限
    List<Permission> findByMatch(Integer matchMethod);

    //所有角色的权限映射
    List<Map<Integer, Integer>> allRolePermissions();
}
