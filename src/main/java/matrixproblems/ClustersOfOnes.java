package matrixproblems;

/**
 * Created by gbalasubramanian on 09/05/17.
 */
public class ClustersOfOnes {
    //this is called finding the number of islands problem
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1, 0, 1},
                {1, 1, 0, 0, 0},
                {0, 1, 0, 1, 1}
        };
        NumberOfClusters numberOfClusters = new NumberOfClusters();
        System.out.println(numberOfClusters.findNumberOfClusters(matrix));
        int[][] matrix1 = {
                {1, 0, 1, 0, 1},
                {1, 1, 0, 0, 0},
                {0, 1, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1}
        };
        System.out.println(numberOfClusters.findNumberOfClusters(matrix1));
    }


}

class NumberOfClusters {
    // neighbors of matrix can be i-1, j-1 or i -1, j or i, j-1 or i+1, j or i + 1, j+1 or i, j + 1
    final int[] offset = {-1, 0, 1};

    private boolean neighborExists(int[][] matrix, int i, int j) {
        if ((i >= 0) && (i < matrix.length) && (j >= 0) && (j < matrix[0].length)) {
            if (matrix[i][j] == 1)
                return true;
        }
        return false;
    }

    void dfs(int[][] matrix, int i, int j, boolean[][] visited) {
        if (visited[i][j])
            return;

        visited[i][j] = true;

        int xOffset, yOffset;

        for (int a = 0; a < offset.length; a++) {
            xOffset = offset[a];
            for (int b = 0; b < offset.length; b++) {
                yOffset = offset[b];

                //no need to consider the item as its own neighbor
                if (xOffset == 0 && yOffset == 0)
                    continue;
                if (neighborExists(matrix, i + xOffset, j + yOffset)) {
                    dfs(matrix, i + xOffset, j + yOffset, visited);
                }
            }
        }
    }

    //counts the number of islands
    public int findNumberOfClusters(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if ((matrix[i][j] == 1) && (!visited[i][j])) {
                    count += 1;
                    dfs(matrix, i, j, visited);
                }
            }
        }
        return count;
    }
}

