import org.junit.Test;

public class MainTest {

    @Test
    public void mainTest(){
        int res = MainGameUpdate.maxDivisor(131, 51);
        System.out.println("the greatest common divisor(gcd) is " + res);

    }
}
