package demo.generic;

import lombok.Data;

/**
 * @ClassName: GenericClassExample
 * @Description:
 * @Author: Du
 * @Date: 2022/6/16
 */
@Data
public class GenericClassExample <T>{
    //member这个成员变量的类型T,T的类型由外部决定
    private T member;

    //泛型构造方法形参member的类型也为T，T的类型由外部决定
    public GenericClassExample(T member){
        this.member = member;
    }

    public T handleSomething(T target){
        return target;
    }

    public static <E> void printArray(E[] inputArray){
        for (E element : inputArray) {
            System.out.printf("%s",element);
            System.out.printf(" ");
        }
        System.out.println();
    }
}
