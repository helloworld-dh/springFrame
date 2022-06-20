package demo.pattern.eventmode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: EventSource
 * @Description:
 * @Author: Du
 * @Date: 2022/6/20
 */
public class EventSource {
    private List<EventListener> listenerList = new ArrayList<>();
    public void register(EventListener listener){
        listenerList.add(listener);
    }
    public void publishEvent(Event event){
        for (EventListener listener : listenerList) {
            listener.precessEvent(event);
        }
    }
}
