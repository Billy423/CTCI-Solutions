/*
 * Question 1.4:
 *  Given a string, check if it is a permutation of a palindrome.
 */
import solutions.TestUtils;

public class ParlindromePermutation {

    // Method: Count character frequencies, palindrome can have at most one odd frequency
    // Time: O(n), Space: O(1)
    static boolean isParlindromPermutation(String str) {
        str = str.toLowerCase();

        int[] fre = new int[26];
        for (int i = 0; i < str.length(); i++) {
            if (Character.isAlphabetic(str.charAt(i))) fre[str.charAt(i) - 'a']++;
        }

        boolean hasOdd = false;
        for (int f: fre) {
            if (f % 2 == 1) {
                if (hasOdd) {
                    return false;
                } else { // find first occurrence
                    hasOdd = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Test cases for PalindromePermutation problem
        TestUtils.reset();
        
        TestUtils.testBoolean("Valid permutation", isParlindromPermutation("ca re rac"), true);
        TestUtils.testBoolean("Not valid", isParlindromPermutation("hello"), false);
        TestUtils.testBoolean("Empty string", isParlindromPermutation(""), true);
        TestUtils.testBoolean("Single char", isParlindromPermutation("a"), true);
        TestUtils.testBoolean("All same", isParlindromPermutation("aaaa"), true);
        TestUtils.testBoolean("Case sensitivity", isParlindromPermutation("Aa"), true);
        TestUtils.testBoolean("With spaces", isParlindromPermutation("taco cat"), true);
        TestUtils.testBoolean("One odd frequency", isParlindromPermutation("aabbccd"), true);
        
        TestUtils.printSummary();
    }

}
