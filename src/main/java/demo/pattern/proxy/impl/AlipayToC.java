package demo.pattern.proxy.impl;

import demo.pattern.proxy.ToCPayment;

/**
 * @ClassName: AlipayToC
 * @Description:
 * @Author: Du
 * @Date: 2022/6/20
 */
public class AlipayToC implements ToCPayment {

    private ToCPayment toCPayment;

    public AlipayToC(ToCPayment toCPayment){
        this.toCPayment = toCPayment;
    }

    @Override
    public void pay() {

        beforePay();
        toCPayment.pay();
        afterPay();
    }

    private void afterPay() {
        System.out.println("支付给店家");
    }

    private void beforePay() {
        System.out.println("从招行取款");
    }
}
