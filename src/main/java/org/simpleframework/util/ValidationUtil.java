package org.simpleframework.core.util;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/**
 * @ClassName: ValidationUtil
 * @Description:
 * @Author: Du
 * @Date: 2022/6/19
 */
public class ValidationUtil {

    /**
     * Collection是否为Null或者size为0
     * @param obj
     * @return
     */
    public static boolean isEmpty(Collection<?> obj){
        return obj==null || obj.isEmpty();
    }

    /**
     * Array是否为Null或者size=0
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object[] obj){
        return obj==null || obj.length==0;
    }

    /**
     * map是否为Null或者size为0
     * @param obj
     * @return
     */
    public static boolean isEmpty(Map<?,?> obj){
        return obj==null || obj.isEmpty();
    }

    /**
     * 判断String是否为空
     * @param obj
     * @return
     */
    public static boolean isEmpty(String obj){
        return obj==null || obj.equals("");
    }
}
