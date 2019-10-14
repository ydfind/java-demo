import com.ydfind.gof.factory.*;
import org.junit.Test;

/**
 * 23种设计模式测试类
 * @author ydfind
 * @date 2019.10.14
 */
public class GofPatternTest {

    /**
     * 工厂模式 测试
     */
    @Test
    public void testFactory(){
        System.out.println("*********************工厂模式 测试********************************");
        Factory factory;
        Product product;
        // 产品A1
        factory = new Factory1();
        product = factory.createProduct();
        product.productMethod();
        // 产品A2
        factory = new Factory2();
        product = factory.createProduct();
        product.productMethod();
    }

    /**
     * 简单工厂模式 测试
     */
    @Test
    public void testSimpleFactory(){
        System.out.println("*********************简单工厂模式 测试********************************");
        SimpleFactory simpleFactory = new SimpleFactory();
        Product product;
        // 简单工厂
        product = simpleFactory.createProduct(SimpleFactory.PRODUCT_1);
        product.productMethod();
        product = simpleFactory.createProduct(SimpleFactory.PRODUCT_2);
        product.productMethod();
        // 多方法工厂
        product = simpleFactory.createProduct1();
        product.productMethod();
        product = simpleFactory.createProduct2();
        product.productMethod();
        // 静态工厂
        product = simpleFactory.createStaticProduct1();
        product.productMethod();
        product = simpleFactory.createStaticProduct2();
        product.productMethod();
    }

}
