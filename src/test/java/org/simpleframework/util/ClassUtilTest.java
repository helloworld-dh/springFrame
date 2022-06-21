package org.simpleframework.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * @ClassName: ClassUtilTest
 * @Description:
 * @Author: Du
 * @Date: 2022/6/18
 */
public class ClassUtilTest {

    @DisplayName("提取目标类方法:extractPackageClassTest")
    @Test
    public void extractPackageClassTest(){
        Set<Class<?>> classSet = ClassUtil.extractPackageClass("com.it.entity");
        System.out.println(classSet);
        Assertions.assertEquals(4,classSet.size());
    }
}
