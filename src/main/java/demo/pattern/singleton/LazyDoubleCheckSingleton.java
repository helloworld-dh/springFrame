package demo.pattern.singleton;

/**
 * @ClassName: LazyDoubleCheckSingleton
 * @Description:
 * @Author: Du
 * @Date: 2022/6/18
 */
public class LazyDoubleCheckSingleton {
    private volatile static LazyDoubleCheckSingleton instance;

    private LazyDoubleCheckSingleton(){

    }

    public static LazyDoubleCheckSingleton getInstance(){
        //第一次检测
        if(instance==null){
            //同步
            synchronized (LazyDoubleCheckSingleton.class){
                if(instance==null){
                    //memory=allocate();//分配对象内存空间
                    //instance(memory); //初始化对象
                    //instance=memory;//设置instance指向刚分配的内存地址，此时instance!=null
                    instance = new LazyDoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
