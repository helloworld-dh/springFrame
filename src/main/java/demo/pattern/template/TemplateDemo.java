package demo.pattern.template;

/**
 * @ClassName: TemplateDemo
 * @Description:
 * @Author: Du
 * @Date: 2022/6/19
 */
public class TemplateDemo {
    public static void main(String[] args) {
        KTVRoom room1 = new RoomForAmericanSinger();
        room1.procedure();
        KTVRoom room2 = new RoomForChineseSinger();
        room2.procedure();
    }
}
