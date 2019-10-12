import org.junit.Test;


/**
 * 枚举类 测试
 * @author ydfind
 * @date 2019.10.12
 */
public class OrderStatusEnumTest {
    @Test
    public void testValue(){
        System.out.println(OclOrderStatusEnum.SUCCESS.getMsg() + "," + OclOrderStatusEnum.SUCCESS.getCode());
        System.out.println(OclOrderStatusEnum.FAIL.getMsg() + "," + OclOrderStatusEnum.FAIL.getCode());
        System.out.println(OclOrderStatusEnum.INITAL.getMsg() + "," + OclOrderStatusEnum.INITAL.getCode());
        System.out.println(OclOrderStatusEnum.CHANNEL.getMsg() + "," + OclOrderStatusEnum.CHANNEL.getCode());
        System.out.println(OclOrderStatusEnum.CACHE.getMsg() + "," + OclOrderStatusEnum.CACHE.getCode());
    }
}
