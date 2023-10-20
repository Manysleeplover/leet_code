package middle;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{1, 2, 0, 1}));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int left = 0;
        int maxLength = 1;
        int localLength = 1;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] - nums[left] == 1) {
                localLength++;
                maxLength = Math.max(maxLength, localLength);
            } else {
                if (nums[right] != nums[left]) {
                    localLength = 1;
                }
            }
            left++;
        }
        return maxLength;
    }
}
