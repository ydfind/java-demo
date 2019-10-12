package com.ydfind.oms;

import com.ydfind.util.FileUtils;

import java.io.IOException;
import java.util.List;
/**
 *
 * @author ydfind
 * @date 2019.10.12
 */
public class OclHelper {

    private static String CONTROLLER_FILE = "ComputeUtil.java";
    private static String CONFIG_FILE = "application.yml";

    public static void proccessOcl(String path) throws IOException {
        String file = FileUtils.findByFilename(path, CONTROLLER_FILE);
        List<String> list = FileUtils.readFileList(file, "utf-8");

        proccessController(list);
        FileUtils.writeFile(file, list);

        file = FileUtils.findByFilename(path, CONFIG_FILE);
        list = FileUtils.readFileList(file, "utf-8");
        for(int i = 0; i < list.size() - 1; i++){
            String str = list.get(i);
            if(str.indexOf("${credit.eureka.address}") >= 0){
                str = str.replace("${credit.eureka.address}", "http://10.254.206.188:1100/");
                list.set(i, str);
                break;
            }
        }
        FileUtils.writeFile(file, list);

        // 处理jdk
        CommonHelper.processJdk(path);
    }

    /**
     * java11改为java8，部分调用需要修改
     * @param list
     */
    public static void proccessController(List<String> list){
        for(int i = 0; i < list.size() - 1; i++){
            String str = list.get(i);
            if(str.indexOf("if (!CacheUtil.checkCountCacheName(countKey) || CacheUtil.getCount(countKey).getAcquire() > num) {") >= 0){
                str = str.replace(".getAcquire()", ".get()");
                list.set(i, str);
                break;
            }
        }
    }
}
