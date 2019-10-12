import java.util.Scanner;

/**
 * 题目描述:
 * https://exercise.acmcoder.com/online/online_judge_ques?ques_id=1654&konwledgeId=134
 *
 * 果园里有堆苹果，N（1＜N＜9）只熊来分。第一只熊把这堆苹果平均分为N份，多了一个，它把多的一个扔了，拿走了一份。
 * 第二只熊把剩下的苹果又平均分成N份，又多了一个，它同样把多的一个扔了，拿走了一份，第三、第四直到第N只熊都是这么做的，
 * 问果园里原来最少有多少个苹果？
 *
 * 输入：输入1个整数，表示熊的个数。它的值大于1并且小于9。
 * 输出：为1个数字，表示果园里原来有的苹果个数。
 * 样例输入：5
 * 样例输出：3121
 *
 * @author ydfind
 * @date 2019.08.06
 */
public class Main {

    public static final Integer TEST_LEN = 1000000;

    private static int calc(int n){
        int d = 0;
        int next = -1;
        while (++d < TEST_LEN && next <= 0){
            // 最后一次分剩下的数量必然是n的倍数加1
            next = d * n + 1;
            for(int i = 0; i < n - 1; i++){
                if(next % (n - 1) != 0) {
                    next = -1;
                    continue;
                }
                next = next / (n - 1) * n + 1;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextInt()) {
            int n = cin.nextInt();
            int count = calc(n);
            System.out.println(count);
        }
    }
}
