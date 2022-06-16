package com.gupaoedu.vip.mall.page.service;

/**
 * @InterfaceName: SeckillPageService
 * @Description:
 * @Author: Du
 * @Date: 2022/5/24
 */
public interface SeckillPageService {
    //秒杀详情页生成
    void html(String id) throws Exception;

    //删除秒杀详情页
    void delete(String id);
}
