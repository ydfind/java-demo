package com.ydfind.springboot.event;

import org.springframework.context.ApplicationEvent;
/**
 *
 * @author ydfind
 * @date 2019.10.12
 */
public class UserRegisterEvent extends ApplicationEvent {
    private static final long serialVersionUID = -5481658020206295565L;
    private User user;

    /**
     * 谁发布的这个事件，souce就是谁（对象）
     * @param source
     * @param user
     */
    public UserRegisterEvent(Object source, User user) {
        super(source);
        this.user = user;
    }
    public User getUser() {
        return user;
    }

}
