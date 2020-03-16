import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    public class Node {
        int key;
        int val;
        Node next;
        Node prev;
        int count;
        
        public Node(int k, int v) {
            key = k;
            val = v;
            count = 1;
        }
    }
    
    public class DLList {
        Node head;
        Node tail;
        int len;
        
        public DLList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            len = 0;
        }
        
        public void add(Node node) {
            Node headNext = head.next;
            head.next = node;
            node.prev = head;
            node.next = headNext;
            headNext.prev = node;
            len ++;
        }
        
        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            len --;
        }
        
        public void removeTail() {
            remove(tail.prev);
        }
    }
    
    int maxCapacity;
    Map<Integer, Node> map;
    Map<Integer, DLList> freqMap;
    int maxFreq;
    int size;

    public LFUCache(int capacity) {
        maxCapacity = capacity;
        map = new HashMap<Integer, Node>();
        freqMap = new HashMap<Integer, DLList>();
        maxFreq = 0;
        size = 0;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        int prevFreq = node.count;
        
        DLList prevList = freqMap.get(prevFreq);
        prevList.remove(node);
        
        int currFreq = prevFreq + 1;
        DLList currList = freqMap.getOrDefault(currFreq, new DLList());
        currList.add(node);
        
        node.count ++;
        maxFreq = Math.max(maxFreq, currFreq);
        
        freqMap.put(prevFreq, prevList);
        freqMap.put(currFreq, currList);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (maxCapacity == 0) {
            return;
        }
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            get(key);
            return;
        }
        Node newNode = new Node(key, value);
        DLList currList = freqMap.getOrDefault(newNode.count, new DLList());
        currList.add(newNode);
        size ++;
        
        if (size > maxCapacity) {
            if (currList.len > 1) {
                map.remove(currList.tail.prev.key);
                currList.removeTail();
            } else {
               for (int i = 2; i <= maxFreq; i++) {
                    if (freqMap.containsKey(i) && freqMap.get(i).len > 0) {
                        DLList minList = freqMap.get(i);
                        map.remove(minList.tail.prev.key);
                        minList.removeTail();
                        freqMap.put(i, minList);
                        break;
                    }
                } 
            }
            size--;
        }
        freqMap.put(newNode.count, currList);
        map.put(key, newNode);
    }


    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        System.out.println(lfuCache.get(1));
        lfuCache.put(3, 3);
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));
        lfuCache.put(4, 4);
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));
    }
}