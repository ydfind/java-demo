package com.ydfind.prjprocess;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class PrjCodeProcesserTest {


    public static void main(String[] args) throws IOException {
        // 原来：target
        String source = "D:\\YDProjectTask\\project-master20190930";
//        String source1 = "D:\\YDProjectIdea\\projectData-source-1";
//        String target = "D:\\projectData\\helloWorld-csv";
//        String target1 = "D:\\YDProjectIdea\\projectData-target-1";
        // 加密
        PrjCodeProcesser.encryptPrj(source, null);
//        // 解密
//        PrjCodeProcesser.decryptPrj(target, target + "1");
//        // 加密
//        PrjCodeProcesser.encryptPrj(source1, target1);
    }
}



