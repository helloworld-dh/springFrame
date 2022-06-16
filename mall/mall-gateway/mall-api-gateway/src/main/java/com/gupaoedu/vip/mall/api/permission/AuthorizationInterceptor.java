package com.gupaoedu.vip.mall.api.permission;

import com.alibaba.fastjson.JSON;
import com.gupaoedu.mall.util.JwtToken;
import com.gupaoedu.mall.util.MD5;
import com.gupaoedu.vip.mall.api.util.IPUtil;
import com.gupaoedu.vip.mall.cart.model.Permission;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.net.URI;
import java.util.*;

/**
 * @ClassName: AuthorizationInterceptor
 * @Description:
 * @Author: Du
 * @Date: 2022/5/28
 */
@Component
public class AuthorizationInterceptor {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedissonClient redissonClient;

    /****
     * 判断uri是否为有效路径
     * @param uri
     * @return
     */
    public Boolean isInvalid(String uri){
        RBloomFilter<String> uriBloomFilterArray = redissonClient.getBloomFilter("UriBloomFilterArray");
//        System.out.println(uriBloomFilterArray.toString());
        return uriBloomFilterArray.contains(uri);
    }


    /***
     * 角色权限校验
     */
    public Boolean rolePermission(ServerWebExchange exchange,Map<String, Object> token){
        //request
        ServerHttpRequest request = exchange.getRequest();
        //uri
        String uri = request.getURI().getPath();
        //提交方法
        String method = request.getMethodValue();
        //路由URI信息
        URI routerUri = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR);

        //获取角色
        String[] roles = token.get("roles").toString().split(",");
        //当前角色权限
        Permission permission = null;

        //循环角色，获取角色权限
        for (String role : roles) {
            //===========完全匹配数据key0==============
            String key0 = "Role_0_"+role;
            //获取角色权限数据
            Set<Permission> rolePermissionList0 = (Set<Permission>) redisTemplate.boundHashOps("RolePermissionMap").get(key0);
            if(rolePermissionList0!=null){
                //匹配权限
                permission = match0(new ArrayList<Permission>(rolePermissionList0), uri, method, routerUri.getHost());
            }

            if(permission==null){
                //===========通配符匹配数据key1，作业==============
            }

            //如果找不到权限，说明无权访问
            if(permission!=null){
                break;
            }
        }
        return permission!=null;
    }

    /***
     * 令牌校验
     */
    public Map<String, Object> tokenIntercept(ServerWebExchange exchange){
        //request
        ServerHttpRequest request = exchange.getRequest();
        //客户端IP
        String ip = IPUtil.getIp(request);
        //用户令牌
        String token = request.getHeaders().getFirst("authorization");
        //令牌校验
        Map<String, Object> resultMap = AuthorizationInterceptor.jwtVerify(token, ip);
        return resultMap;
    }




    /****
     * 校验是否需要拦截指定请求
     * true:需要拦截
     * false:不需要拦截
     */
    public Boolean isIntercept(ServerWebExchange exchange){

        //request
        ServerHttpRequest request = exchange.getRequest();
        //uri
        String uri = request.getURI().getPath();
        //提交方法
        String method = request.getMethodValue();
        //路由URI信息
        URI routerUri = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR);
//        System.out.println("==========="+routerUri);
        //获取所有权限
        System.out.println("=========================");
        List<Permission> permissionMatch0 = (List<Permission>) redisTemplate.boundHashOps("RolePermissionAll").get("PermissionListMatch0");
        //完全匹配
        Permission permission = match0(permissionMatch0, uri, method,routerUri.getHost());
        //完全匹配如果没有，则匹配通配符
        if(permission==null){
            //匹配通配符
            List<Permission> permissionMatch1 = (List<Permission>) redisTemplate.boundHashOps("RolePermissionAll").get("PermissionListMatch1");
            //进行匹配，这里作为作业
        }
        //如果此时permission则表示不需要进行权限校验
        if(permission==null){
            //不需要权限校验
            return false;
        }
        return true;
    }

    /***
     * 完全匹配
     * @param permissionMatch0
     * @param uri
     * @param method
     * @return
     */
    public Permission match0(List<Permission> permissionMatch0,String uri,String method,String serviceName){
        //循环匹配
        for (Permission permission : permissionMatch0) {
            String matchUrl = permission.getUrl();
            String matchMethod = permission.getMethod();
            if(matchUrl.equals(uri)){
                //匹配提交方式
                if(!matchMethod.equals("*") && matchMethod.equalsIgnoreCase(method) && serviceName.equals(permission.getServiceName())){
                    return permission;
                }
            }
        }
        return null;
    }


    /***
     * 令牌解析
     */
    public static Map<String, Object> jwtVerify(String token, String clientIp){
        try {
            //token解析
            Map<String, Object> resultMap = JwtToken.parseToken(token);
            //令牌中的IP
            String jwtip = resultMap.get("ip").toString();

            //IP校验
            clientIp = MD5.md5(clientIp);
            if(clientIp.equals(jwtip)){
                return resultMap;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
