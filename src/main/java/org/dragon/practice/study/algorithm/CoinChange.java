package org.dragon.practice.study.algorithm;

/**
 * Created with IntelliJ IDEA.
 * 兑换零钱，有一些零钱面额，每种面额数量不限
 * 给定一个总零钱数，找出最少数量的零钱数，使面值相等
 * <p>
 * dp[i] 兑换金额为i所需要的最小零钱数量
 *
 * @Author: Liuwl
 * Date: 2020/7/17
 **/
public class CoinChange {
    public static int coinChange(int[] coins, int amount) {

        Integer[] dp = new Integer[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            Integer min = null;
            for (int j = 0; j < coins.length; j++) {
                int ind = i - coins[j];
                if (ind >= 0 && dp[ind] != null) {
                    if (min == null) {
                        min = dp[ind];
                    } else if (min > dp[ind]) {
                        min = dp[ind];
                    }
                }
            }
            if (min != null) {
                dp[i] = min + 1;
            }
        }

        return dp[amount] == null ? -1 : dp[amount];
    }

    /**
     * 兑换指定金额的所有兑换方式数量
     *
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange1(int[] coins, int amount) {
        return 0;
    }
}
