import com.ydfind.oms.OmsHelper;
import org.junit.Test;

import java.io.IOException;

public class OmsHelperTest {

    @Test
    public void testProcessOMS() throws IOException {
        String path;
        path = "D:\\YDProjectTask\\project-master20190930";
        OmsHelper.processOms(path);
    }

    @Test
    public void testProcessOmsPutDebug() throws IOException {
        String path;
        path = "D:\\YDProjectTask\\2019-09-11-XYKJ-2091-aesEncrypt\\oms-aes";
        OmsHelper.processOmsFeiYanDpcDebug(path);
    }

    @Test
    public void testProcessOmsAgent() throws IOException {
        String path;
        path = "D:\\YDProjectTask\\2019-09-11-XYKJ-2091-aesEncrypt\\oms-aes";
        OmsHelper.processOmsAgent(path);
    }

    @Test
    public void testProccessOmsAgentCache() throws IOException {
        String path;
        path = "D:\\YDProjectTask\\2019-09-11-XYKJ-2091-aesEncrypt\\oms-aes";
        OmsHelper.processOmsAgentCache(path);
    }
}
