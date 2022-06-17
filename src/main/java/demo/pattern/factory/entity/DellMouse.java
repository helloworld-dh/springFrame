package demo.pattern.factory.entity;

/**
 * @ClassName: DellMouse
 * @Description:
 * @Author: Du
 * @Date: 2022/6/17
 */
public class DellMouse implements Mouse{
    @Override
    public void sayHi() {
        System.out.println("戴尔鼠标");
    }
}
