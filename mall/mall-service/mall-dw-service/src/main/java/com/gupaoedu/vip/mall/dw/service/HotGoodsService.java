package com.gupaoedu.vip.mall.dw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gupaoedu.vip.mall.dw.model.HotGoods;
import com.gupaoedu.vip.mall.dw.util.DruidPage;

import java.util.List;
import java.util.Map;

/**
 * @InterfaceName: HotGoodsService
 * @Description:
 * @Author: Du
 * @Date: 2022/5/26
 */
public interface HotGoodsService extends IService<HotGoods> {
    /***
     * 前N条
     */
    List<HotGoods> topNum(Integer size);

    /***
     * 分页查询
     */
    DruidPage<List<HotGoods>> pageList(Integer size, Integer page);

    /***
     * 分页查询+排序
     */
    DruidPage<List<HotGoods>> pageListSort(Integer size,Integer page,String sort,String sortType);


    /****
     * 时间查询
     */
    List<HotGoods> search(Integer size,Integer hour);

    /****
     * 时间查询+排除
     */
    List<HotGoods> search(Integer size,Integer hour,String[] urls);

    /****
     * 时间查询+排除
     */
    List<Map<String,String>> searchHotGoods(Integer size, Integer hour, String[] urls, Integer max);
}
