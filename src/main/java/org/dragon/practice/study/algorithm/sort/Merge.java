package org.dragon.practice.study.algorithm.sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Liuwl
 * Date: 2020/7/23
 **/
public class Merge {
    public static int[] sort(int[] a) {
        if (a.length <= 1) {
            return a;
        }
        int mid = a.length / 2;
        int[] left = Arrays.copyOf(a, mid);
        int[] right = Arrays.copyOfRange(a, mid, a.length);
        return merge(sort(left), sort(right));
    }

    public static int[] mergeSort(int[] a, int left, int right) {
        if (left >= right) {
            return a;
        }
        int mid = left + (right - left) / 2;
        a = mergeSort(a, left, mid);
        a = mergeSort(a, mid + 1, right);
        return merge(a, left, right, mid);
    }

    public static int[] merge(int[] a, int left, int right, int mid) {
        if (left >= right) {
            return a;
        }
        int[] res = new int[right - left + 1];
        int leftIndex = left;
        int rightIndex = mid + 1;
        for (int i = 0; i < res.length; i++) {
            if (leftIndex > mid) {
                res[i] = a[rightIndex++];
            } else if (rightIndex > right) {
                res[i] = a[leftIndex++];
            } else if (a[leftIndex] < a[rightIndex]) {
                res[i] = a[leftIndex++];
            } else {
                res[i] = a[rightIndex++];
            }
        }
        for (int i = 0; i < res.length; i++) {
            a[left + i] = res[i];
        }
        return a;
    }

    public static int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < res.length; i++) {
            if (leftIndex >= left.length) {
                res[i] = right[rightIndex++];
            } else if (rightIndex >= right.length) {
                res[i] = left[leftIndex++];
            } else if (left[leftIndex] < right[rightIndex]) {
                res[i] = left[leftIndex++];
            } else {
                res[i] = right[rightIndex++];
            }
        }
        return res;
    }
}
