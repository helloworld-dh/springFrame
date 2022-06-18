package demo.annotation;

/**
 * @ClassName: TypeParameterDemo
 * @Description:
 * @Author: Du
 * @Date: 2022/6/17
 */
public class TypeParameterDemo<@TypeParameterAnnotation T> {
    public <@TypeParameterAnnotation U> T foo(T t){
        return null;
    }
}
