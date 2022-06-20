package demo.pattern.eventmode;

/**
 * @ClassName: DoubleClickEventListener
 * @Description:
 * @Author: Du
 * @Date: 2022/6/20
 */
public class DoubleClickEventListener implements EventListener{
    @Override
    public void precessEvent(Event event) {
        if("doubleclick".equals(event.getType())){
            System.out.println("双击被触发了");
        }
    }
}
