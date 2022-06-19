package demo.pattern.template;

/**
 * @ClassName: RoomForChineseSinger
 * @Description:
 * @Author: Du
 * @Date: 2022/6/19
 */
public class RoomForChineseSinger extends KTVRoom{

    @Override
    protected void orderSong() {
        System.out.println("来收劲爆的歌");
    }

    @Override
    protected void orderExtra() {
        System.out.println("东西真便宜，一样来一份");
    }
}
