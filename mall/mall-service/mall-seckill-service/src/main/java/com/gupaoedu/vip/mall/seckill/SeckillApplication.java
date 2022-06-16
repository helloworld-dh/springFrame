package com.gupaoedu.vip.mall.seckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName: SeckillApplication
 * @Description:
 * @Author: Du
 * @Date: 2022/5/24
 */
@SpringBootApplication
@MapperScan(basePackages = "com.gupaoedu.vip.mall.seckill.mapper")
@EnableFeignClients(basePackages = {"com.gupaoedu.vip.mall.dw.feign"})
public class SeckillApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillApplication.class,args);
    }
}
