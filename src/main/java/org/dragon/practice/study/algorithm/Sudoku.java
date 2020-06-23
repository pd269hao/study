package org.dragon.practice.study.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * 1. 检测是否为合法数独
 *
 * @Author: Liuwl
 * Date: 2020/6/20
 **/
public class Sudoku {

    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> colList = new ArrayList<>();
        List<Set<Character>> rowList = new ArrayList<>();
        Set<Character>[][] blockSet = new Set[3][3];
        for (int i = 0; i < 9; i++) {
            rowList.add(new HashSet<>());
            for (int j = 0; j < 9; j++) {
                if (colList.size() - 1 <= j) {
                    colList.add(new HashSet<>());
                }
                Set<Character> block = blockSet[i / 3][j / 3];
                if (block == null) {
                    block = new HashSet<>();
                    blockSet[i / 3][j / 3] = block;
                }
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }

                if (colList.get(j).contains(c)) {
                    return false;
                }
                colList.get(j).add(c);

                if (rowList.get(i).contains(c)) {
                    return false;
                }
                rowList.get(i).add(c);

                if (block.contains(c)) {
                    return false;
                }
                block.add(c);
            }
        }

        return true;
    }

    List<Set<Character>> colList = new ArrayList<>();
    List<Set<Character>> rowList = new ArrayList<>();
    Set<Character>[][] blockSet = new Set[3][3];

    // 暴力搜索
    public void solveSudoku(char[][] board) {
        // 初始化已有数字
        for (int i = 0; i < 9; i++) {
            rowList.add(new HashSet<>());
            for (int j = 0; j < 9; j++) {
                if (colList.size() - 1 <= j) {
                    colList.add(new HashSet<>());
                }
                Set<Character> block = blockSet[i / 3][j / 3];
                if (block == null) {
                    block = new HashSet<>();
                    blockSet[i / 3][j / 3] = block;
                }
                char c = board[i][j];
                if (c != '.') {
                    colList.get(j).add(c);
                    rowList.get(i).add(c);
                    block.add(c);
                }
            }
        }

        solve(board);
    }

    public boolean solve(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Set<Character> block = blockSet[i / 3][j / 3];
                char c = board[i][j];
                if (c == '.') {
                    for (char a = '1'; a <= '9'; a++) {
                        if (valid(i, j, block, a)) {
                            board[i][j] = a;
                            colList.get(j).add(a);
                            rowList.get(i).add(a);
                            block.add(a);
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                                colList.get(j).remove(a);
                                rowList.get(i).remove(a);
                                block.remove(a);
                            }
                        }

                    }
                    return false;
                }

            }
        }
        return true;

    }

    private boolean valid(int i, int j, Set<Character> block, char a) {
        if (colList.get(j).contains(a)) {
            return false;
        }

        if (rowList.get(i).contains(a)) {
            return false;
        }

        if (block.contains(a)) {
            return false;
        }
        return true;
    }
}
