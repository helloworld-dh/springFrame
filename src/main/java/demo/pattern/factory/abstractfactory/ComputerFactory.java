package demo.pattern.factory.abstractfactory;

import demo.pattern.factory.entity.Keyboard;
import demo.pattern.factory.entity.Mouse;

/**
 * @InterfaceName: ComputerFactory
 * @Description:
 * @Author: Du
 * @Date: 2022/6/17
 */
public interface ComputerFactory {

    Mouse createMouse();

    Keyboard createKeyboard();
}
