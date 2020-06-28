package org.dragon.practice.study.algorithm;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Liuwl
 * Date: 2020/6/24
 **/
public class WordSearch {
    private Set<String> used = new HashSet<>();

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (find(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean find(char[][] board, String word, int wordIndex, int i, int j) {
        if (used.contains(i + "_" + j)) {
            return false;
        }
        if (board[i][j] == word.charAt(wordIndex)) {
            used.add(i + "_" + j);
            if (wordIndex == word.length() - 1) {
                return true;
            }
            // 继续查找
            boolean res = false;
            if (i < board.length - 1) {
                res = find(board, word, wordIndex + 1, i + 1, j);
            }
            if (res == true) {
                return true;
            }

            if (i > 0) {
                res = find(board, word, wordIndex + 1, i - 1, j);
            }
            if (res == true) {
                return true;
            } else {

            }

            if (j > 0) {
                res = find(board, word, wordIndex + 1, i, j - 1);
            }
            if (res == true) {
                return true;
            }

            if (j < board[0].length - 1) {
                res = find(board, word, wordIndex + 1, i, j + 1);
            }
            if (res == true) {
                return true;
            }


        }
        used.remove(i + "_" + j);


        return false;
    }


    private List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                dfs(board, i, j, "", trie);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, String word, Trie trie) {
        if (i < 0 || i >= board.length
                || j < 0 || j >= board[0].length) {
            return;
        }

        if (used.contains(i + "_" + j)) {
            return;
        }
        word += board[i][j];
        if (word.length() > 0) {
            if (!trie.startsWith(word)) {
                return;
            }
            if (trie.search(word)) {
                result.add(word);
            }
        }

        used.add(i + "_" + j);
        dfs(board, i + 1, j, word, trie);
        dfs(board, i - 1, j, word, trie);
        dfs(board, i, j + 1, word, trie);
        dfs(board, i, j - 1, word, trie);

        used.remove(i + "_" + j);


        return;

    }

    class Trie {
        private TrieTreeNode root = new TrieTreeNode();

        /**
         * Initialize your data structure here.
         */
        public Trie() {

        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieTreeNode node = root;
            for (int i = 0; i < word.length(); i++) {
                TrieTreeNode temp = getNode(node, word.charAt(i));
                if (temp == null) {
                    temp = addNode(node, word.charAt(i), i == word.length() - 1);
                }

                node = temp;
            }
            node.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieTreeNode node = root;
            for (int i = 0; i < word.length(); i++) {
                TrieTreeNode temp = getNode(node, word.charAt(i));
                if (temp == null) {
                    return false;
                }

                node = temp;
            }

            return node.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieTreeNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                TrieTreeNode temp = getNode(node, prefix.charAt(i));
                if (temp == null) {
                    return false;
                }

                node = temp;
            }

            return node.child != null;
        }

        private TrieTreeNode getNode(TrieTreeNode parent, char c) {
            return parent.child[c - 'a'];
        }

        private TrieTreeNode addNode(TrieTreeNode parent, char c, boolean isEnd) {
            if (parent.child[c - 'a'] == null) {
                parent.child[c - 'a'] = new TrieTreeNode(c, isEnd);
            }
            return parent.child[c - 'a'];
        }

        class TrieTreeNode {
            TrieTreeNode[] child = new TrieTreeNode[26];
            boolean isEnd;
            char value;

            public TrieTreeNode() {
                isEnd = false;
                for (int i = 0; i < child.length; i++) {
                    child[i] = null;
                }
            }

            public TrieTreeNode(char c, boolean isEnd) {
                this.isEnd = isEnd;
                value = c;
                for (int i = 0; i < child.length; i++) {
                    child[i] = null;
                }
            }
        }


    }

    public static void main(String[] args) {
        char[][] board = JSON.parseObject("[[\"a\",\"a\"]]", char[][].class);
        System.out.println(new WordSearch().findWords(board, new String[]{"aaa"}));
    }
}
