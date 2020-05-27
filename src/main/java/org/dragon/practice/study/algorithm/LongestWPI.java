package org.dragon.practice.study.algorithm;

/**
 * Created with IntelliJ IDEA.
 * 查找最长高效工时天数
 *
 * @Author: Liuwl
 * Date: 2020/5/21
 **/
public class LongestWPI {
    public int longestWPI(int[] hours) {

        int[] temp = new int[hours.length];

        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 8) {
                temp[i] = 1;
            } else {
                temp[i] = -1;
            }
        }

        int max = 0;
        for (int i = 0; i < hours.length; i++) {
            int p = 0;
            int[] wpiLength = new int[hours.length];
            for (int j = i; j < hours.length; j++) {
                p += temp[j];

                if (p > 0) {
                    if (j == 0) {
                        wpiLength[j] = 1;
                    } else {
                        wpiLength[j] = j - i + 1;
                    }
                } else {
                    if (j == 0) {
                        wpiLength[j] = 0;
                    } else {
                        wpiLength[j] = wpiLength[j - 1];
                    }
                }
                if (wpiLength[j] > max) {
                    max = wpiLength[j];
                }
            }
        }

        return max;
    }
}
