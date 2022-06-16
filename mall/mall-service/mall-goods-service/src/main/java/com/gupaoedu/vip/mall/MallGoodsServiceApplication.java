package com.gupaoedu.vip.mall;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName: MallGoodsServiceApplication
 * @Description:
 * @Author: Du
 * @Date: 2022/5/15
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.gupaoedu.vip.mall.goods.mapper"})
//开启缓存
@EnableCaching
public class MallGoodsServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallGoodsServiceApplication.class,args);
    }

}
