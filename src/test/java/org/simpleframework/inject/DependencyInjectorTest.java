package org.simpleframework.inject;

import com.it.controller.frontend.MainPageController;
import com.it.service.combine.impl.HeadLineShopCategoryCombineServiceImpl;
import com.it.service.combine.impl.HeadLineShopCategoryCombineServiceImpl2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.simpleframework.core.BeanContainer;


/**
 * @ClassName: DependencyInjectorTest
 * @Description:
 * @Author: Du
 * @Date: 2022/6/19
 */
public class DependencyInjectorTest {

    @Test
    public void doIocTest(){
        BeanContainer beanContainer = BeanContainer.getInstance();
        beanContainer.loadBeans("com.it");
        Assertions.assertEquals(true,beanContainer.isLoaded());
        MainPageController mainPageController = (MainPageController)beanContainer.getBean(MainPageController.class);
        Assertions.assertEquals(true,mainPageController instanceof MainPageController);
        Assertions.assertEquals(null,  mainPageController.getHeadLineShopCategoryCombineService());
        new DependencyInjector().doIoc();
        Assertions.assertNotEquals(null,mainPageController.getHeadLineShopCategoryCombineService());
        Assertions.assertEquals(true,mainPageController.getHeadLineShopCategoryCombineService() instanceof HeadLineShopCategoryCombineServiceImpl);
        Assertions.assertEquals(false,mainPageController.getHeadLineShopCategoryCombineService() instanceof HeadLineShopCategoryCombineServiceImpl2);

    }
}
