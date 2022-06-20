package demo.pattern.eventmode;

import java.sql.SQLOutput;

/**
 * @ClassName: SingleClickEventListener
 * @Description:
 * @Author: Du
 * @Date: 2022/6/20
 */
public class SingleClickEventListener implements EventListener{
    @Override
    public void precessEvent(Event event) {
        if("singleClick".equals(event.getType())){
            System.out.println("单机被触发了");
        }
    }
}
