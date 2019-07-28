package com.pioneertao.interview.code.bounded_buffer_problem;

/**
 * @program: Container
 * @description: TODO 容器类
 * @author: hanzhong
 * @create: 2019-07-28 15:19
 **/
public class Container {

    private volatile int cap = 5;

    public void addCap() throws InterruptedException {
        synchronized (this){
            if(cap>=5){
                System.out.println("生产者等待");
                wait();
                System.out.println("生产者被唤醒");
            }else{
                cap++;
                notifyAll();
                System.out.println("生产一个产品，当前容量:"+cap);
            }
        }
    }

    public void consumerCap() throws InterruptedException {
        synchronized (this){
            if(cap<=0){
                System.out.println("消费者等待");
                wait();
                System.out.println("消费者被唤醒");
            }else{
                cap--;
                notifyAll();
                System.out.println("消费一个产品，当前容量:"+cap);
            }
        }
    }

    public int getCap(){
        return cap;
    }
}
