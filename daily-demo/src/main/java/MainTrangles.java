import java.util.Scanner;

class Side {

}

class Trangle {
    Integer[] sides;
    Double[] angles;
    Double area;
    Trangle(int a, int b, int c){
        this.sides = new Integer[3];
        this.sides[0] = a;
        this.sides[1] = b;
        this.sides[2] = c;
        angles = new Double[3];

        // 求角度
        angles[0] = Math.acos((sides[0] * sides[0] + sides[1] * sides[1] - sides[2] * sides[2]) / (2.0 * sides[0] * sides[1]));
        angles[1] = Math.acos((sides[1] * sides[1] + sides[2] * sides[2] - sides[0] * sides[0]) / (2.0 * sides[1] * sides[2]));
        angles[2] = Math.acos((sides[2] * sides[2] + sides[0] * sides[0] - sides[1] * sides[1]) / (2.0 * sides[2] * sides[0]));

        // 求面积
        int p = sides[0] + sides[1] + sides[2];
        area = Math.sqrt((p - sides[0] * 2) * (p - sides[1] * 2) * (p - sides[2] * 2) * p / 16.0);
    }
}

/**
 *
 * @author ydfind
 * @date 2019.10.12
 */
public class MainTrangles {

    private static Trangle readTrangle(Scanner cin){
        int a;
        int b;
        int c;
        a = cin.nextInt();
        b = cin.nextInt();
        c = cin.nextInt();
        Trangle trangle = new Trangle(a, b, c);
        return trangle;
    }
}
