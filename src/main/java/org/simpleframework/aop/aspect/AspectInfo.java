package org.simpleframework.aop.aspect;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.simpleframework.aop.PointcutLocator;

/**
 * @ClassName: AspectInfo
 * @Description:
 * @Author: Du
 * @Date: 2022/6/21
 */

@Getter
@AllArgsConstructor
public class AspectInfo {
    private int orderIndex;
    private DefaultAspect aspectObject;
    private PointcutLocator pointcutLocator;
}
