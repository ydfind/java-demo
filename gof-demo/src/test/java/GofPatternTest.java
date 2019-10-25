import com.ydfind.gof.factory.*;
import com.ydfind.gof.factory.simple.Pizza;
import com.ydfind.gof.factory.simple.PizzaStore;
import com.ydfind.gof.factory.simple.SimplePizzaFactory;
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
        Pizza pizza;
        // 产品A1
        factory = new Factory1();
        pizza = factory.createProduct();
        pizza.prepare();
        // 产品A2
        factory = new Factory2();
        pizza = factory.createProduct();
        pizza.prepare();
    }

    /**
     * 简单工厂模式 测试：Pizza.java、CheesePizza.java、VeggiePizza.java、SimplePizzaFactory.java
     */
    @Test
    public void testSimpleFactory(){
        System.out.println("*********************简单工厂 测试********************************");
        PizzaStore pizzaStore = new PizzaStore();
        // pizza店制作两个pizza
        pizzaStore.orderPizza(SimplePizzaFactory.CHEESE_PIZZA);
        pizzaStore.orderPizza(SimplePizzaFactory.VEGGIE_PIZZA);
    }

}
