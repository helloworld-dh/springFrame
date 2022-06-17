package demo.pattern.factory.entity;

/**
 * @ClassName: HpKeyboard
 * @Description:
 * @Author: Du
 * @Date: 2022/6/17
 */
public class HpKeyboard implements Keyboard{
    @Override
    public void sayHello() {
        System.out.println("惠普键盘");
    }
}
