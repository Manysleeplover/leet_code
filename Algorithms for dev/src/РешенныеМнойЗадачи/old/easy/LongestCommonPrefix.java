package РешенныеМнойЗадачи.old.easy;

/**
 *https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(sortLongestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    public static String sortLongestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    public static String longestCommonPrefix(String[] strs) {
        char[] chars = strs[0].toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < chars.length; i++) {
            if (!flag) {
                break;
            }
            stringBuilder.append(chars[i]);
            for (String str : strs) {
                if (!str.matches(stringBuilder + "(.*)")) {
                    flag = false;
                    stringBuilder.deleteCharAt(i);
                    break;
                }
            }
        }
        return stringBuilder.toString();
    }
}
