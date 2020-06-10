package org.dragon.practice.study.algorithm;

/**
 * Created with IntelliJ IDEA.
 * 字符串A最少操作几次变成字符串B
 * <p>
 * int[][] dp= new int[a.length][b.length]
 * <p>
 * dp[i][j] 表示从a[0..i]变成b[0...j]最少的操作次数
 * <p>
 * 假设 a[i]!=b[j],变换方式有  从a[0...i]变成b[0...j]
 * 1. dp[i-1][j-1], a[i]替换为b[j]
 * 2. dp[i-1][j], 将a[i]删除；
 * 3. dp[i][j-1]，在a[i]后增加b[j]
 * <p>
 * 假设a[i]==b[j],不用操作，操作数 = dp[i-1][j-1]
 *
 * @Author: Liuwl
 * Date: 2020/6/1
 **/
public class StringDiff {
    public static int getResult(String A, String B) {
        if (A.equals(B)) {
            return 0;
        }
        //dp[i][j]表示源串A位置i到目标串B位置j处最低需要操作的次数
        int[][] dp = new int[A.length() + 1][B.length() + 1];
        for (int i = 1; i <= A.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= B.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1,
                            Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
                }
            }
        }
        return dp[A.length()][B.length()];
    }

    public static int getDistance(String A, String B) {
        if (A.equals(B)) {
            return 0;
        }
        //dp[i][j]表示源串A位置0...i到目标串B位置0...j处最低需要操作的次数
        int[][] dp = new int[A.length() + 1][B.length() + 1];
        // 初始化A[0..i]变成空字符串需要的操作数
        for (int i = 1; i <= A.length(); i++) {
            dp[i][0] = i;
        }
        // 初始化B[0..j]变成空字符串需要的操作数
        for (int j = 1; j <= B.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j],
                            Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[A.length()][B.length()];
    }
}
