import java.util.ArrayList;
import java.util.List;

public class BirthdayChocolate {

    public static int birthday(List<Integer> s, int d, int m) {
        if (s == null || s.size() < m) {
            return 0;
        }
        int res = 0;
        int sum = 0;

        int i = 0;
        int j = 0;

        for (j = 0; j < m; j++) {
            sum += s.get(j);
        }

        if (sum == d) {
            res ++;
        }

        while (j < s.size()) {
            sum -= s.get(i);
            i ++;
            sum += s.get(j);
            j ++;
            if (sum == d) {
                res ++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        List<Integer> s = new ArrayList<Integer>();
        s.add(4);
        int d = 4;
        int m = 1;
        System.out.println(birthday(s, d, m));
    }
}