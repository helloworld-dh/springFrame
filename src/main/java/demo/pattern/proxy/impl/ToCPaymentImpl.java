package demo.pattern.proxy.impl;

import demo.pattern.proxy.ToCPayment;

/**
 * @ClassName: ToCPaymentImpl
 * @Description:
 * @Author: Du
 * @Date: 2022/6/20
 */
public class ToCPaymentImpl implements ToCPayment {

    @Override
    public void pay() {
        System.out.println("以用户的名义进行支付");
    }
}
