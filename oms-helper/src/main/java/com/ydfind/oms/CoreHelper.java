package com.ydfind.oms;

import com.ydfind.util.FileUtils;

import java.io.IOException;
import java.util.List;
/**
 * Core帮助类
 * @author ydfind
 * @date 2019.10.12
 */
public class CoreHelper {

    private static String CONFIG_FILE = "application.yml";

    public static void proccessCore(String path) throws IOException {
        String file = FileUtils.findByFilename(path, CONFIG_FILE);
        List<String> list = FileUtils.readFileList(file, "utf-8");
        for(int i = 0; i < list.size() - 1; i++){
            String str = list.get(i);
            if(str.indexOf("${credit.eureka.address}") >= 0){
                str = str.replace("${credit.eureka.address}", "http://10.254.206.188:1100/");
                list.set(i, str);
                break;
            }
        }
        FileUtils.writeFile(file, list);
    }
}
