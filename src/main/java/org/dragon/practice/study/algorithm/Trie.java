package org.dragon.practice.study.algorithm;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Liuwl
 * Date: 2020/6/23
 **/
public class Trie {
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

