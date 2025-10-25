import solutions.TestUtils;

/*
 * Question 1.9:
 *  Assume you have a method isSubstring which checks if one word is a substring
 *  of another. Given two strings, s1 and s2, write code to check if s2 is a
 *  rotation of s1 using only one call to isSubstring.
 */
public class StringRotation {
    
    // Method: Concatenate s1 with itself and check if s2 is substring
    // Time: O(n), Space: O(n)
    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        return isSubstring(s1 + s1, s2);
    }

    private static boolean isSubstring(String s1, String s2) {
        return s1.contains(s2);
    }

    public static void main(String[] args) {
        
        TestUtils.reset();
        
        TestUtils.testBoolean("Basic rotation", isRotation("waterbottle", "erbottlewat"), true);
        TestUtils.testBoolean("Same string", isRotation("hello", "hello"), true);
        TestUtils.testBoolean("Not a rotation", isRotation("hello", "world"), false);
        TestUtils.testBoolean("Different lengths", isRotation("hello", "helloworld"), false);
        TestUtils.testBoolean("Empty strings", isRotation("", ""), true);
        TestUtils.testBoolean("Single character", isRotation("a", "a"), true);
        TestUtils.testBoolean("Single character different", isRotation("a", "b"), false);
        TestUtils.testBoolean("Palindrome rotation", isRotation("racecar", "carrace"), true);
        TestUtils.testBoolean("All same characters", isRotation("aaaa", "aaaa"), true);
        TestUtils.testBoolean("Partial match", isRotation("abcdef", "defabc"), true);
        TestUtils.testBoolean("No common characters", isRotation("abc", "xyz"), false);
        TestUtils.testBoolean("Case sensitivity", isRotation("Hello", "elloH"), true);
        TestUtils.testBoolean("With spaces", isRotation("hello world", "world hello"), false);
        TestUtils.testBoolean("Numbers", isRotation("12345", "34512"), true);
        TestUtils.testBoolean("Special characters", isRotation("a!b@c", "c!a!b"), false);
        
        TestUtils.printSummary();
    }

}
