package РешенныеМнойЗадачи.arrays_and_hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4}, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] ints = new int[2];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int targetValue = target - nums[i];
            if(map.containsKey(targetValue) && map.get(targetValue) != i){
                ints[0] = i;
                ints[1] = map.get(targetValue);
                break;
            }
        }


        return ints;
    }
}
