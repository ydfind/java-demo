import com.ydfind.oms.CoreHelper;
import org.junit.Test;

import java.io.IOException;

public class CoreHelperTest {

    @Test
    public void testProccessCore() throws IOException {
        String path = "D:\\2019-06-21-bulkEditing\\baofu-oms";
        path = "D:\\YDProjectTask\\2019-07-26-appBatch\\device-core-appBatch";
        CoreHelper.proccessCore(path);
    }
}
