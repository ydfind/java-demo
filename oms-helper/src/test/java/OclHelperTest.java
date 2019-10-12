import com.ydfind.oms.OclHelper;
import org.junit.Test;

import java.io.IOException;

public class OclHelperTest {

    @Test
    public void testProccessOcl() throws IOException {
        String path = "D:\\2019-06-21-bulkEditing\\baofu-oms";
        path = "D:\\YDProjectTask\\project-test\\dfpocl-test";
        OclHelper.proccessOcl(path);
    }
}
