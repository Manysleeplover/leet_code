package easy;

import java.util.*;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};

        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));


//        moveZeroes(nums);
//        System.out.println(Arrays.toString(nums));
    }


    /**
     * O(n)
     */
    public static void moveZeroes(int[] nums) {
        int zeroIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && zeroIdx == -1) {
                zeroIdx = i;
            } else if (nums[i] != 0 && zeroIdx != -1) {
                nums[zeroIdx] = nums[i];
                nums[i] = 0;
                zeroIdx++;
            }
        }
    }

    /**
     * O(n) в квадрате
     */
//    public static void moveZeroes(int[] nums) {
//        int size = nums.length;
//        for (int right = 0; right < size; right++) {
//            if (nums[right] == 0) {
//                for (int j = right; j < size; j++) {
//                    if(nums[j]!=0){
//                        nums[right] = nums[j];
//                        nums[j] = 0;
//                        break;
//                    }
//                }
//            }
//        }
//    }
}
