import com.ydfind.util.FileUtils;

import java.io.IOException;

/**
 * 加引号类 试验
 * @author ydfind
 * @date 2019.10.12
 */
public class MainTest {
    public static void main(String[] args) throws IOException {
        String str = FileUtils.readFile("D:/tmp/appnames.txt");

        String[] strs = str.split("\r\n");
        StringBuffer bf = new StringBuffer();
        for(String text: strs){
            bf.append("'").append(text).append("',");
        }
        bf.deleteCharAt(bf.length() - 1);
        System.out.println(bf.toString());
    }
}
