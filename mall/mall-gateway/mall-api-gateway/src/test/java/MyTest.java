import com.gupaoedu.vip.mall.cart.model.Permission;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

/**
 * @ClassName: MyTest
 * @Description:
 * @Author: Du
 * @Date: 2022/5/28
 */
public class MyTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test1(){
        List<Permission> permissionMatch0 = (List<Permission>) redisTemplate.boundHashOps("RolePermissionAll").get("PermissionListMatch0");
        for (Permission permission : permissionMatch0) {
            System.out.println("=========================");
            System.out.println(permission);
        }
    }

}
