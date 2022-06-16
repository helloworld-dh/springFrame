package com.gupaoedu.vip.mall.dw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: DwApplication
 * @Description:
 * @Author: Du
 * @Date: 2022/5/26
 */
@SpringBootApplication
@MapperScan(basePackages = "com.gupaoedu.vip.mall.dw.mapper")
public class DwApplication {
    public static void main(String[] args) {
        SpringApplication.run(DwApplication.class,args);
    }
}
