package cn.su.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author SuZuQi
 * @title: DemoEvent
 * @projectName spring
 * @description: TODO
 * @date 2021/4/14
 */
public class DemoEvent extends ApplicationEvent {
    private String msg;

    public DemoEvent(Object source, String msg) {
        super(source);
        System.out.println(source);
        this.msg = msg;

    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
