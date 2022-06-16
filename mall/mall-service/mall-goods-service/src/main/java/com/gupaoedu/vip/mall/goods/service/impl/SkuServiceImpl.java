package com.gupaoedu.vip.mall.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gupaoedu.vip.mall.cart.model.Cart;
import com.gupaoedu.vip.mall.goods.mapper.AdItemsMapper;
import com.gupaoedu.vip.mall.goods.mapper.SkuMapper;
import com.gupaoedu.vip.mall.goods.model.AdItems;
import com.gupaoedu.vip.mall.goods.model.Sku;
import com.gupaoedu.vip.mall.goods.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: SkuServiceImpl
 * @Description:
 * @Author: Du
 * @Date: 2022/5/16
 */
@Service
@CacheConfig(cacheNames = "ad-items-skus")
public class SkuServiceImpl extends ServiceImpl<SkuMapper, Sku> implements SkuService {
    @Autowired
    private AdItemsMapper adItemsMapper;

    @Autowired
    private SkuMapper skuMapper;

    /***
     * 根据推广产品分类ID查询Sku列表
     * cacheNames = "ad-items-skus":命名空间
     * key ="#id":入参id作为缓存的key，使用的是SpEL表达式
     */
//    @Cacheable(cacheNames = "ad-items-skus",key ="#id")
    @Cacheable(key ="#id")
    @Override
    public List<Sku> typeSkuItems(Integer id) {
        System.out.println("查询数据库");
        //查询所有分类下的推广
        QueryWrapper<AdItems> adItemsQueryWrapper=new QueryWrapper<AdItems>();
        adItemsQueryWrapper.eq("type",id);
        List<AdItems> adItems = adItemsMapper.selectList(adItemsQueryWrapper);

        //获取所有SkuId
        List<String> skuIds = adItems.stream().map(adItem -> adItem.getSkuId()).collect(Collectors.toList());
        //批量查询Sku
        List<Sku> skus = skuMapper.selectBatchIds(skuIds);
        return skus;
    }

    /****
     * 清理缓存
     * @param id
     */
//    @CacheEvict(cacheNames = "ad-items-skus",key ="#id")
    @CacheEvict(key ="#id")
    @Override
    public void delTypeSkuItems(Integer id) {
    }

    /**
     * 修改缓存
     * @param id
     * @return
     */
//    @CachePut(cacheNames = "ad-items-skus",key = "#id")
    @CachePut(key = "#id")
    @Override
    public List<Sku> updateSkuItems(Integer id) {
        //查询所有分类下的推广
        QueryWrapper<AdItems> adItemsQueryWrapper=new QueryWrapper<AdItems>();
        adItemsQueryWrapper.eq("type",id);
        List<AdItems> adItems = adItemsMapper.selectList(adItemsQueryWrapper);

        //获取所有SkuId
        List<String> skuIds = adItems.stream().map(adItem -> adItem.getSkuId()).collect(Collectors.toList());
        //批量查询Sku
        List<Sku> skus = skuMapper.selectBatchIds(skuIds);
        return skus;
    }

    /***
     * 库存递减
     * @param carts
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void dcount(List<Cart> carts) {
        for (Cart cart : carts) {
            //库存递减
            int dcount = skuMapper.dcount(cart.getSkuId(), cart.getNum());
            System.out.println("====================");
            System.out.println("dcount"+dcount);
            if(dcount<=0){
                throw new RuntimeException("库存不足！");
            }
        }
    }
}
