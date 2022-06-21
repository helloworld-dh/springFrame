package demo.pattern.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName: AlipayInvocationHandler
 * @Description:
 * @Author: Du
 * @Date: 2022/6/21
 */
public class AlipayInvocationHandler implements InvocationHandler {

    private Object targetObject;

    public AlipayInvocationHandler(Object targetObject){
        this.targetObject = targetObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforePay();
        Object result = method.invoke(targetObject, args);
        afterPay();
        return result;
    }

    private void afterPay() {
        System.out.println("支付给店家");
    }

    private void beforePay() {
        System.out.println("从招行取款");
    }
}
