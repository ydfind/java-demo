package com.ydfind.apollo;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Apollo Demo类
 * @author ydfind
 * @date 2019.10.12
 */
public class ApolloLocalFileDemo {
    private static final Logger logger = LoggerFactory.getLogger(ApolloLocalFileDemo.class);
    private static final String DEFAULT_VALUE = "undefined";
    private Config config;

    public ApolloLocalFileDemo() {
        config = ConfigService.getAppConfig();
    }

    private String getConfig(String key) {
        String result = config.getProperty(key, DEFAULT_VALUE);
        logger.info(String.format("Loading key : %s with value: %s", key, result));
        return result;
    }

    public static void main(String[] args){
        System.setProperty("apollo.cacheDir", "C:\\ydfind\\data");
        System.setProperty("env", "dev");
        System.setProperty("dev_meta", "http://a-config.baofoo.cn:18080/");
        ApolloLocalFileDemo apolloConfigDemo = new ApolloLocalFileDemo();
        apolloConfigDemo.getConfig("timeout");
        apolloConfigDemo.getConfig("credit.eureka.address");
    }
}