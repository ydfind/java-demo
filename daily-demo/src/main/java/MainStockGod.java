import java.util.Scanner;
/**
 * 有股神吗？
 *
 * 有，小赛就是！
 *
 * 经过严密的计算，小赛买了一支股票，他知道从他买股票的那天开始，股票会有以下变化：第一天不变，以后涨一天，跌一天，涨两天，跌一天，涨三天，跌一天...依此类推。
 *
 * 为方便计算，假设每次涨和跌皆为1，股票初始单价也为1，请计算买股票的第n天每股股票值多少钱？
 * @author ydfind
 * @date 2019.10.12
 */
public class MainStockGod {

    public static int calc(int day){
        // 第一天，value为1
        int total = 1;
        int index = 1;
        int value = 1;
        total += ++index;
        while (total <= day){
            // 处理当前value
            value += index - 2;

            total += ++index;
        }
        int res = day - (total - index);
        value += res;
        return value;
    }

    public static void main(String[] args)
    {
        Scanner cin = new Scanner(System.in);
        int a, b;
        while(cin.hasNextInt())
        {
            a = cin.nextInt();
            b = calc(a);
            System.out.println(b);
        }
    }
}
