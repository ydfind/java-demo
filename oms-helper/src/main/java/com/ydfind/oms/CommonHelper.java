package com.ydfind.oms;

import com.ydfind.util.FileUtils;

import java.io.IOException;
import java.util.List;

/**
 * 公共类
 * @author ydfind
 * @date 2019.10.12
 */
public class CommonHelper {
    private static String POM_FILE = "pom.xml";

    public static void processJdk(String path) throws IOException {
        // 处理jdk问题
        String file = FileUtils.findFirstByFilename(path, POM_FILE);
        List<String> list = FileUtils.readFileList(file, "utf-8");
        String source = "<java.version>";
        String target = "    <java.version>1.8</java.version>\n" +
                "    <maven.compiler.source>1.8</maven.compiler.source>\n" +
                "    <maven.compiler.target>1.8</maven.compiler.target>";
        findAndReplaceRow(list, source, target);
        FileUtils.writeFile(file, list);
    }

    public static boolean findAndReplaceRow(List<String> list, String source, String target){
        for(int i = 0; i < list.size() - 1; i++){
            String str = list.get(i);
            if(str.indexOf(source) >= 0){
                list.set(i, target);
                return true;
            }
        }
        return false;
    }
}
