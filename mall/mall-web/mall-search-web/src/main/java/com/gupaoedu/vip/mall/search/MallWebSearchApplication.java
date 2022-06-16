package com.gupaoedu.vip.mall.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName: MallWebSearchApplication
 * @Description:
 * @Author: Du
 * @Date: 2022/5/19
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "com.gupaoedu.vip.mall.search.feign")
public class MallWebSearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallWebSearchApplication.class,args);
    }
}
