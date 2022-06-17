package demo.reflect;

import java.lang.reflect.Method;

/**
 * @ClassName: MethodCollector
 * @Description:
 * @Author: Du
 * @Date: 2022/6/17
 */
public class MethodCollector {
    public static void main(String[] args) throws Exception {
        //获取class对象
        Class<?> clazz = Class.forName("demo.reflect.ReflectTarget");
        //获取所有的Public方法，包括父类和Object
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        //获取类的所有方法,包括私有的
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
        //获取单个公有方法
        Method show1 = clazz.getMethod("show1", String.class);
        System.out.println(show1);
        ReflectTarget reflectTarget = (ReflectTarget)clazz.getConstructor().newInstance();
        show1.invoke(reflectTarget,"反射1号");
        //获取私有的方法
        Method show4 = clazz.getDeclaredMethod("show4", int.class);
        System.out.println(show4);
        show4.setAccessible(true);
        String result = String.valueOf(show4.invoke(reflectTarget, 20));
        System.out.println(result);
    }


}
