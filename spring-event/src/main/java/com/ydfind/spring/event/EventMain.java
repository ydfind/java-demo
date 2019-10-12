package com.ydfind.spring.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * 事件主类
 * @author ydfind
 * @date 2019.10.12
 */
@Service
public class EventMain {

    @Autowired
    private static EventMain eventMain;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        EventEntity event = new EventEntity();
        event.setId(10);
        event.setName("my event");
//        EventMain eventMain = new EventMain();
        System.out.println("就要发送--------------------------");
        eventMain.applicationEventPublisher.publishEvent(event);
        System.out.println("已发送--------------------------");
//        publisher.publishEvent(event);
    }

//    private final ApplicationEventPublisher publisher;
}
