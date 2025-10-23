import java.util.HashMap;
import java.util.Map;
/*
 * Question 1.2:
 *  Given two strings, determine if one is a permutation of another.
 */
import solutions.TestUtils;

public class CheckPermutation {

    // Method: Count character frequencies in first string, then decrement for second string
    // Time: O(n), Space: O(n)
    static boolean isPermuation(String str1, String str2) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i), 0) + 1);
        }

        for (int i = 0; i < str2.length(); i++) {
            Integer fre = map.get(str2.charAt(i));
            if (fre == null) return false;

            if (fre == 1) {
                map.remove(str2.charAt(i));
            } else {
                map.put(str2.charAt(i), fre - 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Test cases for CheckPermutation problem
        TestUtils.reset();
        
        TestUtils.testBoolean("Valid with duplicates", isPermuation("aabcdee", "aeaebcd"), true);
        TestUtils.testBoolean("Different chars", isPermuation("aabcdee", "abcdefg"), false);
        TestUtils.testBoolean("Same strings", isPermuation("hello", "hello"), true);
        TestUtils.testBoolean("Different lengths", isPermuation("abc", "abcd"), false);
        TestUtils.testBoolean("Empty strings", isPermuation("", ""), true);
        TestUtils.testBoolean("Single char", isPermuation("a", "a"), true);
        TestUtils.testBoolean("Case sensitivity", isPermuation("Hello", "hello"), false);
        TestUtils.testBoolean("Simple valid", isPermuation("abc", "bca"), true);
        
        TestUtils.printSummary();
    }

}
