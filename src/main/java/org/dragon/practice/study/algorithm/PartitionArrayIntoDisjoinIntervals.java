package org.dragon.practice.study.algorithm;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Liuwl
 * Date: 2020/5/21
 **/
public class PartitionArrayIntoDisjoinIntervals {
    public int partitionDisjoint(int[] A) {
        int index = 0;
        int leftMax = A[0];
        int tempLeftMax = A[0];
        int i = 1;
        while (index < A.length && i < A.length) {
            if (leftMax <= A[i]) {
                if (tempLeftMax < A[i]) {
                    tempLeftMax = A[i];
                }
                i++;
            } else {
                index = i;
                i++;
                leftMax = tempLeftMax;
            }
        }
        return index + 1;
    }
}
