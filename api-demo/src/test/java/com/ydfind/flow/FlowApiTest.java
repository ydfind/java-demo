package com.ydfind.flow;

import com.ydfind.model.Employee;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;

/**
 * Flow api 测试
 * @author ydfind
 * @date 2019.10.15
 * https://blog.csdn.net/why_still_confused/article/details/82351960
 */
public class FlowApiTest {

    /**
     * 结果：
     * onSubscribe: Subscribed
     * onSubscribe: requested 1 item
     * main: Publishing Items to Subscriber
     * main: waiting response
     * onNext: Processing Employee Employee(id=1, name=Pankaj)
     * onNext: Processing Employee Employee(id=2, name=David)
     * onNext: Processing Employee Employee(id=3, name=Lisa)
     * onNext: Processing Employee Employee(id=4, name=Ram)
     * onNext: Processing Employee Employee(id=5, name=Anupam)
     * main: closer publisher
     * onComplete: All Processing Done
     *
     * 分析：publisher.submit触发onSubscribe是异步的
     * @throws InterruptedException
     */
    @Test
    public void testFlow() throws InterruptedException {

        // Create Publisher
        SubmissionPublisher<Employee> publisher = new SubmissionPublisher<>();

        // Register Subscriber
        FlowSubscriber subs = new FlowSubscriber();
        publisher.subscribe(subs);

        List<Employee> employeeList = EmployeeHelper.getEmps();

        System.out.println("main: Publishing Items to Subscriber");
        employeeList.stream().forEach(i -> publisher.submit(i));
        System.out.println("main: waiting response");

        while (employeeList.size() != subs.getCounter()) {
            Thread.sleep(10);
        }
        System.out.println("main: closer publisher");
        publisher.close();
    }
}
