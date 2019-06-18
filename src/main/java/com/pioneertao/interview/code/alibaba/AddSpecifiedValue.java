package com.pioneertao.interview.code.alibaba;

public class AddSpecifiedValue {

    private static void getSumList(int[] a, int target,int index,boolean[] v) {
        if(index<0){
            return;
        }
        if(target==0){
            for (int i = 0; i < v.length; i++) {
                if(v[i]){
                    System.out.print(a[i]+",");
                }
            }
            System.out.println();
            return;
        }
        //简单的回溯法
        index--;
        v[index+1]=true;
        getSumList(a,target-a[index+1],index,v);
        v[index+1]=false;
        getSumList(a,target,index,v);
    }


    public static void main(String[] args) {
        int[] a = {10,9,8,7,6,5,4,3,2,1};
        boolean[] v = new boolean[a.length];
        for (int i = 0; i < v.length; i++) {
            v[i] =false;
        }

        int target = 10;
        //可以在这去掉数组中重复的值
        getSumList(a,target,a.length-1,v);
    }
}
