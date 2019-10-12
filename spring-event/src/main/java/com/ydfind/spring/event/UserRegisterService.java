package com.ydfind.spring.event;


import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 *
 * @author ydfind
 * @date 2019.10.12
 */
@Service
public class UserRegisterService implements ApplicationEventPublisherAware {

    public ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;

    }
}