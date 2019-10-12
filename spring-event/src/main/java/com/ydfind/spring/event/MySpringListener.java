package com.ydfind.spring.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
/**
 *
 * @author ydfind
 * @date 2019.10.12
 */
@Component
public class MySpringListener {
    @EventListener
    public void onAppCreationEvent(MySpringEvent event) {
        System.out.println("收到消息了：" + event.getSource().toString());
    }
}
