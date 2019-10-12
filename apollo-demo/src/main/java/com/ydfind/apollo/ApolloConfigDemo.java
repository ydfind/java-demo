package com.ydfind.apollo;

import com.ctrip.framework.apollo.*;
import com.ctrip.framework.apollo.core.enums.ConfigFileFormat;
import com.ctrip.framework.apollo.internals.YamlConfigFile;
import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.model.ConfigFileChangeEvent;
import com.ctrip.framework.foundation.Foundation;
import com.google.common.base.Charsets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Apollo Demo类
 * @author ydfind
 * @date 2019.9.20
 */
public class ApolloConfigDemo {
  private static final Logger logger = LoggerFactory.getLogger(ApolloConfigDemo.class);
  private String DEFAULT_VALUE = "undefined";
  private Config config;
  private Config yamlConfig;
  private Config publicConfig;
  private ConfigFile applicationConfigFile;
  private ConfigFile xmlConfigFile;
  private YamlConfigFile yamlConfigFile;

  public ApolloConfigDemo() {
    ConfigChangeListener changeListener = new ConfigChangeListener() {
      @Override
      public void onChange(ConfigChangeEvent changeEvent) {
        logger.info("Changes for namespace {}", changeEvent.getNamespace());
        for (String key : changeEvent.changedKeys()) {
          ConfigChange change = changeEvent.getChange(key);
          logger.info("Change - key: {}, oldValue: {}, newValue: {}, changeType: {}",
              change.getPropertyName(), change.getOldValue(), change.getNewValue(),
              change.getChangeType());
        }
      }
    };
    config = ConfigService.getAppConfig();
    config.addChangeListener(changeListener);
    yamlConfig = ConfigService.getConfig("application.yaml");
    yamlConfig.addChangeListener(changeListener);
    publicConfig = ConfigService.getConfig("TEST1.apollo");
    publicConfig.addChangeListener(changeListener);
    applicationConfigFile = ConfigService.getConfigFile("application", ConfigFileFormat.Properties);
    // datasources.xml
    xmlConfigFile = ConfigService.getConfigFile("datasources", ConfigFileFormat.XML);
    xmlConfigFile.addChangeListener(new ConfigFileChangeListener() {
      @Override
      public void onChange(ConfigFileChangeEvent changeEvent) {
        logger.info(changeEvent.toString());
      }
    });
    // application.yaml
    yamlConfigFile = (YamlConfigFile) ConfigService.getConfigFile("application", ConfigFileFormat.YAML);
  }

  private String getConfig(String key) {
    String result = config.getProperty(key, DEFAULT_VALUE);
    if (DEFAULT_VALUE.equals(result)) {
      result = publicConfig.getProperty(key, DEFAULT_VALUE);
    }
    if (DEFAULT_VALUE.equals(result)) {
      result = yamlConfig.getProperty(key, DEFAULT_VALUE);
    }
    logger.info(String.format("Loading key : %s with value: %s", key, result));
    return result;
  }

  private void print(String namespace) {
    switch (namespace) {
      case "application":
        print(applicationConfigFile);
        break;
      case "xml":
        print(xmlConfigFile);
        break;
      case "yaml":
        printYaml(yamlConfigFile);
        break;
       default:
         print("error!");
    }
  }

  private void print(ConfigFile configFile) {
    if (!configFile.hasContent()) {
      System.out.println("No config file content found for " + configFile.getNamespace());
      return;
    }
    System.out.println("=== Config File Content for " + configFile.getNamespace() + " is as follows: ");
    System.out.println(configFile.getContent());
  }

  private void printYaml(YamlConfigFile configFile) {
    System.out.println("=== Properties for " + configFile.getNamespace() + " is as follows: ");
    System.out.println(configFile.asProperties());
  }

  private void printEnvInfo() {
    String message = String.format("AppId: %s, Env: %s, DC: %s, IP: %s", Foundation.app()
        .getAppId(), Foundation.server().getEnvType(), Foundation.server().getDataCenter(),
        Foundation.net().getHostAddress());
    System.out.println(message);
  }

  private static final String CMD_APPLICATION = "application";

  private static final String CMD_QUIT = "quit";

  private static final String CMD_XML = "xml";

  public static void main(String[] args) throws IOException {
    ApolloConfigDemo apolloConfigDemo = new ApolloConfigDemo();
    apolloConfigDemo.printEnvInfo();
    System.out.println(
        "Apollo Config Demo. Please input key to get the value.");
    while (true) {
      System.out.print("> ");
      String input = new BufferedReader(new InputStreamReader(System.in, Charsets.UTF_8)).readLine();
      if (input == null || input.length() == 0) {
        continue;
      }
      input = input.trim();
      try {
        if (input.equalsIgnoreCase(CMD_APPLICATION)) {
          apolloConfigDemo.print(CMD_APPLICATION);
          continue;
        }
        if (input.equalsIgnoreCase(CMD_XML)) {
          apolloConfigDemo.print(CMD_XML);
          continue;
        }
        if (input.equalsIgnoreCase(CMD_QUIT)) {
          System.exit(0);
        }
        apolloConfigDemo.getConfig(input);
      } catch (Throwable ex) {
        logger.error("some error occurred", ex);
      }
    }
  }
}
