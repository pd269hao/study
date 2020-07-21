package org.dragon.practice.study.algorithm;

/**
 * Created with IntelliJ IDEA.
 * 最短编辑距离
 *
 * @Author: Liuwl
 * Date: 2020/7/20
 **/
public class EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1.equals(word2)) {
            return 0;
        }
        //dp[i][j]表示源串A位置0...i到目标串B位置0...j处最低需要操作的次数
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // 初始化A[0..i]变成空字符串需要的操作数
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        // 初始化B[0..j]变成空字符串需要的操作数
        for (int j = 1; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j],
                            Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];

    }
}
