package com.gupaoedu.vip.mall.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gupaoedu.vip.mall.user.model.Address;

import java.util.List;

/**
 * @InterfaceName: AddressService
 * @Description:
 * @Author: Du
 * @Date: 2022/5/21
 */
public interface AddressService extends IService<Address> {
    /****
     * 查询用户收件地址列表
     */
    List<Address> list(String userName);
}
