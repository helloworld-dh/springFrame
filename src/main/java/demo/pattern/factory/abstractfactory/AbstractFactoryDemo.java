package demo.pattern.factory.abstractfactory;

import demo.pattern.factory.entity.Keyboard;
import demo.pattern.factory.entity.Mouse;

/**
 * @ClassName: AbstractFactoryDemo
 * @Description:
 * @Author: Du
 * @Date: 2022/6/17
 */
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        ComputerFactory factory = new DellComputerFactory();
        Keyboard keyboard = factory.createKeyboard();
        Mouse mouse = factory.createMouse();
        mouse.sayHi();
        keyboard.sayHello();
    }
}
