package org.dragon.practice.study.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Liuwl
 * Date: 2020/7/21
 **/
public class LRUCache {
    Map<Integer, Node> internal;
    int capacity = 0;
    DoubleLinkedList doubleLinkedList;

    public LRUCache(int capacity) {
        internal = new HashMap<>(capacity);
        this.capacity = capacity;
        doubleLinkedList = new DoubleLinkedList(capacity);
    }

    public int get(int key) {
        if (internal.containsKey(key)) {
            Node node = internal.get(key);
            doubleLinkedList.remove(node);
            doubleLinkedList.addAtHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (internal.containsKey(key)) {
            Node node = internal.get(key);
            node.value = value;
            doubleLinkedList.remove(node);
            doubleLinkedList.addAtHead(node);
        } else {
            if (internal.size() == capacity) {
                Node node = doubleLinkedList.removeAtTail();
                internal.remove(node.key);
            }
            Node node = new Node(value, key);
            doubleLinkedList.addAtHead(node);
            internal.put(key, node);

        }

    }

    class Node {
        private int value;
        private int key;
        private Node pre = null;
        private Node next = null;

        public Node(int value, int key) {
            this.value = value;
            this.key = key;
        }
    }

    class DoubleLinkedList {
        private Node head;
        private Node tail;
        private int capacity;

        public DoubleLinkedList(int size) {
            capacity = size;
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.pre = head;
        }

        public void addAtHead(Node node) {
            head.next.pre = node;
            node.next = head.next;
            node.pre = head;
            head.next = node;
        }

        public void remove(Node node) {
            Node tmp = node.next;
            node.pre.next = tmp;
            tmp.pre = node.pre;
        }

        public Node removeAtTail() {
            Node tmp = tail.pre;
            tail.pre = tmp.pre;
            tmp.pre.next = tail;
            return tmp;
        }
    }
}
