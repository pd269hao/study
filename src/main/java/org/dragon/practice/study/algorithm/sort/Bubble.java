package org.dragon.practice.study.algorithm.sort;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Liuwl
 * Date: 2020/6/1
 **/
@Slf4j
public class Bubble {
    public static int[] sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = tmp;
                }
            }
            log.info("第{}趟结果：{}", i, JSON.toJSONString(a));
        }

        return a;
    }
}
