import com.ydfind.gof.factory.abstractfactory.BeijingPizzaStore2;
import com.ydfind.gof.factory.abstractfactory.PizzaStore2;
import com.ydfind.gof.factory.abstractfactory.ShangHaiPizzaStore2;
import com.ydfind.gof.factory.factorymethod.BeijingPizzaStore;
import com.ydfind.gof.factory.factorymethod.PizzaStore1;
import com.ydfind.gof.factory.factorymethod.ShangHaiPizzaStore;
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

    @Test
    public void testFactoryMethod(){
        System.out.println("*********************工厂方法 测试********************************");
        PizzaStore1 shanghaiStore = new ShangHaiPizzaStore();
        PizzaStore1 beijingStore = new BeijingPizzaStore();
        shanghaiStore.orderPizza(PizzaStore1.CHEESE_PIZZA);
        beijingStore.orderPizza(PizzaStore1.VEGGIE_PIZZA);
    }

    @Test
    public void testFactory(){
        System.out.println("*********************抽象工厂 测试********************************");
        PizzaStore2 shanghaiStore = new ShangHaiPizzaStore2();
        PizzaStore2 beijingStore = new BeijingPizzaStore2();
        shanghaiStore.orderPizza(PizzaStore2.CHEESE_PIZZA);
        beijingStore.orderPizza(PizzaStore2.VEGGIE_PIZZA);
    }
}
