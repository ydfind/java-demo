package com.ydfind.spring.event;

import org.springframework.context.ApplicationEvent;
/**
 *
 * @author ydfind
 * @date 2019.10.12
 */
public class MySpringEvent extends ApplicationEvent {
    public MySpringEvent(Object source) {
        super(source);
    }
//    public static void main(String[] args) {
//        //base class with Blog field - no need to extend `ApplicationEvent`
//        class BaseBlogEvent {}
//        class BlogModifiedEvent extends BaseBlogEvent {}
//        //somewhere in the code
//        ApplicationEventPublisher publisher = (...);    //injected
//        publisher.publishEvent(new BlogModifiedEvent(blog)); //just plain instance of the event
//    }
}
