package com.gupaoedu.vip.mall.search.mapper;

import com.gupaoedu.vip.mall.search.model.SeckillGoodsEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @InterfaceName: SeckillGoodsSearchMapper
 * @Description:
 * @Author: Du
 * @Date: 2022/5/24
 */
public interface SeckillGoodsSearchMapper extends ElasticsearchRepository<SeckillGoodsEs,String> {
}
