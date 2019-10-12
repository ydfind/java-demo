import com.ydfind.util.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 文件类 测试
 * @author ydfind
 * @date 2019.10.12
 */
@Slf4j
public class FileUtilTest {

    @Test
    public void testFindByFilename(){
        String findFilename = FileUtils.findByFilename("D:\\2019-06-21-bulkEditing\\baofu-oms", "src\\main\\java\\com\\baofu\\oms\\web\\controller\\costcenter\\AccountReceiptController.java");
        String targetFilename = "D:\\2019-06-21-bulkEditing\\baofu-oms\\oms-web\\src\\main\\java\\com\\baofu\\oms\\web\\controller\\costcenter\\AccountReceiptController.java";
        log.info("---1--{}", findFilename);
        log.info("---2--{}", targetFilename);
    }
}
