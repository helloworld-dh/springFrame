package demo.generic;

import java.util.LinkedList;

/**
 * @ClassName: GenericDemo
 * @Description:
 * @Author: Du
 * @Date: 2022/6/16
 */
public class GenericDemo {

    public static void handleMember(GenericClassExample<? super Integer> integerGenericClassExample){
        int result = 111 + (Integer) integerGenericClassExample.getMember();
        System.out.println("result is "+result);
    }

    public static void main(String[] args) {
        GenericClassExample<String> stringExample = new GenericClassExample<>("abc");
//        GenericClassExample<Integer> integerExample = new GenericClassExample<>(123);
        GenericClassExample<Number> integerExample = new GenericClassExample<>(123);
        System.out.println(stringExample);
        System.out.println(integerExample);
        //泛型类的类型约束只在编译的时候有效，泛型信息在编译之后会被擦除，即<string>会在编译之后消失
        System.out.println(stringExample.getClass());
        System.out.println(integerExample.getClass());

        handleMember(integerExample);

        Integer[] integers = {1,2,3,4,5,6};
        Double[] doubles = {1.1,1.2,1.3,1.4};
        Character[] characters = {'A','N','C'};

        //泛型方法
        GenericClassExample.printArray(integers);
        GenericClassExample.printArray(doubles);
        GenericClassExample.printArray(characters);
    }
}
