package com.ydfind.daily;

/**
 * 输出结果是
 * A 10
 * B 32
 * C 33-----
 * D 35
 * @author ydfind
 * @date 2019.10.12
 */
public class TryFinally {
    public static void main(String[] args){
        int num = 10;
        System.out.println(test(num));
    }
    public static int test(int b){
        try{
            b += 10;
            // 执行return前，会执行finally内容
            return b + 2;
        }catch(RuntimeException e){

        }catch(Exception e2){

        }finally {
//            b += 10;
//            // 结果返回33，上面return b + 2;没有执行
//            return b + 3;
        }
        return b;
    }
}
