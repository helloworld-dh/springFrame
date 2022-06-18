package demo.pattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName: EnumStarvingSingleton
 * @Description:
 * @Author: Du
 * @Date: 2022/6/18
 */
public class EnumStarvingSingleton {

    private EnumStarvingSingleton(){

    }
    public static EnumStarvingSingleton getInstance(){
        return ContainerHolder.HOLDER.instance;
    }

    private enum ContainerHolder{
        HOLDER;
        private EnumStarvingSingleton instance;
        ContainerHolder(){
            instance = new EnumStarvingSingleton();
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<ContainerHolder> containerHolderClass = ContainerHolder.class;
        Constructor constructor = containerHolderClass.getDeclaredConstructor(String.class,int.class);
        constructor.setAccessible(true);
        System.out.println(EnumStarvingSingleton.getInstance());
        System.out.println(constructor.newInstance());
    }
}
