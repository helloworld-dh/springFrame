package demo.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName: AnnotationParser
 * @Description:
 * @Author: Du
 * @Date: 2022/6/18
 */
public class AnnotationParser {
    //解析类的注解
    public static void parseTypeAnnotation() throws Exception {
        Class<?> clazz = Class.forName("demo.annotation.Course");
        //获取clazz对象的注解，而不是其里面的方法和成员变量的注解
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            CourseInfoAnnotation courseInfoAnnotation = (CourseInfoAnnotation) annotation;
            System.out.println("课程名"+courseInfoAnnotation.courseName() + "\n"+
                                "课程标签"+courseInfoAnnotation.courseTag() + "\n"+
                                "课程简介"+courseInfoAnnotation.courseProfile()+ "\n"+
                                "课程序号"+courseInfoAnnotation.courseIndex());
        }
    }

    //解析成员变量上的标签
    public static void parseFieldAnnotation() throws Exception {
        Class<?> clazz = Class.forName("demo.annotation.Course");
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            boolean hasAnnotation = declaredField.isAnnotationPresent(PersonInfoAnnotation.class);
            if(hasAnnotation){
                PersonInfoAnnotation personInfoAnnotation = declaredField.getAnnotation(PersonInfoAnnotation.class);
                System.out.println("名字"+personInfoAnnotation.name() +"\n"+
                                "年龄"+personInfoAnnotation.age() +"\n"+
                                "性别"+personInfoAnnotation.gender()+"\n"
                        );
                for (String language : personInfoAnnotation.language()) {
                    System.out.println("课程名"+language);
                }
            }
        }
    }

    //解析方法上的注解
    public static void parseMethodAnnotation() throws Exception {
        Class<?> clazz = Class.forName("demo.annotation.Course");
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            boolean annotationPresent = declaredMethod.isAnnotationPresent(CourseInfoAnnotation.class);
            if(annotationPresent){
                CourseInfoAnnotation annotation = declaredMethod.getAnnotation(CourseInfoAnnotation.class);
                System.out.println("课程名"+annotation.courseName() +"\n"+
                                "课程标签"+annotation.courseTag()+ "\n"+
                                "课程简介"+annotation.courseProfile()+"\n"+
                                "课程序号"+annotation.courseIndex());
            }

        }
    }


    public static void main(String[] args) throws Exception {
       // parseTypeAnnotation();
        parseFieldAnnotation();
       // parseMethodAnnotation();
    }
}
