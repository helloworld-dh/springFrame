package demo.generic;

/**
 * @ClassName: GenericFactoryImpl
 * @Description:
 * @Author: Du
 * @Date: 2022/6/16
 */

/**
 * 泛型类实现泛型接口
 * @param <T>
 * @param <N>
 */
public class GenericFactoryImpl<T,N> implements GenericIFactory<T,N>{
    @Override
    public T nextObject() {
        return null;
    }

    @Override
    public N nextNumber() {
        return null;
    }
}
