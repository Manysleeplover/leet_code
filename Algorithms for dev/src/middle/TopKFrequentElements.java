package middle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{-1,-1}, 1)));
    }

    /**
     * Решаем с помощью мапы
     */
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] ints = new int[k];
        AtomicInteger counter = new AtomicInteger();
        map.entrySet()
                .stream()
                .sorted((item1, item2) -> Integer.compare(item2.getValue(), item1.getValue()))
                .map(Map.Entry::getKey)
                .limit(k)
                .forEach(integer -> {
                    ints[counter.get()] = integer;
                    counter.getAndIncrement();
                });
        return ints;
    }
}
