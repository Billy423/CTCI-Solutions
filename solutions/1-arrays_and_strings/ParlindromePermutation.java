/*
 * Question 1.4:
 *  Given a string, check if it is a permutation of a palindrome.
 */
public class ParlindromePermutation {

    // O(n) time, O(26) space
    static boolean isParlindromPermutation(String str) {
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

        String str = "ca re rac";
        System.out.println(isParlindromPermutation(str));

    }

}
