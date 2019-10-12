import java.util.Scanner;

/**
 * 题目描述
 *
 * 给定一个长度为n的整数数组a，元素均不相同，问数组是否存在这样一个片段，只将该片段翻转就可以使整个数组升序排列。其中数组片段[l,r]表示序列a[l], a[l+1], ..., a[r]。原始数组为
 * a[1], a[2], ..., a[l-2], a[l-1], a[l], a[l+1], ..., a[r-1], a[r], a[r+1], a[r+2], ..., a[n-1], a[n]，
 * 将片段[l,r]反序后的数组是
 * a[1], a[2], ..., a[l-2], a[l-1], a[r], a[r-1], ..., a[l+1], a[l], a[r+1], a[r+2], ..., a[n-1], a[n]。
 *
 * 输入
 * 第一行数据是一个整数：n (1≤n≤105)，表示数组长度。
 * 第二行数据是n个整数a[1], a[2], ..., a[n] (1≤a[i]≤109)。
 *
 * 输出“yes”，如果存在；否则输出“no”，不用输出引号。
 *
 * 样例输入
 * 4
 * 2 1 3 4
 *
 * 样例输出
 * yes
 * @author ydfind
 * @date 2019.10.12
 */
public class MainFlipArray2 {

    private static void calc(Integer[] nums){
        int start = nums.length - 1;
        int end = nums.length - 1;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] > nums[i + 1]){
                start = i;
                break;
            }
        }
        for(int i = start + 1; i < nums.length - 1; i++){
            if (nums[i] < nums[i + 1]){
                end = i;
                break;
            }
        }
        if(start < end){
            // 判断调换后，能否在连接点递增
            if(start > 0 && nums[start - 1] > nums[end]){
                System.out.println("no");
                return;
            }
            if(end < (nums.length - 1) && nums[start] > nums[end + 1]){
                System.out.println("no");
                return;
            }
            // 判断后面是否是递增
            for(int i = end + 1; i < nums.length - 1; i++){
                if(nums[i] > nums[i + 1]){
                    System.out.println("no");
                    return;
                }
            }
        }
        System.out.println("yes");
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextInt()){
            int n = cin.nextInt();
            Integer[] nums = new Integer[n];
            for(int i = 0; i < n; i++){
                nums[i] = cin.nextInt();
            }
            calc(nums);
        }
    }
}
