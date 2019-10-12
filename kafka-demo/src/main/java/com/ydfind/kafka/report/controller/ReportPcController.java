package com.ydfind.kafka.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ydfind.kafka.report.config.Constants;
import com.ydfind.kafka.report.model.ReportData;

import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author ydfind
 * @date 2019.10.12
 */
@Controller
@RequestMapping(("/report/pc/"))
public class ReportPcController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping(value = "pageView", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> pageView(@RequestBody ReportData data) {
        kafkaTemplate.send(Constants.TOPIC_PAGE, data.toString());

        Map<String, Object> result = new HashMap<>(8);
        result.put("success", true);
        result.put("data", "页面数据上报成功");
        return result;
    }

    @RequestMapping(value = "click", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> click(@RequestBody ReportData data) {
        kafkaTemplate.send(Constants.TOPIC_CLICK, data.toString());

        Map<String, Object> result = new HashMap<>(8);
        result.put("success", true);
        result.put("data", "页面数据上报成功");
        return result;
    }
}
