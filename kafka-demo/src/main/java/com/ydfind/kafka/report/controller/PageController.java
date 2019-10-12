package com.ydfind.kafka.report.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author ydfind
 * @date 2019.10.12
 */
@Controller(value = "/")
public class PageController {

    @RequestMapping(value = "hello")
    public ModelAndView hello() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("report-user-activity");
        return mv;
    }
}
