package РешенныеМнойЗадачи.old.binarySearch;

/**
 *  https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/submissions/
 */
public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 1, 2}));
    }

    // Найти минимальное число в перевёрнутом массиве
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] > nums[right]) {
                min = Integer.min(min, nums[right]);
                left = middle + 1;
            } else if (nums[middle] < nums[left]) {
                min = Integer.min(min, nums[middle]);
                right = middle - 1;
            } else {
                min = Integer.min(min, nums[left]);
                right = middle - 1;
            }
        }

        return min;
    }
}
