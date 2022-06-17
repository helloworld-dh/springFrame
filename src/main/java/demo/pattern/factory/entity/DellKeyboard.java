package demo.pattern.factory.entity;

/**
 * @ClassName: DellKeyboard
 * @Description:
 * @Author: Du
 * @Date: 2022/6/17
 */
public class DellKeyboard implements Keyboard{

    @Override
    public void sayHello() {
        System.out.println("戴尔键盘");
    }
}
