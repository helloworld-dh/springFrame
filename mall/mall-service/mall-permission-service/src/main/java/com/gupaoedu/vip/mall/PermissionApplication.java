package com.gupaoedu.vip.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: PermissionApplication
 * @Description:
 * @Author: Du
 * @Date: 2022/5/28
 */
@SpringBootApplication
@MapperScan("com.gupaoedu.vip.mall.permission.mapper")
public class PermissionApplication {

    public static void main(String[] args) {
        SpringApplication.run(PermissionApplication.class,args);
    }
}
