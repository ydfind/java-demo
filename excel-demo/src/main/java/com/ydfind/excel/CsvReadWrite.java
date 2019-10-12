package com.ydfind.excel;

import com.ydfind.util.FileUtils;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * csv读写
 * @author ydfind
 * @date 2019.10.12
 */
public class CsvReadWrite {

    public static final String APP_TYPE_APP_SEPERATOR = "\\r?\\n";
    public static final Character C_BLANK = ' ';
    public static final String ENCODING_UTF8 = "UTF-8";

    public static void main(String[] args) throws IOException {
        String fileContent = FileUtils.readFile("D:\\任务\\【2019-07-17】android应用优化\\应用分类表导出-空和乱码库-18号的.csv");
        String[] lines = fileContent.split(APP_TYPE_APP_SEPERATOR);

        // 将字符 C2A0、制表符、换行、回车去掉
        byte[] bytes = {(byte) 0xC2,(byte) 0xA0};
        String utfSpace = new String(bytes,ENCODING_UTF8);
        Pattern p = Pattern.compile("\t|\r|\n|" + utfSpace);
        Matcher m = null;
        for(int i = 0; i < lines.length; i++){
            String line = lines[i];
            m = p.matcher(line);
            line = m.replaceAll("");
            lines[i] = line;
        }
        FileUtils.writeFile("D:\\任务\\【2019-07-17】android应用优化\\应用分类表导出-空和乱码库-18号的-处理后7.csv", lines);
    }

    public static String trim(String value) {

        char nbsp = 0x00a0;


        int len = value.length();
        int st = 0;
        /* avoid getfield opcode */
        char[] val = value.toCharArray();

        while ((st < len) && (val[st] <= C_BLANK || val[st] == nbsp)) {
            st++;
        }
        while ((st < len) && (val[len - 1] <= C_BLANK || val[st] == nbsp)) {
            len--;
        }
        return ((st > 0) || (len < value.length())) ? value.substring(st, len) : value;
    }
}
