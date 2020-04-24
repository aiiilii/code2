public class CountStrings {

    public static int countStrings(int n, int nb, int nc) {
        if (n == 0) {
            return 1; 
        }
        int res = countStrings(n - 1, nb, nc);
        if (nb > 0) {
            res += countStrings(n - 1, nb - 1, nc);
        }
        if (nc > 0) {
            res += countStrings(n - 1, nb, nc - 1);
        }
        return res;
    }


    public static void main(String[] args) {
        int n = 5;
        int nb = 1;
        int nc = 2;
        System.out.println(countStrings(n, nb, nc));
    }
}