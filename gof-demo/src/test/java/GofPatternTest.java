import com.ydfind.gof.factory.Shape;
import com.ydfind.gof.factory.ShapeFactory;
import org.junit.Test;

/**
 * 23种设计模式测试类
 * @author ydfind
 * @date 2019.10.14
 */
public class GofPatternTest {

    /**
     * 工厂方法测试类
     */
    @Test
    public void testFactory(){
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape;
        // 简单工厂
        shape = shapeFactory.getShape(ShapeFactory.SHAPE_CIRCLE);
        shape.draw();
        shape = shapeFactory.getShape(ShapeFactory.SHAPE_RECTANGLE);
        shape.draw();
        // 多方法工厂
        shape = shapeFactory.getCircle();
        shape.draw();
        shape = shapeFactory.getRectangle();
        shape.draw();
        // 静态工厂
        shape = ShapeFactory.getStaticCircle();
        shape.draw();
        shape = ShapeFactory.getStaticRectangle();
        shape.draw();
    }

}
