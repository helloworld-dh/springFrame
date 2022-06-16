package com.gupaoedu.vip.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: MallUserApplication
 * @Description:
 * @Author: Du
 * @Date: 2022/5/21
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.gupaoedu.vip.mall.user.mapper"})
public class MallUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallUserApplication.class,args);
    }
}
