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
}
