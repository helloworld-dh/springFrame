package demo.pattern.proxy;

import demo.pattern.proxy.cglib.AlipayMethodInterceptor;
import demo.pattern.proxy.cglib.CglibUtil;
import demo.pattern.proxy.impl.*;
import demo.pattern.proxy.jdkproxy.AlipayInvocationHandler;
import demo.pattern.proxy.jdkproxy.JdkDynamicProxyUtil;

/**
 * @ClassName: ProxyDemo
 * @Description:
 * @Author: Du
 * @Date: 2022/6/20
 */
public class ProxyDemo {
    public static void main(String[] args) {
//        ToCPayment toCPayment = new AlipayToC(new ToCPaymentImpl());
//        toCPayment.pay();
//
//        AlipayToB alipayToB = new AlipayToB(new ToBPaymentImpl());
//        alipayToB.pay();
        ToCPaymentImpl toCPayment = new ToCPaymentImpl();
        AlipayInvocationHandler alipayInvocationHandler = new AlipayInvocationHandler(toCPayment);
        ToCPayment toCProxy = JdkDynamicProxyUtil.newProxyInstance(toCPayment, alipayInvocationHandler);
        toCProxy.pay();

        CommonPayment commonPayment = new CommonPayment();
        AlipayMethodInterceptor alipayMethodInterceptor = new AlipayMethodInterceptor();
        CommonPayment proxy = CglibUtil.createProxy(commonPayment, alipayMethodInterceptor);
        proxy.pay();
    }
}
