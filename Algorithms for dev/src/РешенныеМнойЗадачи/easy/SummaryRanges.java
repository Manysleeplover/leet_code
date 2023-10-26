package РешенныеМнойЗадачи.easy;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 Вам дан отсортированный уникальный целочисленный массив nums.

 Диапазон — [a,b] это набор всех целых чисел от aдо b(включительно).

 Возвращает наименьший отсортированный список диапазонов, который точно охватывает все числа в массиве . То есть каждый элемент numsохватывается ровно одним из диапазонов, и не существует целого числа x, xнаходящегося в одном из диапазонов, но не в nums.

 Каждый диапазон [a,b]в списке должен выводиться как:

 "a->b"еслиa != b
 "a"еслиa == b

 Ввод: nums = [0,1,2,4,5,7]
 Вывод: ["0->2","4->5","7"]
 Объяснение: Диапазоны:
 [0,2] - -> "0->2"
 [4,5] --> "4->5"
 [7,7] --> "7"
 *
 * https://leetcode.com/problems/summary-ranges/
 */
public class SummaryRanges {
    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{1,2,4,5,6,8,9,10}));
    }



    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        int right = 1;

        for (int left = 0; left < nums.length-1; left++) {
            if(nums[left] != nums[right] - 1){
                result.add(String.valueOf(nums[left]));
            } else {
                result.add(nums[right] + "->");
            }
            right++;
        }


        return result;
    }
}
