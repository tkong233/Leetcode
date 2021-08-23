package HashMap;
import java.util.*;

public class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static int capacity;
    Map<Integer, Node> keyToNode;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        keyToNode = new HashMap<>();
        head = null;
        tail = null;
    }

    public int get(int key) {
        Node node = keyToNode.getOrDefault(key, null);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (keyToNode.isEmpty()) {
            Node node = new Node(key, value);
            keyToNode.put(key, node);
            head = node;
            tail = node;
            return;
        }
        if (!keyToNode.containsKey(key) && keyToNode.size() == capacity) {
            popTail();
        }
        Node node = keyToNode.getOrDefault(key, new Node(key, value));
        node.value = value;
        moveToHead(node);
        keyToNode.put(key, node);

    }

    private void moveToHead(Node node) {
        if (node == head) {
            return;
        }
        if (tail == node) {
            tail = tail.prev;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        node.next = head;
        head.prev = node;
        head = node;
    }

    private void popTail() {
        keyToNode.remove(tail.key);
        if (tail != null) {
            tail = tail.prev;
        }
        if (tail != null) {
            tail.next = null;
        }
    }

    public static void main(String[] args) {
        LRUCache solution = new LRUCache(1);
        solution.put(2, 1);
        solution.get(2);
        solution.put(3, 2);
        solution.get(2);
        solution.get(3);
    }
}
