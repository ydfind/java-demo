import com.ydfind.util.ObjectUtils;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;

public class FileObjectTest {

    @Test
    public void testFileObjectReachable() throws IOException, ClassNotFoundException {
        String filename = "D://tmp/127.0.0.1-no.txt";
        InetAddress address = (InetAddress)ObjectUtils.readObjectFromFile(filename);
        if (address.isReachable(3000)) {
            System.out.println(filename + " is reachable");
        } else {
            System.out.println(filename + " is not reachable");
        }

        filename = "D://tmp/127.0.0.1-yes.txt";
        address = (InetAddress)ObjectUtils.readObjectFromFile(filename);
        if (address.isReachable(3000)) {
            System.out.println(filename + " is reachable");
        } else {
            System.out.println(filename + " is not reachable");
        }
    }
}
