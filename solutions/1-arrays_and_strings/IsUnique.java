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
        
        // Test 1: All unique characters
        System.out.println("Test 1 - All unique: " + isUnique("abcdefg") + " (expected: true)");
        
        // Test 2: Has duplicates
        System.out.println("Test 2 - Has duplicates: " + isUnique("hellothere") + " (expected: false)");
        
        // Test 3: Empty string
        System.out.println("Test 3 - Empty string: " + isUnique("") + " (expected: true)");
        
        // Test 4: Single character
        System.out.println("Test 4 - Single char: " + isUnique("a") + " (expected: true)");
        
        // Test 5: All same characters
        System.out.println("Test 5 - All same: " + isUnique("aaaa") + " (expected: false)");
        
        // Test 6: Case sensitivity
        System.out.println("Test 6 - Case sensitivity: " + isUnique("Hello") + " (expected: true)");
        
        // Test 7: Non-alphabetic characters
        System.out.println("Test 7 - With numbers: " + isUnique("abc123") + " (expected: true)");
        
        // Test 8: Duplicates at end
        System.out.println("Test 8 - Duplicates at end: " + isUnique("abcdefgg") + " (expected: false)");
    }
}