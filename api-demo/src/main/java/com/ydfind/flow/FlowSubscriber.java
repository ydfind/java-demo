package com.ydfind.flow;

import com.ydfind.model.Employee;
import lombok.Getter;

import java.util.concurrent.Flow;

/**
 * Flow订阅者
 * @author ydfind
 * @date 2019.10.15
 */
public class FlowSubscriber implements Flow.Subscriber<Employee> {

    private Flow.Subscription subscription;

    @Getter
    private int counter = 0;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("onSubscribe: Subscribed");
        this.subscription = subscription;
        // requesting data from publisher
        this.subscription.request(1);
        System.out.println("onSubscribe: requested 1 item");
    }

    @Override
    public void onNext(Employee item) {
        System.out.println("onNext: Processing Employee "+item);
        counter++;
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("onError: Some error happened");
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("onComplete: All Processing Done");
    }
}
