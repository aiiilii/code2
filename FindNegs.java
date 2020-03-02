public class FindNegs {

    public static void findNegs(int[] nums) {
        int i = 0;
        int j = 0;
        while (i < nums.length && j < nums.length) {
            while (j < nums.length - 1 && nums[i] == nums[j + 1]) {
                j++;
            }

            if (i == j) {
                i ++;
                j ++;
            } else if (j - i >= 2) {
                while (i <= j) {
                    System.out.print(nums[i] + " \t");
                    i++;
                }
                i = j;
            } else {
                i = j;
            }
        }
    }

    public static void findNegsMatrix(int[][] matrix) {
        for (int c = 0; c < matrix[0].length; c++) {
            int i = 0;
            int j = 0;
            while (i < matrix.length && j < matrix.length) {
                while (j < matrix.length - 1 && matrix[i][c] == matrix[j + 1][c]) {
                    j ++;
                }

                if (i == j) {
                    i ++;
                    j ++;
                } else if (j - i >= 2) {
                    while (i <= j) {
                        System.out.print(matrix[i][c] + " \t");
                        i ++;
                    }
                    i = j;
                } else {
                    i = j;
                }
            }   
        }

        for (int r = 0; r < matrix.length; r++) {
            int i = 0;
            int j = 0;
            while (i < matrix[0].length && j < matrix[0].length) {
                while (j < matrix[0].length - 1 && matrix[r][i] == matrix[r][j + 1]) {
                    j ++;
                }

                if (i == j) {
                    i ++;
                    j ++;
                } else if (j - i >= 2) {
                    while (i <= j) {
                        System.out.print(matrix[r][i] + " \t");
                        i ++;
                    }
                    i = j;
                } else {
                    i = j;
                }
            }   
        }
    }

    public static void main(String[] args) {
        // int[] nums = new int[] { 0, 2, 1, 3, -1, -1, -1, -1 };
        // findNegs(nums);

        int[][] matrix = new int[][] {{1,2,3,7,3,1,7,8},
                                        {1,-1,-1,-1,5,6,7,8},
                                        {-1,4,5,6,7,3,9,4},
                                        {-1,2,3,4,5,3,7,8},
                                        {-1,1,-1,-1,-1,3,7,8},
                                        {2,1,1,1,5,6,7,8},
                                        {3,4,5,6,7,8,9,-1},
                                        {1,-1,-1,-1,5,6,7,-1},
                                        {3,4,5,6,7,8,9,-1},
                                        {1,2,3,4,5,6,7,8}};
        
        // for (int i = 0; i < matrix[0].length; i++) {
        //     for (int j = 0; j < matrix.length; j++) {
        //         System.out.print(matrix[j][i] + "\t");
        //     }
        //     System.out.println();
        // }
        // System.out.println("------------------");
        findNegsMatrix(matrix);
        // for (int i = 0; i < matrix[0].length; i++) {
        //     for (int j = 0; j < matrix.length; j++) {
        //         System.out.print(matrix[j][i] + "\t");
        //     }
        //     System.out.println();
        // }
    }
}