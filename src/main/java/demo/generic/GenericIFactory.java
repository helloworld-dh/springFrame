package demo.generic;

/**
 * @InterfaceName: GenericIFactory
 * @Description:
 * @Author: Du
 * @Date: 2022/6/16
 */
public interface GenericIFactory <T,N>{
    T nextObject();

    N nextNumber();
}
