package РешенныеМнойЗадачи.arrays_and_hashing;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        char[] sA = s.toCharArray();
        Arrays.sort(sA);
        char[] tA = t.toCharArray();
        Arrays.sort(tA);

        for (int i = 0; i < sA.length; i++) {
            if (sA[i] != tA[i]){
                return false;
            }
        }

        return true;
    }
}
