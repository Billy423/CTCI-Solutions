import java.util.HashMap;
import java.util.Map;
/*
 * Question 1.2:
 *  Given two strings, determine if one is a permutation of another.
 */
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
        
        // Test 1: Valid permutation with duplicates
        System.out.println("Test 1 - Valid with duplicates: " + isPermuation("aabcdee", "aeaebcd") + " (expected: true)");
        
        // Test 2: Different characters
        System.out.println("Test 2 - Different chars: " + isPermuation("aabcdee", "abcdefg") + " (expected: false)");
        
        // Test 3: Same strings
        System.out.println("Test 3 - Same strings: " + isPermuation("hello", "hello") + " (expected: true)");
        
        // Test 4: Different lengths
        System.out.println("Test 4 - Different lengths: " + isPermuation("abc", "abcd") + " (expected: false)");
        
        // Test 5: Empty strings
        System.out.println("Test 5 - Empty strings: " + isPermuation("", "") + " (expected: true)");
        
        // Test 6: Single character
        System.out.println("Test 6 - Single char: " + isPermuation("a", "a") + " (expected: true)");
        
        // Test 7: Case sensitivity
        System.out.println("Test 7 - Case sensitivity: " + isPermuation("Hello", "hello") + " (expected: false)");
        
        // Test 8: Valid permutation simple
        System.out.println("Test 8 - Simple valid: " + isPermuation("abc", "bca") + " (expected: true)");
    }

}
