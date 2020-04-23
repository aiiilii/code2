import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class IteratorExternalSort<T extends Comparable> implements Iterator {

    public class IterState implements Comparable<IterState> {
        private Iterator<T> iter;
        private T currVal;
        public IterState(Iterator<T> i) {
            this.iter = i;
            next();
        }

        public T getVal() {
            return currVal;
        }
        public void next() {
            if (iter.hasNext()) {
                currVal = iter.next();
            } else {
                currVal = null;
            }            
        }
        public boolean hasNext() {
            return iter.hasNext();
        }

        public int compareTo(IterState o) {
            return currVal.compareTo(o.getVal());
        }
    }

    private PriorityQueue<IterState> minHeap;

    public IteratorExternalSort(List<List<T>> lists) {
        minHeap = new PriorityQueue<IterState>();

        for (List<T> list : lists) {
            Iterator<T> it = list.iterator();
            if (it != null && it.hasNext()) {
                minHeap.offer(new IterState(it));
            }
        }
    }

    public T next() {
        IterState n = minHeap.poll();
        T retVal = n.getVal();
        if (n.hasNext()) {
            n.next();
            minHeap.offer(n);
        }
        return retVal;
    }

    public boolean hasNext() {
        return !minHeap.isEmpty();
    }


    private static <T extends Comparable> ArrayList toArray(List<List<T>> lists) {
        IteratorExternalSort<T> i = new IteratorExternalSort<T>(lists);
        ArrayList<T> retVal = new ArrayList<T>();
        while (i.hasNext()) {
            retVal.add(i.next());
        }
        return retVal;
    }

    public static void main(String[] args) {
        ArrayList arr = toArray(Arrays.asList(Arrays.asList(1,2,3), Arrays.asList(2,4,6), Arrays.asList(7,9), Arrays.asList(8), Arrays.asList(0, 10), Arrays.asList()));
        
        for (Object i : arr) {
            System.out.print(i + " ");
        }

        arr = toArray(Arrays.asList());
        for (Object i : arr) {
            System.out.print(i + " ");
        }
    }
}