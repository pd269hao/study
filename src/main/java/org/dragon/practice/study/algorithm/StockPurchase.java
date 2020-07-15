package org.dragon.practice.study.algorithm;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Liuwl
 * Date: 2020/6/30
 **/
public class StockPurchase {
    /**
     * 买卖一次
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }

        }
        return maxProfit;
    }

    /**
     * 买卖多次
     * 贪心算法，只要有收益就买卖一次
     *
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    /**
     * 限制交易次数
     *
     * @param prices
     * @param k
     * @return
     */
    public static int maxProfitLimitTradeTime(int[] prices, int k) {
        if (prices.length < 1 || k < 1) {
            return 0;
        }
        // 定义状态转移方程dp--maxProfit--mp,第i天的最高收益
        // 每天的状态可以是持有股票或者未持有股票，所以需要增加是否持有股票的维度
        // 限制交易次数，所以需要增加一个维度表示当前的交易次数
        // mp[i][j][0/1] 表示第i天，交易了j次，当前未持有/持有股票时的最大收益

        Integer[][][] mp = new Integer[prices.length][2 * k + 1][2];
        mp[0][0][0] = 0;
        mp[0][1][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < 2 * k + 1; j++) {
                // 当天未持仓，且交易j次，j-单数表示买入，双数表示卖出
                // 第i天，没有股票，则分两种情况。上一天没有持仓，当天没有买入；上一天有持仓，当天卖出了。
                if (j % 2 == 1) {
                    // j 是奇数，当天有持仓.j-1是偶数，没有持仓
                    if (mp[i - 1][j][1] != null && mp[i - 1][j - 1][0] != null) {
                        mp[i][j][1] = Math.max(mp[i - 1][j][1], mp[i - 1][j - 1][0] - prices[i]);
                    } else if (mp[i - 1][j][1] != null) {
                        mp[i][j][1] = mp[i - 1][j][1];
                    } else if (mp[i - 1][j - 1][0] != null) {
                        mp[i][j][1] = mp[i - 1][j - 1][0] - prices[i];
                    }

                } else {
                    // j是偶数，当天没有持仓，j-1是奇数，有持仓
                    if (j == 0) {
                        mp[i][j][0] = 0;
                    } else {
                        if (mp[i - 1][j - 1][1] != null && mp[i - 1][j][0] != null) {
                            mp[i][j][0] = Math.max(mp[i - 1][j - 1][1] + prices[i], mp[i - 1][j][0]);
                        } else if (mp[i - 1][j - 1][1] != null) {
                            mp[i][j][0] = mp[i - 1][j - 1][1] + prices[i];
                        } else if (mp[i - 1][j][0] != null) {
                            mp[i][j][0] = mp[i - 1][j][0];
                        }
                    }
                }

            }
        }

        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < 2 * k + 1; i++) {
            if (i % 2 == 1) {
                continue;
            }
            if (mp[prices.length - 1][i][0] != null && maxProfit < mp[prices.length - 1][i][0]) {
                maxProfit = mp[prices.length - 1][i][0];
            }
        }
        return maxProfit;
    }

    public static int maxProfitLimitTradeTime1(int[] prices, int k) {
        if (prices.length < 1 || k < 1) {
            return 0;
        }
        // 定义状态转移方程dp--maxProfit--mp,第i天的最高收益
        // 每天的状态可以是持有股票或者未持有股票，所以需要增加是否持有股票的维度
        // 限制交易次数，所以需要增加一个维度表示当前的交易次数
        // mp[i][j][0/1] 表示第i天，交易了j次，当前未持有/持有股票时的最大收益
        // mp[i][0/1][j] 表示第i天，交易了j次，当前未持有/持有股票时的最大收益,第i天最多交易i/2 + 1次。aka 第0天最多交易1次，第一天最多1次
        // 第二天最多2次
        Integer[][][] mp = new Integer[prices.length][2][k + 1];

        mp[0][0][0] = 0;
        mp[0][1][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < mp[i][0].length; j++) {
                // 第i天，没有股票，则分两种情况。上一天没有持仓，当天没有买入；上一天有持仓，当天卖出了。
                if (j == 0) {
                    // 没有买卖
                    mp[i][0][j] = 0;
                } else {
                    mp[i][0][j] = max(mp[i - 1][0][j], mp[i - 1][1][j], prices[i]);
                    mp[i][1][j] = max(mp[i - 1][1][j], mp[i - 1][0][j - 1], -prices[i]);
                }
            }
        }

        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < mp[prices.length - 1][0].length; i++) {
            maxProfit = max(maxProfit, mp[prices.length - 1][0][i], 0);
        }
        return maxProfit;
    }

    /**
     * 一天冷却时间
     *
     * @param prices
     * @return
     */
    public static int maxProfitWithCooldown(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        // 状态定义
        // mp[i][0][i] 表示当天没有持仓的最大收益；mp[i][1][i]表示当天有持仓的最大收益
        // i=0表示第二天可以买，i=1表示第二天不能买
        Integer[][][] mp = new Integer[prices.length][2][2];
        mp[0][0][0] = 0;
        mp[0][1][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 第i天没有持仓，且第i+1天可以买。表示今天没有卖
            // 前一天没有持仓
            // 前一天没有持仓，且交易过一次，今天恢复
            mp[i][0][0] = max(mp[i - 1][0][0], mp[i - 1][0][1], 0);

            // 第i天没有持仓，且第i+1天不能买.今天有卖出
            mp[i][0][1] = max(mp[i - 1][1][0], mp[i - 1][1][1], 0) + prices[i];
            // 第i天有持仓，且第i+1天可以买
            // 前一天有持仓，今天没有卖出
            mp[i][1][0] = max(mp[i - 1][1][0], mp[i - 1][1][1], 0);

            // 第i天有持仓，前一天有持仓。今天卖了再买？
            mp[i][1][1] = max(mp[i - 1][0][0] - prices[i], mp[i - 1][1][0], 0);


        }
        return max(mp[prices.length - 1][0][0], mp[prices.length - 1][0][1], 0);
    }

    /**
     * 有手续费交易，这个版本可以跑，但是占用空间超了
     *
     * @param prices
     * @param fee
     * @return
     */
    public static int maxProfitWithFee(int[] prices, int fee) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int profit = Integer.MIN_VALUE;
        int k = prices.length / 2;
        // 状态定义
        // dp[i] 到第i天的最大利润 -> maxProfit[i],mp[i]
        Integer[][][] mp = new Integer[prices.length][2][k + 1];
        mp[0][0][0] = 0;
        mp[0][1][1] = -prices[0] - fee;
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < k + 1; j++) {
                if (j == 0) {
                    mp[i][0][j] = 0;
                } else {
                    mp[i][0][j] = max(mp[i - 1][0][j], mp[i - 1][1][j], prices[i]);
                    mp[i][1][j] = max(mp[i - 1][1][j], mp[i - 1][0][j - 1], -prices[i] - fee);
                }
            }
        }
        for (int i = 0; i < mp[prices.length - 1][0].length; i++) {
            profit = max(profit, mp[prices.length - 1][0][i], 0);
        }

        return profit;
    }

    /**
     * 优化空间
     *
     * @param prices
     * @param fee
     * @return
     */
    public static int maxProfitWithFee1(int[] prices, int fee) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        // 状态定义
        // mp[i][0] 表示当天没有持仓的最大收益；mp[i][1]表示当天有持仓的最大收益
        Integer[][] mp = new Integer[prices.length][2];
        mp[0][0] = 0;
        mp[0][1] = -prices[0] - fee;
        for (int i = 1; i < prices.length; i++) {
            // 第i天没有持仓的最大收益等于以下俩值的最大值
            // 第i-1天没有持仓，第i天也没有，不动
            // 第i-1天有持仓，第i天卖掉了
            mp[i][0] = Math.max(mp[i - 1][0], mp[i - 1][1] + prices[i] - fee);
            // 第i天有持仓的最大收益等于以下俩值的最大值
            // 第i-1天没有持仓，第i天买入
            // 第i-1天有持仓，第i天不动
            mp[i][1] = Math.max(mp[i - 1][0] - prices[i], mp[i - 1][1]);
        }


        return mp[prices.length - 1][0];
    }

    public static Integer max(Integer a, Integer b, Integer c) {
        if (a != null && b != null) {
            return Math.max(a, b + c);
        } else if (a != null) {
            return a;
        } else if (b != null) {
            return b + c;
        } else {
            return null;
        }
    }
}
