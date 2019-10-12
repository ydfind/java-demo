import java.util.Arrays;
import java.util.Scanner;

/**
 * 路灯
 *
 * 题目描述:
   V先生有一天工作到很晚，回家的时候要穿过一条长l的笔直的街道，这条街道上有n个路灯。
   假设这条街起点为0，终点为l，第i个路灯坐标为ai。路灯发光能力以正数d来衡量，
   其中d表示路灯能够照亮的街道上的点与路灯的最远距离，所有路灯发光能力相同。
   为了让V先生看清回家的路，路灯必须照亮整条街道，又为了节省电力希望找到最小的d是多少？
 *
 * 输入
 * 输入两行数据，第一行是两个整数：路灯数目n (1≤n≤1000)，街道长度l (1 ≤l≤109)。第二行有n个整数ai (0 ≤ ai≤ l)，
 * 表示路灯坐标，多个路灯可以在同一个点，也可以安放在终点位置。
 *
 * 样例输入
   7 15
   15 5 3 7 9 14 0
 *
 * 输出
   输出能够照亮整个街道的最小d，保留两位小数。
 *
 * 样例输出
   2.50
 * @author ydfind
 * @date 2019.10.12
 */
public class MainFlipArray1 {

    private static void calc(int[] ai, int l){
        // 从小到大排序
        Arrays.sort(ai);
        // 计算两个值差的最大值
        // 街道两边没有路灯，故要乘以2
        int d = ai[0] * 2;
        int differ;
        for(int i = 0; i < ai.length - 1; i++){
            differ = ai[i + 1] - ai[i];
            if(differ > d){
                d = differ;
            }
        }
        int end = 2 * (l - ai[ai.length - 1]);
        if(end > d){
            d = end;
        }
        double res = d / 2.0;
        System.out.println(String.format("%.2f", res));
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int l = cin.nextInt();
        int[] ai = new int[n];
        for(int i = 0; i < n; i++){
            ai[i] = cin.nextInt();
        }
        calc(ai, l);
    }
}
