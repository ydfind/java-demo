import com.ydfind.excel.ExcelReadWrite;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;

@Slf4j
public class ExcelReadWriteTest {

    @Test
    public void testCopyExcel() throws IOException {
        String source = ExcelReadWriteTest.class.getClassLoader().getResource("source.xls").getFile();
        String target = ExcelReadWriteTest.class.getClassLoader().getResource("target.xls").getFile();
        ExcelReadWrite.copyExcel(source, target);
        log.info("打开 \".\\excel-demo\\target\\test-classes\\target.xls\", 查看是否复制成功！");
    }
}
