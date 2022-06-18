package demo.pattern.singleton;

/**
 * @ClassName: StarvingSingleton
 * @Description:
 * @Author: Du
 * @Date: 2022/6/18
 */
public class StarvingSingleton {

    private static final StarvingSingleton starvingSingleton = new StarvingSingleton();

    private StarvingSingleton(){

    }
    public static StarvingSingleton getInstance(){
        return starvingSingleton;
    }

    public static void main(String[] args) {
        System.out.println(StarvingSingleton.getInstance());
        System.out.println(StarvingSingleton.getInstance());

    }

}
