import java.util.ArrayList;
import java.util.List;

public class ClimbingTheLeaderboard {

    public static int[] climbingleaderboard(int[] scores, int[] alice) {
        int[] res = new int[alice.length];

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < scores.length ; i++) {
            
            while (i > 0 && i < scores.length && scores[i] == scores[i - 1]) {
                i ++;
            }
            if (i < scores.length) {
                list.add(scores[i]);
            }
        }
        Integer[] scoresList = new Integer[list.size()];
        scoresList = list.toArray(scoresList);

        for (int i = 0; i < alice.length; i++) {
            secondloop:
            for (int j = 0; j < scoresList.length; j++) {
                if (alice[i] >= scoresList[0]) {
                    res[i] = 1;
                    break secondloop;
                } else if (alice[i] >= scoresList[j]) {
                    res[i] = j + 1;
                    break secondloop;
                } else if (alice[i] < scoresList[scoresList.length - 1]) {
                    res[i] = scoresList.length + 1;
                    break secondloop;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] scores = new int[] {100, 100, 50, 40, 40, 20, 10};
        int[] alice = new int[] {5, 25, 50, 120};

        int[] res = climbingleaderboard(scores, alice);

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}