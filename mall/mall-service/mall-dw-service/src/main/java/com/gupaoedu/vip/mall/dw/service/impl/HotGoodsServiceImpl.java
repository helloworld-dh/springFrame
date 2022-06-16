package com.gupaoedu.vip.mall.dw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gupaoedu.vip.mall.dw.mapper.HotGoodsMapper;
import com.gupaoedu.vip.mall.dw.model.HotGoods;
import com.gupaoedu.vip.mall.dw.service.HotGoodsService;
import com.gupaoedu.vip.mall.dw.util.DruidPage;
import com.gupaoedu.vip.mall.dw.util.TimeUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: HotGoodsServiceImpl
 * @Description:
 * @Author: Du
 * @Date: 2022/5/26
 */
@Service
public class HotGoodsServiceImpl extends ServiceImpl<HotGoodsMapper, HotGoods> implements HotGoodsService {

    @Autowired
    private HotGoodsMapper hotGoodsMapper;

    /***
     * 前N条
     */
    @Override
    public List<HotGoods> topNum(Integer size) {
        return hotGoodsMapper.topNum(size);
    }
    /***
     * 分页查询
     */
    @Override
    public DruidPage<List<HotGoods>> pageList(Integer size, Integer page) {
        //计算偏移量
        DruidPage<List<HotGoods>> druidPage = new DruidPage<List<HotGoods>>(page,size);
        //查询总数
        Integer total = hotGoodsMapper.selectCount(null);
        //查询集合
        List<HotGoods> hotGoods = hotGoodsMapper.pageList(size, druidPage.getOffset());
        return druidPage.pages(hotGoods,total);
    }

    @Override
    public DruidPage<List<HotGoods>> pageListSort(Integer size, Integer page,String sort,String sortType) {
        //计算偏移量
        DruidPage<List<HotGoods>> druidPage = new DruidPage<List<HotGoods>>(page,size,sort,sortType);
        //查询总数
        Integer total = hotGoodsMapper.selectCount(null);
        //查询集合
        List<HotGoods> hotGoods = hotGoodsMapper.pageListSort(druidPage);
        return druidPage.pages(hotGoods,total);
    }

    /****
     * 时间查询
     */
    @Override
    public List<HotGoods> search(Integer size, Integer hour) {
        return hotGoodsMapper.search(size, TimeUtil.beforeTime(TimeUtil.unit_hour,hour));
    }

    /****
     * 时间查询+排除指定数据
     */
    @Override
    public List<HotGoods> search(Integer size, Integer hour,String[] urils) {
        //urils---> 123.html','2342.html','324234.html
        String allurls = StringUtils.join(urils,"','");
        return hotGoodsMapper.searchExclude(size, TimeUtil.beforeTime(TimeUtil.unit_hour,hour),allurls);
    }

    @Override
    public List<Map<String,String>> searchHotGoods(Integer size, Integer hour, String[] urls, Integer max) {
        //urils---> 123.html','2342.html','324234.html
        String allurls = StringUtils.join(urls,"','");
        return hotGoodsMapper.searchHotGoods(size, TimeUtil.beforeTime(TimeUtil.unit_hour,hour),allurls,max);
    }
}
