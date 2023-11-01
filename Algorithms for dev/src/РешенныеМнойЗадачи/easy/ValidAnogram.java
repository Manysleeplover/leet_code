package РешенныеМнойЗадачи.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/valid-anagram/
 *
 * Даны две строки s и t. Верните, true если t является анаграммой s, и false в противном случае.
 *
 * Анаграмма — это слово или фраза, образованная перестановкой букв другого слова или фразы, обычно с использованием всех исходных букв ровно один раз .
 *
 *
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
