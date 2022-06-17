package demo.reflect;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @ClassName: FieldCollector
 * @Description:
 * @Author: Du
 * @Date: 2022/6/17
 */
public class FieldCollector {
    public static void main(String[] args) throws Exception {
        //获取Class对象
        Class<?> clazz = Class.forName("demo.reflect.ReflectTarget");
        //获取所有公有字段
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        //获取所有字段
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        //获取单个特定公有的field
        Field name = clazz.getField("name");
        System.out.println("公有field："+name);
        ReflectTarget reflectTarget = (ReflectTarget)clazz.getConstructor().newInstance();
        //给获取到的field赋值
        name.set(reflectTarget,"反射1号");
        //验证对应的值name
        System.out.println("验证name :"+reflectTarget.name);
        //获取单个私有的field
        Field targetInfo = clazz.getDeclaredField("targetInfo");
        System.out.println(targetInfo);
        targetInfo.setAccessible(true);
        targetInfo.set(reflectTarget,"12345566");
        System.out.println("验证消息"+reflectTarget);
    }
}
