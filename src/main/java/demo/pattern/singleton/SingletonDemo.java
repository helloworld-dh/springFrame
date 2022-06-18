package demo.pattern.singleton;

import java.lang.reflect.Constructor;

/**
 * @ClassName: SingletonDemo
 * @Description:
 * @Author: Du
 * @Date: 2022/6/18
 */
public class SingletonDemo {
    public static void main(String[] args) throws Exception {
        System.out.println(StarvingSingleton.getInstance());
        System.out.println(StarvingSingleton.getInstance());
        System.out.println(LazyDoubleCheckSingleton.getInstance());
        System.out.println(LazyDoubleCheckSingleton.getInstance());

        //单例模式是否安全
        System.out.println(LazyDoubleCheckSingleton.getInstance());
        Class<LazyDoubleCheckSingleton> lazyDoubleCheckSingletonClass = LazyDoubleCheckSingleton.class;
        Constructor constructor = lazyDoubleCheckSingletonClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        System.out.println(constructor.newInstance());

        System.out.println(EnumStarvingSingleton.getInstance());
        Class<EnumStarvingSingleton> clazz = EnumStarvingSingleton.class;
        Constructor constructorEnum = clazz.getDeclaredConstructor();
        constructorEnum.setAccessible(true);
        EnumStarvingSingleton enumStarvingSingleton = (EnumStarvingSingleton) constructorEnum.newInstance();
        System.out.println(enumStarvingSingleton);
    }
}
