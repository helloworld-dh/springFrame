package com.gupaoedu.vip.mall.search.mapper;

import com.gupaoedu.vip.mall.search.model.SkuEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @InterfaceName: SkuSearchMapper
 * @Description:
 * @Author: Du
 * @Date: 2022/5/17
 */
public interface SkuSearchMapper extends ElasticsearchRepository<SkuEs,String> {

}
