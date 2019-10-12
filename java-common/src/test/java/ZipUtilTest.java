import com.ydfind.util.FileUtils;
import com.ydfind.util.ZipUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import static com.ydfind.util.ZipUtil.readZipByInputStream;


/**
 * Zip类 测试
 * @author ydfind
 * @date 2019.10.12
 */
@Slf4j
public class ZipUtilTest {

    @Test
    public void testFindByFilename() throws IOException {
        String filename = "D:\\tmp\\mytest.zip";
        String path = "D:\\tmp";
        // 法一：解压文件
        ZipUtil.unZip(filename, path + "\\法1\\");
        // 法二：先读到内存，再统一保存
        InputStream inputStream = new FileInputStream(filename);
        Map<String, String> map = null;
        try {
            map = readZipByInputStream(inputStream);
        }finally {
            try{
                inputStream.close();
            }catch (Exception e){
                log.warn("close FileInputStream exception", e);
            }
        }
        if(map != null) {
            for (String name : map.keySet()) {
                log.info("法二：写入文件 = {}", path + "\\法2\\" + name);
                if(FileUtils.isDirEnd(name)){
                    FileUtils.createDirIfNotExist(path + "\\法2\\" + name);
                }else {
                    FileUtils.writeFile(path + "\\法2\\" + name, map.get(name));
                }
            }
        }
    }
}
