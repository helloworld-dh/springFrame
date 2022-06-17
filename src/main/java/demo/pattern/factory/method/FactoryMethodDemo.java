package demo.pattern.factory.method;

import demo.pattern.factory.entity.Mouse;

/**
 * @ClassName: FactoryMehodDemo
 * @Description:
 * @Author: Du
 * @Date: 2022/6/17
 */
public class FactoryMethodDemo {
    public static void main(String[] args) {
        MouseFactory mf = new HpMouseFactory();
        Mouse mouse = mf.createMouse();
        mouse.sayHi();
    }
}
