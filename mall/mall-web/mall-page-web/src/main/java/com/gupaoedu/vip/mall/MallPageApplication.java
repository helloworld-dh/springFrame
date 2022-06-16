package com.gupaoedu.vip.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName: MallPageApplication
 * @Description:
 * @Author: Du
 * @Date: 2022/5/20
 */
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.gupaoedu.vip.mall.goods.feign","com.gupaoedu.vip.mall.seckill.feign"})
public class MallPageApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallPageApplication.class,args);
    }
}
