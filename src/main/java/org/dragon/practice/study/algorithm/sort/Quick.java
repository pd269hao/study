package org.dragon.practice.study.algorithm.sort;

/**
 * Created with IntelliJ IDEA.
 * 快速排序
 *
 * @Author: Liuwl
 * Date: 2020/7/23
 **/
public class Quick {
    public static int[] sort(int[] a) {
        return quickSort(a, 0, a.length - 1);
    }

    public static int[] quickSort(int[] a, int left, int right) {
        if (left < right) {
            int pivot = partition(a, left, right);
            a = quickSort(a, left, pivot - 1);
            a = quickSort(a, pivot + 1, right);
        }
        return a;
    }

    public static int partition(int[] a, int left, int right) {
        int pivot = a[left];
        int i = left + 1;
        int j = right;
        while (true) {
            while (i <= j && a[i] <= pivot) {
                i++;
            }

            while (i <= j && a[j] >= pivot) {
                j--;
            }
            if (i >= j) {
                break;
            }
            int temp = a[j];
            a[j] = a[i];
            a[i] = temp;
        }

        a[left] = a[j];
        a[j] = pivot;
        return j;
    }
}
