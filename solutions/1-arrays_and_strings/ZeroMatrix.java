import solutions.TestUtils;

/*
 * Question 1.8:
 *  Write an algorithm such that if an element in an MxN matrix is 0,
 *  its entire row and column are set to 0.
 */
public class ZeroMatrix {

    // Method: Two-pass algorithm with boolean arrays
    // Time: O(m*n), Space: O(m+n)
    public static void setZero(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

        TestUtils.reset();
        
        // Test 1: Basic case with one zero
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 0, 6},
            {7, 8, 9}
        };
        int[][] expected1 = {
            {1, 0, 3},
            {0, 0, 0},
            {7, 0, 9}
        };
        int[][] testMatrix1 = TestUtils.copyMatrix(matrix1);
        setZero(testMatrix1);
        TestUtils.testMatrix("Basic case with one zero", testMatrix1, expected1);
        
        // Test 2: Multiple zeros
        int[][] matrix2 = {
            {0, 2, 3},
            {4, 5, 6},
            {7, 8, 0}
        };
        int[][] expected2 = {
            {0, 0, 0},
            {0, 5, 0},
            {0, 0, 0}
        };
        int[][] testMatrix2 = TestUtils.copyMatrix(matrix2);
        setZero(testMatrix2);
        TestUtils.testMatrix("Multiple zeros", testMatrix2, expected2);
        
        // Test 3: No zeros
        int[][] matrix3 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int[][] expected3 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int[][] testMatrix3 = TestUtils.copyMatrix(matrix3);
        setZero(testMatrix3);
        TestUtils.testMatrix("No zeros", testMatrix3, expected3);
        
        // Test 4: All zeros
        int[][] matrix4 = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        int[][] expected4 = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        int[][] testMatrix4 = TestUtils.copyMatrix(matrix4);
        setZero(testMatrix4);
        TestUtils.testMatrix("All zeros", testMatrix4, expected4);
        
        // Test 5: Single element matrix
        int[][] matrix5 = {{0}};
        int[][] expected5 = {{0}};
        int[][] testMatrix5 = TestUtils.copyMatrix(matrix5);
        setZero(testMatrix5);
        TestUtils.testMatrix("Single element zero", testMatrix5, expected5);
        
        // Test 6: Single element non-zero
        int[][] matrix6 = {{5}};
        int[][] expected6 = {{5}};
        int[][] testMatrix6 = TestUtils.copyMatrix(matrix6);
        setZero(testMatrix6);
        TestUtils.testMatrix("Single element non-zero", testMatrix6, expected6);
        
        // Test 7: Row with zero
        int[][] matrix7 = {
            {1, 2, 3, 4},
            {5, 6, 0, 8},
            {9, 10, 11, 12}
        };
        int[][] expected7 = {
            {1, 2, 0, 4},
            {0, 0, 0, 0},
            {9, 10, 0, 12}
        };
        int[][] testMatrix7 = TestUtils.copyMatrix(matrix7);
        setZero(testMatrix7);
        TestUtils.testMatrix("Row with zero", testMatrix7, expected7);
        
        // Test 8: Column with zero
        int[][] matrix8 = {
            {1, 2, 0, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        int[][] expected8 = {
            {0, 0, 0, 0},
            {5, 6, 0, 8},
            {9, 10, 0, 12}
        };
        int[][] testMatrix8 = TestUtils.copyMatrix(matrix8);
        setZero(testMatrix8);
        TestUtils.testMatrix("Column with zero", testMatrix8, expected8);
        
        // Test 9: Edge case - 1x3 matrix
        int[][] matrix9 = {{1, 0, 3}};
        int[][] expected9 = {{0, 0, 0}};
        int[][] testMatrix9 = TestUtils.copyMatrix(matrix9);
        setZero(testMatrix9);
        TestUtils.testMatrix("1x3 matrix with zero", testMatrix9, expected9);
        
        // Test 10: Edge case - 3x1 matrix
        int[][] matrix10 = {
            {1},
            {0},
            {3}
        };
        int[][] expected10 = {
            {0},
            {0},
            {0}
        };
        int[][] testMatrix10 = TestUtils.copyMatrix(matrix10);
        setZero(testMatrix10);
        TestUtils.testMatrix("3x1 matrix with zero", testMatrix10, expected10);
        
        TestUtils.printSummary();
    }

    
}
