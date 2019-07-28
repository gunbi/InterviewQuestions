package com.pioneertao.interview.code.bounded_buffer_problem;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;

/**
 * @program: Start
 * @description: TODO 启动生产者消费者模型
 * @author: hanzhong
 * @create: 2019-07-28 15:19
 **/
public class Start {

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(20);

        final Container container = new Container();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        Consumer consumer = new Consumer();
                        consumer.consumption(container);
                    }
                    countDownLatch.countDown();
                }
            });
            thread.start();
        }

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        Producer producer = new Producer();
                        producer.production(container);
                    }
                    countDownLatch.countDown();
                }
            });
            thread.start();
        }

        countDownLatch.await();

    }


}
