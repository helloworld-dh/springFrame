package demo.pattern.factory.entity;

import demo.annotation.TestAnnotation;

/**
 * @ClassName: HpMouse
 * @Description:
 * @Author: Du
 * @Date: 2022/6/17
 */
public class HpMouse implements Mouse{

    @Override
    @TestAnnotation
    public void sayHi() {
        System.out.println("惠普鼠标");
    }
}
