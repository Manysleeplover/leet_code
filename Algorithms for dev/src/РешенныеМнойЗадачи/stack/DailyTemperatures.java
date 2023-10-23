package РешенныеМнойЗадачи.stack;

import java.util.*;
import java.util.stream.Collector;

public class DailyTemperatures {
    //input: [1, 2, 3, 2, 0], [5, 1, 2, 7, 3, 2, 2]
    //output: [1,2,2,3]
    public static void main(String[] args) throws InterruptedException {
        List<Product> productList = Arrays.asList(new Product(23, "potatoes"),
                new Product(14, "orange"), new Product(13, "lemon"),
                new Product(23, "bread"), new Product(13, "sugar"));

        Collector<Product, ?, LinkedList<Product>> toLinkedList =
                Collector.of(LinkedList::new, LinkedList::add,
                        (first, second) -> {
                            first.addAll(second);
                            return first;
                        });

        LinkedList<Product> linkedListOfPersons =
                productList.stream().collect(toLinkedList);

        System.out.println(linkedListOfPersons);
    }


    public static int[] getRepeatedIntersection(int[] nums1, int[] nums2) {
        int maxResultSize = Math.min(nums1.length, nums2.length);
        int[] result = new int[maxResultSize];
        int successCounter = 0;
        if(maxResultSize == 0){
            return Arrays.copyOf(result, successCounter);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int j = 0;
        for (int k : nums1) {
            if (successCounter == maxResultSize || j >= nums2.length) {
                break;
            }
            while (nums2[j] <= k && (nums2[j] >= k || j < nums2.length - 1)) {
                if (nums2[j] == k) {
                    result[successCounter] = nums2[j];
                    successCounter++;
                    j++;
                    break;
                } else {
                    j++;
                }
            }
        }
        return Arrays.copyOf(result, successCounter);
    }
//    public static int[] getRepeatedIntersection(int[] nums1, int[] nums2) {
//        List<Integer> list2 =  Arrays.stream(nums2).boxed().collect(Collectors.toList());
//        int[] result = new int[Math.min(nums1.length, nums2.length)];
//        int counter = 0;
//        for(Integer itg : nums1){
//            if(list2.contains(itg)){
//                result[counter] = itg;
//                counter++;
//                list2.remove(itg);
//            }
//        }
//        return Arrays.copyOf(result,counter);
//    }


//    public static void main(String[] args) {
//        Map<String, Long> стирнгаа = Optional.ofNullable("Стирнгаа")
//                .map(string -> string.chars().mapToObj(Character::toChars)
//                        .collect(Collectors.groupingBy(String::valueOf, Collectors.counting())))
//                .orElse(Collections.emptyMap());
//        System.out.println(стирнгаа);
//    }

}
