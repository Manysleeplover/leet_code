package РешенныеМнойЗадачи.middle;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 */
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }

    public static int[] productExceptSelf(int[] nums) {
        short prod = 1;
        boolean flag = false;
        for (int num : nums) {
            if (num != 0) {
                prod *= num;
            } else {
                if (flag){
                    Arrays.fill(nums,0);
                    return nums;
                }
                flag = true;
            }
        }
        int[] answer = new int[nums.length];
        Arrays.fill(answer, prod);
        for (int i = 0; i < answer.length; i++) {
            if (nums[i] != 0)
                if (flag) {
                    answer[i] = 0;
                } else {
                    answer[i] = prod / nums[i];
                }
        }
        return answer;
    }
}

