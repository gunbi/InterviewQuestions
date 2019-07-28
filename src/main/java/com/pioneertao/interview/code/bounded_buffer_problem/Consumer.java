package com.pioneertao.interview.code.bounded_buffer_problem;

/**
 * @program: Consumer
 * @description: TODO 消费者
 * @author: hanzhong
 * @create: 2019-07-28 15:19
 **/
public class Consumer {


    public void consumption(Container container){
        try {
            container.consumerCap();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
