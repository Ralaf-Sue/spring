package cn.su.pulisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import cn.su.event.DemoEvent;

/**
 * @author SuZuQi
 * @title: DemoPulisher
 * @projectName spring
 * @description: TODO
 * @date 2021/4/14
 */
@Component
public class DemoPulisher {

    @Autowired
    private ApplicationContext context;

    public void pushEvent(String object, String msg) {
        context.publishEvent(new DemoEvent(object, msg));
    }

}
