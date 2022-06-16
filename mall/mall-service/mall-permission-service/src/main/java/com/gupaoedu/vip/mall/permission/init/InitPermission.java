package com.gupaoedu.vip.mall.permission.init;

import com.gupaoedu.vip.mall.cart.model.Permission;
import com.gupaoedu.vip.mall.permission.service.PermissionService;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @ClassName: InitPermission
 * @Description:
 * @Author: Du
 * @Date: 2022/5/28
 */
@Component
public class InitPermission implements ApplicationRunner {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedissonClient redissonClient;

    /***
     * 初始化
     * @param args
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        //根据匹配方式查找  0 完全匹配  1通配符匹配
        List<Permission> permissionsMatch0 = permissionService.findByMatch(0);
        List<Permission> permissionsMatch1 = permissionService.findByMatch(1);

        //查询所有角色权限
        List<Map<Integer,Integer>> rolePermissions = permissionService.allRolePermissions();
        //匹配每个角色拥有的权限列表
        Map<String, Set<Permission>> roleMap = rolePermissionFilter(rolePermissions, permissionsMatch0, permissionsMatch1);

        //将所有权限和角色权限存入到Redis缓存
        redisTemplate.boundHashOps("RolePermissionAll").put("PermissionListMatch0",permissionsMatch0);
        redisTemplate.boundHashOps("RolePermissionAll").put("PermissionListMatch1",permissionsMatch1);
        redisTemplate.boundHashOps("RolePermissionMap").putAll(roleMap);

        //存储权限判断部分uri到布隆过滤器中-完全匹配
        RBloomFilter<String> filters = redissonClient.getBloomFilter("UriBloomFilterArray");
        filters.tryInit(1000000L,0.0001);
        for (Permission permission : permissionsMatch0) {
            filters.add(permission.getUrl());
        }

        for (Permission permission : permissionsMatch1) {
            filters.add(permission.getUrl());
        }

    }

    /***
     * 角色权限过滤
     * @param rolePermissions   : 角色权限映射关系
     * @param permissionsMatch0 ：所有完全匹配路径
     * @param permissionsMatch1 ：所有通配符匹配路径
     * @return
     */
    public Map<String,Set<Permission>> rolePermissionFilter(List<Map<Integer,Integer>> rolePermissions,
                                                            List<Permission> permissionsMatch0,
                                                            List<Permission> permissionsMatch1){
        //角色权限关系  key=roleid,value=List<Permission>
        Map<String, Set<Permission>> rolePermissionMapping = new HashMap<String,Set<Permission>>();

        //关系循环处理
        for (Map<Integer, Integer> rolePermissionMap : rolePermissions) {
            Integer rid = rolePermissionMap.get("rid");  //角色ID
            Integer pid = rolePermissionMap.get("pid");  //权限ID
            String key0 = "Role_0_"+rid.intValue();
            String key1 = "Role_1_"+rid.intValue();

            //获取当前角色拥有的权限
            Set<Permission> permissionSet0 = rolePermissionMapping.get(key0);
            Set<Permission> permissionSet1 = rolePermissionMapping.get(key1);

            //防止空指针
            permissionSet0=permissionSet0==null? new HashSet<Permission>(): permissionSet0;
            permissionSet1=permissionSet1==null? new HashSet<Permission>(): permissionSet1;

            //循环完全匹配路径
            for (Permission permission : permissionsMatch0) {
                if(permission.getId().intValue()==pid.intValue()){
                    permissionSet0.add(permission);
                    break;
                }
            }
            //循环通配符匹配路径
            for (Permission permission : permissionsMatch1) {
                if(permission.getId().intValue()==pid.intValue()){
                    permissionSet1.add(permission);
                    break;
                }
            }
            //将数据添加到rolePermissionMapping中
            if(permissionSet0.size()>0){
                rolePermissionMapping.put(key0,permissionSet0);
            }
            if(permissionSet1.size()>0){
                rolePermissionMapping.put(key1,permissionSet1);
            }
        }
        return rolePermissionMapping;
    }
}
