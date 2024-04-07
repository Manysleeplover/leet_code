package РешенныеМнойЗадачи.old.binarySearch;

// https://leetcode.com/problems/binary-search/

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }

    public static int search(int[] nums, int target) {
        int left = 0; // initialize left pointer to 0
        int right = nums.length - 1; // initialize right pointer to the last index of the array

        while (left <= right) { // continue the loop till left pointer is less than or equal to right pointer
            int mid = left + (right - left) / 2; // calculate the РешенныеМнойЗадачи.old.middle index of the array

            if (nums[mid] == target) { // check if the РешенныеМнойЗадачи.old.middle element is equal to target
                return mid; // return the РешенныеМнойЗадачи.old.middle index
            } else if (nums[mid] < target) { // check if the РешенныеМнойЗадачи.old.middle element is less than target
                left = mid + 1; // move the left pointer to the right of РешенныеМнойЗадачи.old.middle element
            } else { // if the РешенныеМнойЗадачи.old.middle element is greater than target
                right = mid - 1; // move the right pointer to the left of РешенныеМнойЗадачи.old.middle element
            }
        }

        return -1; // target not found in the array
    }

}
