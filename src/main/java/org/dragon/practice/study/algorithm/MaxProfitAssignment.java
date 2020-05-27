package org.dragon.practice.study.algorithm;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Liuwl
 * Date: 2020/5/27
 **/
public class MaxProfitAssignment {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        int i = 0;
        int j = 0;
        int sum = 0;

        ArrayList<Integer> workerList = new ArrayList();
        for (int k = 0; k < worker.length; k++) {
            workerList.add(worker[k]);
        }
        workerList.sort(Integer::compareTo);
        Integer[] workerArr = workerList.toArray(new Integer[1]);

        ArrayList<ProfitValue> profitValues = new ArrayList<>();
        for (int k = 0; k < difficulty.length; k++) {
            profitValues.add(new ProfitValue(profit[k], difficulty[k]));
        }

        profitValues.sort(Comparator.comparing(a -> a.profit));

        ProfitValue[] profitArray = profitValues.toArray(new ProfitValue[1]);

        int maxProfit = 0;
        while (i < profitArray.length && j < workerArr.length) {
            // 能力大于难度，继续增加难度
            // 需要记录最大的收益
            if (workerArr[j] >= profitArray[i].difficulty) {
                if (profitArray[i].profit > maxProfit) {
                    maxProfit = profitArray[i].profit;
                }
                if (i < profitArray.length - 1) {
                    i++;
                    continue;
                }
            }

            if (workerArr[j] >= profitArray[i].difficulty) {
                if (maxProfit < profitArray[i].profit) {
                    maxProfit = profitArray[i].profit;
                }
                // 能力小于等于难度，做这份工作
                sum += maxProfit;
            } else {
                if (i > 0) {
                    sum += maxProfit;
                }
            }
            // 看后面的人，后面的人能力大于等于当前工作
            j++;
        }
        return sum;
    }

    class ProfitValue {
        Integer profit;
        Integer difficulty;

        public ProfitValue(int profit, int d) {
            this.difficulty = d;
            this.profit = profit;
        }

        public Integer getDifficulty() {
            return difficulty;
        }

        public Integer getProfit() {
            return profit;
        }
    }


}
