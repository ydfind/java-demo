import java.net.InetAddress;

/**
 * IP类 试验
 * @author ydfind
 * @date 2019.10.12
 */
public class IpTest {

    private static final Integer IP_TIME = 3000;

    public static void main(String[] args) {
        String ip = "/127.0.0.1";
        boolean reachabled = isNodeReachable(ip);
        System.out.println("--------------------" + ip + "：" + reachabled);
        ip = "127.0.0.1";
        reachabled = isNodeReachable(ip);
        System.out.println("--------------------" + ip + "：" + reachabled);
    }

    public static final boolean isNodeReachable(String hostname) {
        try {
            InetAddress address = InetAddress.getByName(hostname);
            if (address.isReachable(IP_TIME)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
