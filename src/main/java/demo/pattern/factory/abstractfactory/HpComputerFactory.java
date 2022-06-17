package demo.pattern.factory.abstractfactory;

import demo.pattern.factory.entity.HpKeyboard;
import demo.pattern.factory.entity.HpMouse;
import demo.pattern.factory.entity.Keyboard;
import demo.pattern.factory.entity.Mouse;

/**
 * @ClassName: HpComputerFactory
 * @Description:
 * @Author: Du
 * @Date: 2022/6/17
 */
public class HpComputerFactory implements ComputerFactory{
    @Override
    public Mouse createMouse() {

        return new HpMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new HpKeyboard();
    }
}
