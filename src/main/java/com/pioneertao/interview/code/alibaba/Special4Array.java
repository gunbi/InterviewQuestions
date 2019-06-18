package com.pioneertao.interview.code.alibaba;

public class Special4Array {

    public static void getTwo(){
        int[] a = {1, 2, 3, 4, 6, 7, 9, 10, 9, 7, 6, 4, 3, 2, 1, 11};
        int result = 0;
        for (int i : a) {
            result ^= i;
        }
        int index = 0;
        for (int i = 0; i < 32; i++) {
            if (((result >> i) & 1) == 1) {
                index = i;
                break;
            }
        }
        int[] a1 = new int[a.length];
        int[] a2 = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (((a[i] >> index) & 1) == 1) {
                a1[i] = a[i];
            }
            if (((a[i] >> index) & 1) == 0) {
                a2[i] = a[i];
            }
        }
        int result1 = 0;
        for (int i : a1) {
            result1 ^= i;
        }
        System.out.println(result1);
        int result2 = 0;
        for (int i : a2) {
            result2 ^= i;
        }
        System.out.println(result2);
    }
}
