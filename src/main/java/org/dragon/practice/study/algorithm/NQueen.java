package org.dragon.practice.study.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Liuwl
 * Date: 2020/6/20
 **/
public class NQueen {
    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }

        List<List<String>> result = new ArrayList<>();
        helper(n, 0, new HashSet<>(), new HashSet<>(),
                new HashSet<>(), new ArrayList<>(), result);
        return result;
    }


    private void helper(int n, int row, Set<Integer> cols, Set<Integer> sum,
                        Set<Integer> diff, List<String> line,
                        List<List<String>> result) {
        if (row == n) {
            List<String> s = new ArrayList<>();
            s.addAll(line);
            result.add(s);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!cols.contains(i)
                    && !sum.contains(i + row)
                    && !diff.contains(i - row)) {
                cols.add(i);
                sum.add(i + row);
                diff.add(i - row);
                String s = "";
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        s += ".";
                    } else {
                        s += "Q";
                    }
                }
                line.add(s);
                helper(n, row + 1, cols, sum, diff, line, result);
                cols.remove(i);
                sum.remove(i + row);
                diff.remove(i - row);
                line.remove(s);
            }
        }
    }

    Integer count = 0;

    public int totalNQueens(int n) {
        if (n < 1) {
            return 0;
        }
        // 初始所有位置都可放置Q
        helper(n, 0, 0, 0, 0);
        return count;
    }

    private void helper(int n, int row, Set<Integer> cols, Set<Integer> sum,
                        Set<Integer> diff) {
        if (row == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!cols.contains(i)
                    && !sum.contains(i + row)
                    && !diff.contains(i - row)) {
                cols.add(i);
                sum.add(i + row);
                diff.add(i - row);

                helper(n, row + 1, cols, sum, diff);
                cols.remove(i);
                sum.remove(i + row);
                diff.remove(i - row);
            }
        }
    }

    private void helper(int n, int row, int cols, int pie, int na) {
        if (row == n) {
            // 如果row已经扫描完，则计数
            count++;
            return;
        }
        /**
         * cols|pie|na, 三者相或，结果中的0表示不会被攻击的位置
         * 取反则1表示不会被攻击的位置
         * (1<<n) -1 表示右n位全1。
         * 与左侧结果相与目的是去掉左侧所有值，即如果pie已经超出格子，则不会影响结果。
         */
        int bit = (~(cols | pie | na)) & ((1 << n) - 1);

        // bit>0 表示有可以防止的位置
        while (bit > 0) {
            /**
             * 取出bit最右侧为1的位
             * bit为正数，二进制为原码
             * -bit为负数，二进制为补码形式，即bit取反+1，最右侧从最低位的1开始都是相同的
             * 两者相与刚好把最低位的1以及其左侧数值取出来
             */
            int p = bit & -bit;
            /**
             * 进入下一层判断
             * 把p这个位置加到cols上面
             * 把p这个位置加到pie上面，由于每下一层pie会往左移动，所以要左移1位
             * 把p这个位置加到na上面，由于每下一层na都会往右移动，所以要右移1位
             */
            helper(n, row + 1, cols | p,
                    (pie | p) << 1, (na | p) >> 1);

            // 将最地位的1打掉
            bit = bit & (bit - 1);
        }


    }
}
