package РешенныеМнойЗадачи.old.middle;

import java.util.*;

/**
 * https://leetcode.com/problems/group-anagrams/description/
 */
public class GroupAnagram {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String s = sortString(str);
            List<String> strings;
            if (!map.containsKey(s)) {
                strings = new ArrayList<>();
            } else {
                strings = map.get(s);
            }
            strings.add(str);
            map.put(s, strings);
        }
        return new ArrayList<>(map.values());
    }


    public static String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return String.copyValueOf(chars);
    }


//    public static boolean isAnagram(String s, String t) {
//        char[] chars = s.toCharArray();
//        Arrays.sort(chars);
//        char[] chars1 = t.toCharArray();
//        Arrays.sort(chars1);
//        return new String(chars).equals(new String(chars1));
//    }
}
