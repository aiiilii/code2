import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    /** initialize your data structure here. */
    public FindMedianFromDataStream() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>((x, y) -> y - x);
    }
    
    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
        
        if (minHeap.size() < maxHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() < minHeap.size()) {
            return minHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) * 0.5;
        }
    }

    public static void main(String[] args) {
        FindMedianFromDataStream findMedian = new FindMedianFromDataStream();
        findMedian.addNum(-1);
        findMedian.addNum(-2);
        findMedian.addNum(-3);
        System.out.println(findMedian.findMedian());
    }
}