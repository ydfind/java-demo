package com.ydfind.springboot.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 事件监听类
 * @author ydfind
 * @date 2019.10.12
 */
@Component
public class EventListener implements ApplicationListener<UserRegisterEvent> {

    @Override
    public void onApplicationEvent(UserRegisterEvent event) {

        //发邮件
        System.out.println("正在发送邮件至： " + event.getUser().getEmail());

        //发短信
        System.out.println("正在发短信到： " + event.getUser().getPhoneNum());
    }
}
