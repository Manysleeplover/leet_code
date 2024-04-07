package РешенныеМнойЗадачи.old.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 * Дан целочисленный массив. Вернуть наибольший к-элемент
 *
 */
public class FindTheKthLargestIntegerInTheArray {
    public static void main(String[] args) {
        System.out.println(kthLargestNumber(new int[]{3, 6, 7, 10}, 4));
    }

    public static int kthLargestNumber(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
