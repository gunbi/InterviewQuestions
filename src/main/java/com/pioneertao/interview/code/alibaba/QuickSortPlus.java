package com.pioneertao.interview.code.alibaba;

import java.util.Arrays;
import java.util.Random;

public class QuickSortPlus {


    public static void quickSortPlus(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low;
        int j = high;
        int key = getKeyindex(low, high);
        swap(a, low, key);
        while (i < j) {
            while (i < j && a[j] >= a[low]) j--;
            while (i < j && a[i] <= a[low]) i++;
            if (i < j) {
                swap(a, i, j);
            }
        }
        swap(a, i, low);
        quickSortPlus(a, low, i - 1);
        quickSortPlus(a, i + 1, high);
    }

    public static void quickSort_1(int[] data, int start, int end) {
        if (data == null || start < 0 || end > data.length - 1) {
            throw new IllegalArgumentException("Invalid Parameters");
        }
        if (start == end) return;
        int index = partition(data, start, end);
        if (index > start) {
            quickSort_1(data, start, index - 1);
        }
        if (index < end) {
            quickSort_1(data, index + 1, end);
        }
    }

    private static int partition(int[] data, int start, int end) {
        int index = start + (int) (Math.random() * (end - start + 1));
        swap(data, index, end);
        int small = start - 1;
        for (index = start; index < end; index++) {
            if (data[index] < data[end]) {
                small++;
                if (small != index) {
                    swap(data, index, small);
                }
            }
        }
        swap(data, small + 1, end);
        return small + 1;
    }

    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private static int getKeyindex(int low, int high) {
        if (high - low > 1) {
            int[] indexs = new int[3];
            int count = 0;
            while (count < 3) {
                Random r = new Random();
                int index = r.nextInt(high - low + 1) + low;
                boolean exits = false;
                for (int i = 0; i < count; i++) {
                    if (indexs[i] == index) {
                        exits = true;
                    }
                }
                if (!exits) {
                    indexs[count] = index;
                    count++;
                }
            }
            return getMid(indexs[0], indexs[1], indexs[2]);
        } else {
            return low;
        }
    }


    private static int getMid(int a, int b, int c) {
        return Math.max(a, b) > c ? (Math.max(Math.min(a, b), c)) : Math.min(Math.max(a, b), c);
    }


    public static void main(String[] args) {
        int[] a = {1, 23};
        quickSortPlus(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
