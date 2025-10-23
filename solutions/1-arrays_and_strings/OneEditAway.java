/*
 * Question 1.5:
 *  Given two strings, check if they are one edit away (insert, delete, or replace one character).
 */
import solutions.TestUtils;

public class OneEditAway {
    
    // Method: Handle three cases - replace (same length), insert/delete (length diff = 1)
    // Time: O(n), Space: O(1)
    static boolean isOneEditAway(String str1, String str2) {
        
        // Special case: 2 strings are equal
        if (str1.equals(str2)) return true;

        if (str1.length() < str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }

        if (str1.length() == str2.length()) { // must be replace
            return isReplaced(str1, str2);
        }
        
        // Must be either insert or delete
        if (str1.length() != str2.length() + 1) return false;
        return diffByOne(str1, str2);
    }
    // Helper: Check if strings differ by one character (insert/delete case)
    static boolean diffByOne(String str1, String str2) {
        int i = 0, j = 0, n = str2.length();
        boolean hasFound = false;
        while (j < n) {
            if (str1.charAt(i) != str2.charAt(j)) {
                if (hasFound) return false;
                hasFound = true;
            } else {
                j++;
            }
            i++;
        }
        return true;
    }
    
    // Helper: Check if strings differ by exactly one character (replace case)
    static boolean isReplaced(String str1, String str2) {
        int n = str1.length();
        boolean hasDiffChar = false;
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                if (hasDiffChar) return false;
                hasDiffChar = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Test cases for OneEditAway problem
        TestUtils.reset();
        
        TestUtils.testBoolean("Insert", isOneEditAway("pale", "ple"), true);
        TestUtils.testBoolean("Delete", isOneEditAway("pale", "pal"), true);
        TestUtils.testBoolean("Replace", isOneEditAway("pale", "bale"), true);
        TestUtils.testBoolean("Same strings", isOneEditAway("pale", "pale"), true);
        TestUtils.testBoolean("Multiple edits", isOneEditAway("pale", "bake"), false);
        TestUtils.testBoolean("Length diff > 1", isOneEditAway("pale", "pa"), false);
        TestUtils.testBoolean("Empty to single", isOneEditAway("", "a"), true);
        TestUtils.testBoolean("Single to empty", isOneEditAway("a", ""), true);
        TestUtils.testBoolean("Single char", isOneEditAway("a", "b"), true);
        TestUtils.testBoolean("Insert at start", isOneEditAway("ale", "pale"), true);
        TestUtils.testBoolean("Insert at end", isOneEditAway("pal", "pale"), true);
        TestUtils.testBoolean("Delete from start", isOneEditAway("pale", "ale"), true);
        TestUtils.testBoolean("Delete from end", isOneEditAway("pale", "pal"), true);
        TestUtils.testBoolean("Replace at start", isOneEditAway("pale", "sale"), true);
        TestUtils.testBoolean("Replace at end", isOneEditAway("pale", "pals"), true);
        TestUtils.testBoolean("Two different", isOneEditAway("abc", "def"), false);
        TestUtils.testBoolean("Case sensitivity", isOneEditAway("Pale", "pale"), true);
        
        TestUtils.printSummary();
    }
    
}
