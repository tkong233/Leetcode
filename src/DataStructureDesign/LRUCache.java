package DataStructureDesign;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class ListNode {
        int key;
        int value;
        ListNode next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size, capacity;
    private ListNode dummyHead, tail;
    private Map<Integer, ListNode> keyToPrev;
    /*
     * @param capacity: An integer
     */public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        dummyHead = new ListNode(-1, -1);
        tail = dummyHead;
        keyToPrev = new HashMap<>();
    }

    // assume key exists
    private void moveToTail(int key) {
        ListNode prev = keyToPrev.get(key);
        ListNode cur = prev.next;
        // 这里cur不可能是null，因为keyToPrev中找的key

        if (cur == tail) {
            return;
        }

        prev.next = cur.next;

        if (cur.next != null) {
            keyToPrev.put(cur.next.key, prev);
        }

        keyToPrev.put(key, tail);
        tail.next = cur;
        cur.next = null; // 记得断尾
        tail = cur;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        if (size == 0 || !keyToPrev.containsKey(key)) {
            return -1;
        }

        moveToTail(key);
        System.out.println(tail.value);
        return tail.value;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // case 1: key exists. update key's value
        if (get(key) != -1) {
            tail.value = value;
            return;
        }

        // case 2: key not exist. add a new node.
        ListNode node = new ListNode(key, value);

        // case 2.1: size == 0. set new node's prev to dummyHead
        if (size == 0) {
            dummyHead.next = node;
            keyToPrev.put(key, dummyHead);
            tail = node;
            size++;
            return;
        }

        // case 2.2: size == capacity. remove LRU node, then add new node to tail
        if (size == capacity) {
            ListNode LRU = dummyHead.next;
            if (LRU != null) {
                dummyHead.next = LRU.next;
                keyToPrev.remove(LRU.key);
                if (LRU.next != null) {
                    keyToPrev.put(LRU.next.key, dummyHead);
                }
            }
        }

        if (size < capacity) {
            size++;
        }

        // case 2.3: size < capacity. just add a new node to tail
        keyToPrev.put(key, tail);
        tail.next = node;
        tail = node;
        return;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
        cache.set(2, 1);
        cache.get(2);
        cache.set(3, 2);
        cache.get(2);
        cache.get(3);
    }
}
