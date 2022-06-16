package com.gupaoedu.vip.mall.page.service;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * @ClassName: PageService
 * @Description:
 * @Author: Du
 * @Date: 2022/5/20
 */
public interface PageService {
    //生成静态页
    void html(String id) throws Exception;
}