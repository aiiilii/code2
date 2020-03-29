import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BetweenTwoSets {

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int na : a) {
            if (na > max) {
                max = na;
            }
        }
        for (int nb : b) {
            if (nb < min) {
                min = nb;
            }
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = max; i <= min; i++) {
            int aCount = 0;
            for (int j = 0; j < a.size(); j++) {
                if (i % a.get(j) == 0) {
                    aCount ++;
                }
            }
            if (aCount == a.size()) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            
            int bCount = 0;
            for (int k = 0; k < b.size(); k++) {
                if (b.get(k) % i == 0) {
                    bCount ++;
                }
            }
            if (bCount == b.size()) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 2) {
                res ++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        List<Integer> a = new ArrayList<Integer>();
        a.add(2);
        a.add(4);
        List<Integer> b = new ArrayList<Integer>();
        b.add(16);
        b.add(32);
        b.add(96);
        System.out.println(getTotalX(a, b));
    }
}