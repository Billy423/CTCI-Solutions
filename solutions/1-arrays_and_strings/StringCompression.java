/*
 * Question 1.6:
 *  Implement a method to perform basic string compression using the counts of repeated characters.
 *  If the compressed string would not become smaller than the original, return the original string.
 */
import solutions.TestUtils;

public class StringCompression {
    
    // Method: Count consecutive characters and build compressed string
    // Time: O(n), Space: O(n)
    public static String compress(String str) {
        
        if (str.length() <= 1) return str;

        StringBuilder builder = new StringBuilder();
        int i = 0, n = str.length();
        
        while (i < n) {
            char cur = str.charAt(i);
            int count = 1;

            // Count consecutive characters
            while (i + count < n && str.charAt(i + count) == cur) count++;
            
            builder.append(cur).append(count);
            i += count;
        }

        return builder.length() < str.length() ? builder.toString() : str;
    }

    public static void main(String[] args) {
        // Test cases for StringCompression problem
        TestUtils.reset();
        
        TestUtils.testString("Basic compression", compress("aaabbbccc"), "a3b3c3");
        TestUtils.testString("Mixed case", compress("aabcccccaaa"), "a2b1c5a3");
        TestUtils.testString("No compression", compress("aabbcc"), "aabbcc");
        TestUtils.testString("Single char", compress("a"), "a");
        TestUtils.testString("Empty string", compress(""), "");
        TestUtils.testString("All same", compress("aaaaa"), "a5");
        TestUtils.testString("Two chars", compress("ab"), "ab");
        TestUtils.testString("Long compression", compress("aaaaaaaaaa"), "a10");
        
        TestUtils.printSummary();
    }
}
