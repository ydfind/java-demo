import com.ydfind.down.HttpDownExample;
import org.junit.Test;

public class HttpDownExampleTest {

    @Test
    public void testDownByHttp() throws Exception {
        HttpDownExample.downByHttp("https://faculty.ecnu.edu.cn/s/2792/main.jspy");

    }
}
