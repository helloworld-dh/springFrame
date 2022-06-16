package com.gupaoedu.vip.mall.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @ClassName: MallFileApplication
 * @Description:
 * @Author: Du
 * @Date: 2022/5/16
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MallFileApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallFileApplication.class,args);
    }
}
