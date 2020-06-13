package org.dragon.practice.study.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * 生成有效括号
 *
 * @Author: Liuwl
 * Date: 2020/6/13
 **/
public class GenerateParentheses {
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        Set<String> set = new HashSet<>();
        if (n <= 0) {
            result.add("");
            return result;
        }
        gen("", 0, 0, n);
        return result;
    }

    private void gen(String str, int left, int right, int n) {
        if (left == right && left == n) {
            result.add(str);
            return;
        }
        if (left < n) {
            gen(str + "(", left + 1, right, n);
        }

        if (right < n && right < left) {
            gen(str + ")", left, right+1, n);
        }
    }
}
