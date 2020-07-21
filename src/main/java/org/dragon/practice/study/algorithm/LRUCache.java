package org.dragon.practice.study.algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Liuwl
 * Date: 2020/7/21
 **/
public class LRUCache {
    Map<Integer, Integer> internal;
    LinkedList<Integer> list = new LinkedList<>();
    int capacity = 0;

    public LRUCache(int capacity) {
        internal = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (internal.containsKey(key)) {
            // 移动这个key到最左边
            list.remove(new Integer(key));
            list.addFirst(key);
            return internal.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (list.size() == capacity) {
            // 剔除最右元素
            int tmp = list.removeLast();
            internal.remove(tmp);
        }
        internal.put(key, value);
        list.addFirst(key);
    }
}
