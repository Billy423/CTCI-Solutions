/*
 * Question 1.5:
 *  Given two strings, check if they are one edit away (insert, delete, or replace one character).
 */
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
        
        // Test 1: Insert operation (pale -> ple)
        System.out.println("Test 1 - Insert: " + isOneEditAway("pale", "ple")); // true
        
        // Test 2: Delete operation (pale -> pal)
        System.out.println("Test 2 - Delete: " + isOneEditAway("pale", "pal")); // true
        
        // Test 3: Replace operation (pale -> bale)
        System.out.println("Test 3 - Replace: " + isOneEditAway("pale", "bale")); // true
        
        // Test 4: Same strings
        System.out.println("Test 4 - Same: " + isOneEditAway("pale", "pale")); // true
        
        // Test 5: More than one edit (pale -> bake)
        System.out.println("Test 5 - Multiple edits: " + isOneEditAway("pale", "bake")); // false
        
        // Test 6: Length difference > 1
        System.out.println("Test 6 - Length diff > 1: " + isOneEditAway("pale", "pa")); // false
        
        // Test 7: Empty string cases
        System.out.println("Test 7 - Empty to single: " + isOneEditAway("", "a")); // true
        System.out.println("Test 8 - Single to empty: " + isOneEditAway("a", "")); // true
        
        // Test 9: Edge case - single character
        System.out.println("Test 9 - Single char: " + isOneEditAway("a", "b")); // true
        
        // Test 10: Insert at beginning
        System.out.println("Test 10 - Insert at start: " + isOneEditAway("ale", "pale")); // true
        
        // Test 11: Insert at end
        System.out.println("Test 11 - Insert at end: " + isOneEditAway("pal", "pale")); // true
        
        // Test 12: Delete from beginning
        System.out.println("Test 12 - Delete from start: " + isOneEditAway("pale", "ale")); // true
        
        // Test 13: Delete from end
        System.out.println("Test 13 - Delete from end: " + isOneEditAway("pale", "pal")); // true
        
        // Test 14: Replace at beginning
        System.out.println("Test 14 - Replace at start: " + isOneEditAway("pale", "sale")); // true
        
        // Test 15: Replace at end
        System.out.println("Test 15 - Replace at end: " + isOneEditAway("pale", "pals")); // true
        
        // Test 16: Two different characters
        System.out.println("Test 16 - Two different: " + isOneEditAway("abc", "def")); // false
        
        // Test 17: Case sensitivity
        System.out.println("Test 17 - Case sensitivity: " + isOneEditAway("Pale", "pale")); // true
    }
    
}
