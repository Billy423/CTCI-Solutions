import java.util.HashMap;
import java.util.Map;
/*
 * Question 1.2:
 *  Given two strings, determine if one is a permutation of another.
 */
public class CheckPermutation {

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

        String str1 = "aabcdee";
        String str2 = "aeaebcd";
        String str3 = "abcdefg";
        System.out.println(isPermuation(str1, str2));
        System.out.println(isPermuation(str1, str3));

    }

}
