package com.it.service.combine;

import com.it.entity.dto.MainPageInfoDTO;
import com.it.entity.dto.Result;

/**
 * @InterfaceName: HeadLineShopCategoryCombineService
 * @Description:
 * @Author: Du
 * @Date: 2022/6/17
 */
public interface HeadLineShopCategoryCombineService {
    Result<MainPageInfoDTO> getMainPageInfo();
}
