package easy;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/group-anagrams/
 */
public class FindTheKthLargestIntegerInTheArray {
    public static void main(String[] args) {
        System.out.println(kthLargestNumber(new String[]{"3", "6", "7", "10"}, 4));
    }

    public static String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, Comparator.comparing(BigInteger::new));
        return nums[nums.length - k];
    }
}
