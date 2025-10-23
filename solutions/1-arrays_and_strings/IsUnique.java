import solutions.TestUtils;
import java.util.Arrays;

/*
 * Question 1.1:
 *  Implement an algorithm to determine if a string has
 *  all unique characters.
 */
public class IsUnique {


    // Method: Use bit manipulation to track character presence
    // Time: O(n), Space: O(1)
    static boolean isUnique(String str) {

        int bitSet = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isAlphabetic(c)) continue;
            int bit = c - 'a';
            if ((bitSet & (1 << bit)) != 0) {
                return false; // duplicate char
            } else {
                bitSet |= (1 << bit); // set bit to 1
            }
        }
        return true;
    }

    // Method: Sort characters and check adjacent duplicates
    // Time: O(nlogn), Space: O(1)
    static boolean isUniqueSorting(String str) {
        Arrays.sort(str.toCharArray());
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Test cases for IsUnique problem
        TestUtils.reset();
        
        TestUtils.testBoolean("All unique", isUnique("abcdefg"), true);
        TestUtils.testBoolean("Has duplicates", isUnique("hellothere"), false);
        TestUtils.testBoolean("Empty string", isUnique(""), true);
        TestUtils.testBoolean("Single char", isUnique("a"), true);
        TestUtils.testBoolean("All same", isUnique("aaaa"), false);
        TestUtils.testBoolean("Case sensitivity", isUnique("Hello"), true);
        TestUtils.testBoolean("With numbers", isUnique("abc123"), true);
        TestUtils.testBoolean("Duplicates at end", isUnique("abcdefgg"), false);
        
        TestUtils.printSummary();
    }
}