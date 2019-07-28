package com.pioneertao.interview.code.bounded_buffer_problem;

/**
 * @program: Producer
 * @description: TODO 生产者
 * @author: hanzhong
 * @create: 2019-07-28 15:17
 **/
public class Producer {


    public void production(Container container){
        try {
            container.addCap();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
