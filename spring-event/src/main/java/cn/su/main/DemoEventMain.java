package cn.su.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.su.pulisher.DemoPulisher;

/**
 * @author SuZuQi
 * @title: DemoEventMain
 * @projectName spring
 * @description: TODO
 * @date 2021/4/14
 */
public class DemoEventMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("cn.su");
        DemoPulisher demoPulisher = context.getBean(DemoPulisher.class);
        demoPulisher.pushEvent("你好，世界", "Hello World!!!");
    }

}
