package com.ydfind.springboot.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 监听主程序类
 * @author ydfind
 * @date 2019.10.12
 */
@SpringBootApplication
@RestController
public class ListenerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ListenerApplication.class, args);
    }

    @RequestMapping("/")
    public String healthyCheck() {

        return "Ok";
    }
}
