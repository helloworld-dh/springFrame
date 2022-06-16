package com.gupaoedu.vip.mall.pay.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gupaoedu.vip.mall.pay.model.PayLog;

/**
 * @InterfaceName: PayLogService
 * @Description:
 * @Author: Du
 * @Date: 2022/5/22
 */
public interface PayLogService extends IService<PayLog> {
    void add(PayLog payLog);
}
