package demo.generic;

import java.util.Random;

/**
 * @ClassName: RobotFactory   具体类实现泛型接口
 * @Description:
 * @Author: Du
 * @Date: 2022/6/16
 */
public class RobotFactory implements GenericIFactory<String,Integer>{
    private String[] stringRobot = new String[]{"Hello","Hi"};
    private Integer[] integerRobot = new Integer[]{1111,000};

    @Override
    public String nextObject() {
        Random random = new Random();
        return stringRobot[random.nextInt(2)]; //[0,2)
    }

    @Override
    public Integer nextNumber() {
        Random random = new Random();
        return integerRobot[random.nextInt(2)];
    }

    public static void main(String[] args) {
        GenericIFactory<String,Integer> factory = new RobotFactory();
        System.out.println(factory.nextObject());
        System.out.println(factory.nextNumber());
    }
}