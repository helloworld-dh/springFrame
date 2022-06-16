package com.gupaoedu.vip.mall.api;

import com.gupaoedu.vip.mall.api.limit.IpKeyResolver;
import com.gupaoedu.vip.mall.cart.model.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

/**
 * @ClassName: ApiGatewayApplication
 * @Description:
 * @Author: Du
 * @Date: 2022/5/27
 */
@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class,args);
    }

    /***
     * IP 限流
     * @return
     */
    @Bean("ipKeyResolver")
    public KeyResolver ipKeyResolver(){
        return new IpKeyResolver();
    }

}
