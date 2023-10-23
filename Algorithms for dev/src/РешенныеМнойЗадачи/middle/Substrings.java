package РешенныеМнойЗадачи.middle;

import java.util.*;

/**
 * На вход подается строка. Нужно определить длину наибольшей подстроки,
 * которая не содержит повторяющиеся символы
 * Подстрока - непустая связанная последовательность символов.
 * <p>
 * Первое решение - идти по проверяемой строке А
 * <p>
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/solutions/3649636/3-method-s-c-java-python-beginner-friendly/
 */
public class Substrings {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(mapLengthOfLongestSubstring("pwwkew"));
    }

    /**
     * решение с использование MAP
     */
    public static int mapLengthOfLongestSubstring(String s) {
        // Мапа, которая состоит из ключа - символа и строки текущего актуального индекса
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int size = s.length();
        int maxSize = 0;

        for (int right = 0; right < size; right++) {
            if (!map.containsKey(s.charAt(right)) || map.get(s.charAt(right)) < left) {
                map.put(s.charAt(right), right);
                maxSize = Math.max(maxSize, right - left + 1);
            } else {
                left = map.get(s.charAt(right)) + 1;
                map.put(s.charAt(right),right);
            }
        }
        return maxSize;
    }


    /**
     * решение с использование Set
     */
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> characterSet = new HashSet<>();
        int left = 0;
        int size = s.length();
        int maxSize = 0;

        for (int right = 0; right < size; right++) {
            if (!characterSet.contains(s.charAt(right))) {
                characterSet.add(s.charAt(right));
                maxSize = Math.max(maxSize, right - left + 1);
            } else {
                while (characterSet.contains(s.charAt(right))) {
                    characterSet.remove(s.charAt(left));
                    left++;
                }
                characterSet.add(s.charAt(right));
            }
        }
        return maxSize;
    }
}