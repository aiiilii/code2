import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static class Node {
        int val;
        int key;
        Node next;
        Node prev;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    public static class DLL {
        Node head;
        Node tail;
        int len;
        public DLL() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            len = 0;
        }
        
        public void add(Node node) {
            Node headNext = head.next;
            node.next = headNext;
            headNext.prev = node;
            node.prev = head;
            head.next = node;
            len ++;
        }
        
        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            len --;
        }
    }
    
    int maxCapacity;
    Map<Integer, Node> map;
    DLL dList;

    public LRUCache(int capacity) {
        maxCapacity = capacity;
        map = new HashMap<Integer, Node>();
        dList = new DLL();
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        dList.remove(node);
        dList.add(node);
        
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.val = value;
            get(key);
            return;
        }
        
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        if (dList.len == maxCapacity) {
            map.remove(dList.tail.prev.key);
            dList.remove(dList.tail.prev);
        }
        dList.add(newNode);
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
    }
}