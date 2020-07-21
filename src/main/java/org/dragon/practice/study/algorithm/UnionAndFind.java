package org.dragon.practice.study.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Liuwl
 * Date: 2020/7/20
 **/
public class UnionAndFind {
    private int[] roots;

    public UnionAndFind(int n) {
        roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
    }

    public int find(int a) {
        if (a >= roots.length) {
            return -1;
        }
        int x = a;
        while (roots[x] != x) {
            x = roots[x];
        }
        while (roots[a] != x) {
            int c = roots[a];
            roots[a] = x;
            a = c;
        }

        return x;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        roots[pRoot] = qRoot;
    }

    public boolean find(int a, int b) {
        return find(a) == find(b);
    }

}

class Island {
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        UnionAndFind unionAndFind = new UnionAndFind(grid.length * grid[0].length);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    // 判断上下左右是不是1，如果是的话，合并
                    if (i > 0 && grid[i - 1][j] == '1') {
                        unionAndFind.union(i * grid[0].length + j, (i - 1) * grid[0].length + j);
                    }
                    if (j > 0 && grid[i][j - 1] == '1') {
                        unionAndFind.union(i * grid[0].length + j, i * grid[0].length + j - 1);
                    }
                    if (i + 1 < grid.length && grid[i + 1][j] == '1') {
                        unionAndFind.union(i * grid[0].length + j, (i + 1) * grid[0].length + j);
                    }
                    if (j + 1 < grid[0].length && grid[i][j + 1] == '1') {
                        unionAndFind.union(i * grid[0].length + j, i * grid[0].length + j + 1);
                    }
                }
            }
        }

        Set<Integer> islands = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islands.add(unionAndFind.find(i * grid[0].length + j));
                }
            }
        }
        return islands.size();
    }
}

class FriendCircle {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionAndFind unionAndFind = new UnionAndFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1) {
                    unionAndFind.union(i, j);
                }
            }
        }
        Set<Integer> islands = new HashSet<>();
        for (int i = 0; i < n; i++) {
            islands.add(unionAndFind.find(i));
        }
        return islands.size();

    }
}
