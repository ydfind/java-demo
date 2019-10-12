package com.ydfind.springboot.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ydfind
 * @date 2019.10.12
 */
@RestController
@RequestMapping("/user")
public class UserRegisterController {
    @Autowired
    private UserRegisterService userRegisterService;
    @RequestMapping("/register")
    public String register(User user) {
        //进行注册
        userRegisterService.register(user);
        return "[controller]注册用户成功！";

    }
}