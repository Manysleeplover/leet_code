package РешенныеМнойЗадачи.old.slididngWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        for (int right = 0; right < chars.length; right++) {
            if (!set.contains(chars[right])) {
                set.add(chars[right]);
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                while(set.contains(chars[right])){
                    set.remove(chars[left]);
                    left++;
                };
                set.add(chars[right]);
            }
        }
        return maxLength;
    }
}
