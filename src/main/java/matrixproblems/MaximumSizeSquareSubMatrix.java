package matrixproblems;

/**
 * Created by gbalasubramanian on 08/05/17.
 */
public class MaximumSizeSquareSubMatrix {
    public static void main(String[] args) {
        int matrix[][] = {{1, 1, 0, 0, 1, 1},
                {0, 0, 1, 0, 1, 1},
                {1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1, 1}
        };

        System.out.println("Max size square sub matrix is " + maxSubArrayMatrix(matrix));

    }

    //
    private static int maxSubArrayMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int maxSize = 0;
        int[][] maxMatrix = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0 || j == 0) {
                    maxMatrix[i][j] = matrix[i][j];
                    maxSize = maxMatrix[i][j] > maxSize ? maxMatrix[i][j] : maxSize;
                } else if (matrix[i][j] == 0) {
                    maxMatrix[i][j] = 0;
                } else {
                    maxMatrix[i][j] = Math.min(Math.min(maxMatrix[i - 1][j - 1], maxMatrix[i - 1][j]), maxMatrix[i][j - 1]) + 1;
                    maxSize = maxMatrix[i][j] > maxSize ? maxMatrix[i][j] : maxSize;
                }
            }
        }
        return maxSize;
    }
}
