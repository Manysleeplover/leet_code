package РешенныеМнойЗадачи.old.easy;

import java.util.*;

/**
 * Учитывая целочисленный массив nums, переместите все 0элементы в конец, сохраняя относительный порядок ненулевых элементов.
 *
 * Обратите внимание, что вы должны сделать это на месте, не копируя массив.
 *
 *Пример 1:
 *
 * Ввод: числа = [0,1,0,3,12]
 *  Вывод: [1,3,12,0,0]
 * Пример 2:
 *
 * Ввод: числа = [0]
 *  Вывод: [0]
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};

        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));


//        moveZeroes(nums);
//        System.out.println(Arrays.toString(nums));
    }

    private static void moveZeroes(int[] nums) {
        int pointer = 0;

        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] != 0)
            {
                nums[pointer] = nums[i];
                pointer++;
            }
        }


        while(pointer < nums.length)
        {
            nums[pointer] = 0;
            pointer++;
        }
    }


    /**
     * O(n)
     */
//    public static void moveZeroes(int[] nums) {
//        int zeroIdx = -1;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0 && zeroIdx == -1) {
//                zeroIdx = i;
//            } else if (nums[i] != 0 && zeroIdx != -1) {
//                nums[zeroIdx] = nums[i];
//                nums[i] = 0;
//                zeroIdx++;
//            }
//        }
//    }

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
