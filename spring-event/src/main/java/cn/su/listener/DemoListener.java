package cn.su.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import cn.su.event.DemoEvent;

/**
 * @author SuZuQi
 * @title: DemoListener
 * @projectName spring
 * @description: TODO
 * @date 2021/4/14
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {
        String msg = demoEvent.getMsg();
        System.out.println("监听到demoEvent事件：" + msg);
    }
}
