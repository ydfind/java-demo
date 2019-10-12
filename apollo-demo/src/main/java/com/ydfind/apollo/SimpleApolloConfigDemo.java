package com.ydfind.apollo;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.google.common.base.Charsets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Apollo简单Demo类
 * @author ydfind
 * @date 2019.9.20
 */
public class SimpleApolloConfigDemo {
    private static final Logger logger = LoggerFactory.getLogger(SimpleApolloConfigDemo.class);
    private static final String DEFAULT_VALUE = "undefined";
    private Config config;

    public SimpleApolloConfigDemo() {
        config = ConfigService.getAppConfig();
    }

    private String getConfig(String key) {
        String result = config.getProperty(key, DEFAULT_VALUE);
        logger.info(String.format("Loading key : %s with value: %s", key, result));
        return result;
    }

    private static final String CMD_XML = "xml";
    private static final String CMD_QUIT = "quit";
    public static void main(String[] args) throws IOException {
        SimpleApolloConfigDemo apolloConfigDemo = new SimpleApolloConfigDemo();
        System.out.println(
                "Apollo Config Demo. Please input key to get the value. Input quit to exit.");
        while (true) {
            System.out.print("> ");
            String input = new BufferedReader(new InputStreamReader(System.in, Charsets.UTF_8)).readLine();
            if (input == null || input.length() == 0) {
                continue;
            }
            input = input.trim();
            if (input.equalsIgnoreCase(CMD_QUIT)) {
                System.exit(0);
            }
            apolloConfigDemo.getConfig(input);
        }
    }
}
