package com.ydfind.gof.factory;

/**
 * 图形工厂类
 * @author ydfind
 * @date 2019.10.14
 */
public class ShapeFactory {

    public static final String SHAPE_CIRCLE = "circle";

    public static final String SHAPE_RECTANGLE = "rectangle";

    /*******************************简单-工厂*********************************************/
    /**
     * 根据关键字创建对象
     */
    public Shape getShape(String shapeType){
        Shape shape;
        switch (shapeType){
            case SHAPE_CIRCLE:
                shape = new Circle();
                break;
            case SHAPE_RECTANGLE:
                shape = new Rectangle();
                break;
            default:
                shape = null;
        }
        return shape;
    }

    /*****************************多方法-工厂***********************************************/
    public Shape getCircle(){
        return new Circle();
    }

    public Shape getRectangle(){
        return new Rectangle();
    }

    /*****************************静态-工厂***********************************************/
    public static Shape getStaticCircle(){
        return new Circle();
    }

    public static Shape getStaticRectangle(){
        return new Rectangle();
    }
}
