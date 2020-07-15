package org.dragon.practice.study.algorithm;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Liuwl
 * Date: 2020/6/29
 **/
public class Triangle {
    /**
     * 自上而下
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        // 存储到这层每个节点的最短路径
        int[] lastLevelPath = new int[1];
        lastLevelPath[0] = triangle.get(0).get(0);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> level = triangle.get(i);
            int[] levelPath = new int[level.size()];
            levelPath[0] = level.get(0) + lastLevelPath[0];
            levelPath[levelPath.length - 1] = level.get(level.size() - 1) + lastLevelPath[lastLevelPath.length - 1];
            for (int j = 1; j < level.size() - 1; j++) {
                int p = level.get(j) + Math.min(lastLevelPath[j - 1], lastLevelPath[j]);
                levelPath[j] = p;
            }
            lastLevelPath = levelPath;
        }
        // 遍历最后一层的最短路径
        for (int i = 0; i < lastLevelPath.length; i++) {
            if (min > lastLevelPath[i]) {
                min = lastLevelPath[i];
            }
        }
        return min;

    }

    /**
     * 自下而上
     *
     * @param triangle
     * @return
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        // 从下往上走，每层的最短路径，到根节点就是最终结果
        List<Integer> min = triangle.get(triangle.size() - 1);
        for (int i = triangle.size() - 2; i > 0; i--) {
            List<Integer> level = triangle.get(i);
            for (int j = 0; j < level.size(); j++) {
                min.set(j, level.get(j) + Math.min(min.get(j), min.get(j + 1)));
            }
        }
        return min.get(0);
    }
}
