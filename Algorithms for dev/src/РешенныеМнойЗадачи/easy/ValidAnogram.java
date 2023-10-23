package РешенныеМнойЗадачи.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/valid-anagram/
 */
public class ValidAnogram {
    public static void main(String[] args) {
        System.out.println(isAnagram("aacc", "ccac"));
    }

    public static boolean isAnagram(String s, String t) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        char[] chars1 = t.toCharArray();
        Arrays.sort(chars1);
        return new String(chars).equals(new String(chars1));
    }
}
