package demo.pattern.template;

/**
 * @ClassName: RoomForAmericanSinger
 * @Description:
 * @Author: Du
 * @Date: 2022/6/19
 */
public class RoomForAmericanSinger extends KTVRoom{
    @Override
    protected void orderSong() {
        System.out.println("Chinese song in English version please...");
    }
}
