public class DeleteNumInMatrix {

    public static void deleteNumMatrix(int[][] matrix) {
        for (int k = 0; k < matrix[0].length; k++) {
            int i = matrix.length - 1;
            int j = matrix.length - 1;
            while (i >= 0 && j >= 0) {
                while (matrix[j][k] == -1) {
                    j--;
                }
                matrix[i][k] = matrix[j][k];
                i--;
                j--;
            }
            while (i >= 0) {
                matrix[i][k] = -1;
                i--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,2,3,4,5,6,7,8},
                                        {2,2,3,4,5,6,7,8},
                                        {-1,4,5,6,7,3,9,4},
                                        {-1,2,3,4,5,3,7,8},
                                        {-1,2,3,4,5,3,7,8},
                                        {2,-1,-1,-1,5,6,7,8},
                                        {3,4,5,6,7,8,9,4},
                                        {1,2,3,4,5,6,7,8}};
        
        deleteNumMatrix(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}