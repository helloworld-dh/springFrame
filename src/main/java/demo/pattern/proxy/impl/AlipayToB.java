package demo.pattern.proxy.impl;

import demo.pattern.proxy.ToBPayment;

/**
 * @ClassName: AlipayToB
 * @Description:
 * @Author: Du
 * @Date: 2022/6/20
 */
public class AlipayToB implements ToBPayment {

    private ToBPayment toBPayment;

    public AlipayToB(ToBPayment toBPayment) {
        this.toBPayment = toBPayment;
    }

    @Override
    public void pay() {
        beforePay();
        toBPayment.pay();
        afterPay();
    }

    private void afterPay() {
        System.out.println("支付给店家");
    }

    private void beforePay() {
        System.out.println("从招行取款");
    }
}
