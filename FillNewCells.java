import java.util.Random;

public class FillNewCells {

    private static Random random = new Random();

    public static void fillNewCells(int[][] matrix) {
        int i = 0;
        int j = 0;
        firstWhile:
        while (i < matrix[0].length && j < matrix.length) {
            while (j < matrix.length && matrix[j][0] != -1) {
                j++;
                if (j >= matrix.length) {
                    break firstWhile;
                }
            }
            while (i < matrix[0].length && matrix[j][i] == -1) {
                int r = random.nextInt(5);
                matrix[j][i] = r;
                i++;
            }
            j ++;
            i = 0;
        }
    }

    private static void fillNewCells1(int[][] matrix) {
        for (int i = 0;i < matrix.length;i ++) {
            int j = 0;
            while (j < matrix[0].length && matrix[i][j] == -1) {
                int r = random.nextInt(5);
                matrix[i][j] = r;
                j ++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{-1,2,3,7,3,1,7,8},
                                        {-1,2,3,4,5,6,7,8},
                                        {2,4,5,6,7,3,9,4},
                                        {1,2,3,4,5,3,7,8},
                                        {-1,-1,-1,-1,5,3,7,8},
                                        {2,1,1,1,5,6,7,8},
                                        {3,4,5,6,7,8,9,4},
                                        {-1,-1,3,4,5,6,7,8},
                                        {3,4,5,6,7,8,9,4},
                                        {1,2,3,4,5,6,7,8}};
        
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[j][i] + "\t");
            }
            System.out.println();
        }
        System.out.println("------------------");
        fillNewCells1(matrix);
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[j][i] + "\t");
            }
            System.out.println();
        }
    }
}