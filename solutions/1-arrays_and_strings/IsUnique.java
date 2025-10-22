import java.util.Arrays;

/*
 * Question 1.1:
 *  Implement an algorithm to determine if a string has
 *  all unique characters.
 */
public class IsUnique {


    // O(n) time, O(1) space solution using BitSet
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

     // O(nlogn) time, O(1) solution using in-place sorting
    static boolean isUniqueSorting(String str) {
        Arrays.sort(str.toCharArray());
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        String str1 = "abcdefg";
        System.out.println(isUnique(str1));

        String str2 = "hellothere";
        System.out.println(isUnique(str2));

    }
}