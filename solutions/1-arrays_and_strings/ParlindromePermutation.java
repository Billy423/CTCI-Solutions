/*
 * Question 1.4:
 *  Given a string, check if it is a permutation of a palindrome.
 */
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
        
        // Test 1: Valid palindrome permutation
        System.out.println("Test 1 - Valid permutation: " + isParlindromPermutation("ca re rac") + " (expected: true)");
        
        // Test 2: Not a palindrome permutation
        System.out.println("Test 2 - Not valid: " + isParlindromPermutation("hello") + " (expected: false)");
        
        // Test 3: Empty string
        System.out.println("Test 3 - Empty string: " + isParlindromPermutation("") + " (expected: true)");
        
        // Test 4: Single character
        System.out.println("Test 4 - Single char: " + isParlindromPermutation("a") + " (expected: true)");
        
        // Test 5: All same characters
        System.out.println("Test 5 - All same: " + isParlindromPermutation("aaaa") + " (expected: true)");
        
        // Test 6: Case sensitivity
        System.out.println("Test 6 - Case sensitivity: " + isParlindromPermutation("Aa") + " (expected: true)");
        
        // Test 7: With spaces
        System.out.println("Test 7 - With spaces: " + isParlindromPermutation("taco cat") + " (expected: true)");
        
        // Test 8: One odd frequency (valid palindrome)
        System.out.println("Test 8 - One odd frequency: " + isParlindromPermutation("aabbccd") + " (expected: true)");
    }

}
