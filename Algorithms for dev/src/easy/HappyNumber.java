package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/happy-number/submissions/1060703281/
 */
public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    private static final Set<Integer> integers = new HashSet<>();
    public static boolean isHappy(int n) {
        integers.add(n);
        double counter = 0;
        while (n > 0) {
            counter += Math.pow(n % 10, 2);
            n = n / 10;
        }
        if(integers.contains((int)counter)){
            return false;
        }
        if(counter==1){
            return true;
        }
        return isHappy((int) counter);
    }
}
