public class BreakingTheRecords {

    public static int[] breakingRecords(int[] scores) {
        int[] res = new int[2];
        if (scores == null || scores.length == 0) {
            return res;
        }
        int min = scores[0];
        int max = scores[0];

        int breakLow = 0;
        int breakHigh = 0;

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
                breakHigh ++;
            }
            if (scores[i] < min) {
                min = scores[i];
                breakLow ++;
            }
        }
        res[0] = breakHigh;
        res[1] = breakLow;
        return res;
    }


    public static void main(String[] args) {
        int[] scores = new int[] {10, 5, 20, 20, 4, 5, 2, 25, 1};
        int[] records = breakingRecords(scores);

        for (int i = 0; i < records.length; i++) {
            System.out.print(records[i] + " ");
        }
    }
}