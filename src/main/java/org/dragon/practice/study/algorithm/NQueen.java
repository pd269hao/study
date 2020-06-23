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
        helper(n, 0, new HashSet<>(), new HashSet<>(), new HashSet<>());
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
}
