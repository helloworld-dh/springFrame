package demo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName: ConstructorCollector
 * @Description:
 * @Author: Du
 * @Date: 2022/6/17
 */
public class ConstructorCollector {
    public static void main(String[] args) throws Exception{
        Class<?> clazz = Class.forName("demo.reflect.ReflectTarget");
        //获取公有的构造方法
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        //获取单个带参数的公有方法
        Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
        System.out.println(constructor);

        //获取单个私有的构造方法
        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(int.class);
        System.out.println("private con =" +declaredConstructor);

        //创建实例  暴力访问，忽略修饰符
        declaredConstructor.setAccessible(true);
        ReflectTarget reflectTarget = (ReflectTarget)declaredConstructor.newInstance(1);

    }
}
