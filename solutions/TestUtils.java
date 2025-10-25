package solutions;
/*
 * TestUtils - General testing utility for CTCI solutions
 * Provides reusable methods for testing with pass/fail indicators
 */
public class TestUtils {
    
    private static int testCount = 0;
    private static int passedCount = 0;
    
    // Test a boolean result
    public static void testBoolean(String testName, boolean actual, boolean expected) {
        testCount++;
        boolean passed = actual == expected;
        if (passed) passedCount++;
        
        System.out.println("Test " + testCount + " - " + testName + ": " + actual + 
                          " (expected: " + expected + ")" + 
                          (passed ? " Passed!" : " Failed"));
    }
    
    // Test a string result
    public static void testString(String testName, String actual, String expected) {
        testCount++;
        boolean passed = actual.equals(expected);
        if (passed) passedCount++;
        
        System.out.println("Test " + testCount + " - " + testName + ": " + actual + 
                          " (expected: " + expected + ")" + 
                          (passed ? " Passed!" : " Failed"));
    }
    
    // Test an integer result
    public static void testInt(String testName, int actual, int expected) {
        testCount++;
        boolean passed = actual == expected;
        if (passed) passedCount++;
        
        System.out.println("Test " + testCount + " - " + testName + ": " + actual + 
                          " (expected: " + expected + ")" + 
                          (passed ? " Passed!" : " Failed"));
    }
    
    // Test a generic result (any type)
    public static <T> void test(String testName, T actual, T expected) {
        testCount++;
        boolean passed = actual.equals(expected);
        if (passed) passedCount++;
        
        System.out.println("Test " + testCount + " - " + testName + ": " + actual + 
                          " (expected: " + expected + ")" + 
                          (passed ? " Passed!" : " Failed"));
    }
    
    // Print test summary
    public static void printSummary() {
        System.out.println("==========================================");
        System.out.println("Test Summary: " + passedCount + "/" + testCount + " tests passed");
        if (passedCount == testCount) {
            System.out.println("All tests passed!");
        } else {
            System.out.println("Failed: " + (testCount - passedCount) + " test(s)");
        }
    }
    
    // Reset test counters (useful for running multiple test suites)
    public static void reset() {
        testCount = 0;
        passedCount = 0;
    }
    
    // Test with custom message
    public static void testWithMessage(String testName, boolean actual, boolean expected, String message) {
        testCount++;
        boolean passed = actual == expected;
        if (passed) passedCount++;
        
        System.out.println("Test " + testCount + " - " + testName + ": " + actual + 
                          " (expected: " + expected + ")" + 
                          (passed ? " Passed!" : " Failed") + " - " + message);
    }
    
    // Matrix utilities
    public static void testMatrix(String testName, int[][] actual, int[][] expected) {
        testCount++;
        boolean passed = matricesEqual(actual, expected);
        if (passed) passedCount++;
        
        System.out.println("Test " + testCount + " - " + testName + ": " + 
                          (passed ? "Passed!" : "Failed"));
        if (!passed) {
            System.out.println("Expected:");
            printMatrix(expected);
            System.out.println("Actual:");
            printMatrix(actual);
        }
    }
    
    // Check if two matrices are equal
    public static boolean matricesEqual(int[][] matrix1, int[][] matrix2) {
        if (matrix1 == null && matrix2 == null) return true;
        if (matrix1 == null || matrix2 == null) return false;
        if (matrix1.length != matrix2.length) return false;
        
        for (int i = 0; i < matrix1.length; i++) {
            if (matrix1[i] == null && matrix2[i] == null) continue;
            if (matrix1[i] == null || matrix2[i] == null) return false;
            if (matrix1[i].length != matrix2[i].length) return false;
            
            for (int j = 0; j < matrix1[i].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) return false;
            }
        }
        return true;
    }
    
    // Print matrix for debugging
    public static void printMatrix(int[][] matrix) {
        if (matrix == null) {
            System.out.println("null");
            return;
        }
        
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == null) {
                System.out.println("null row");
                continue;
            }
            System.out.print("[");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                if (j < matrix[i].length - 1) System.out.print(", ");
            }
            System.out.println("]");
        }
    }
    
    // Create a copy of matrix (useful for testing in-place modifications)
    public static int[][] copyMatrix(int[][] matrix) {
        if (matrix == null) return null;
        
        int[][] copy = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == null) {
                copy[i] = null;
            } else {
                copy[i] = new int[matrix[i].length];
                for (int j = 0; j < matrix[i].length; j++) {
                    copy[i][j] = matrix[i][j];
                }
            }
        }
        return copy;
    }
}
