package demo.annotation;

/**
 * @ClassName: Course
 * @Description:
 * @Author: Du
 * @Date: 2022/6/18
 */
@CourseInfoAnnotation(courseName = "操作系统",courseTag = "解析底层",courseProfile = "内核和用户态")
public class Course {

    @PersonInfoAnnotation(name = "小du",language = {"java"})
    private String author;

    @CourseInfoAnnotation(courseName = "电商平台",courseTag = "实战",courseProfile = "深入理解请求路径",courseIndex = 144)
    public void getCourseInfo(){

    }

}
