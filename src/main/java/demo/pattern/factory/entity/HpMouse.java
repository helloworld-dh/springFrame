package demo.pattern.factory.entity;

/**
 * @ClassName: HpMouse
 * @Description:
 * @Author: Du
 * @Date: 2022/6/17
 */
public class HpMouse implements Mouse{

    @Override
    public void sayHi() {
        System.out.println("惠普鼠标");
    }
}
