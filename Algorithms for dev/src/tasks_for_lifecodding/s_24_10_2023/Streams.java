package tasks_for_lifecodding.s_24_10_2023;

public class Streams {


    public static void main(String[] args) {
    }

/*
    class Department{
        private String name;
        private List<Employee>;
    }

   class Employee{
        private String firstname;
        private String lastname;
        private int salary;
   }
*/

//1. Собрать статистику по зарплатам сотрудников в заданном подразделении. count, sum, max, min, avg

//как отработает следующий код
//    final List<String> list = Stream.of("b", "a", "d", "c")
//            .map(val -> val + "t")
//            .toList();
//list.add("w");
//System.out.println(list.size());


//2. Посчитать количество вхождений символов в строку используя стримы.
// public Map<String, Integer> countChars(String randomChars){}


//3. Что выведет?  Дано: List<Integer> integers = List.of(3, 2, 1);
//3.1        integers.stream()
//                .peek(System.out::println);

//3.2        integers.stream()
//                .peek(System.out::println)
//                .forEachOrdered(System.out::println);
//

//3.3        integers.stream()
//                .peek(System.out::println)
//                .sorted()
//                .forEach(System.out::println);


//4       Дан массив ints. Что здесь не так?
//        int[] values = {1, 4, 9, 16};
//        var stream = Stream.of(values);
//        stream.forEach(item -> System.out.println(item));

//5
//  Напишите функцию, которая принимает на вход массив состоящий из последовательности чисел,
//  первое из которых является количеством последующих элементов, которые нужно поместить в массив,
//  а за ней следуют элементы этого массива, и возвращающая отдельные массивы.
//  Например: 3, 4, 0, 2, 1, 2, 2, 4, 5 будет превращено в [4, 0, 2], [2], [4, 5]
//


// 6
// * Дан целочисленный массив. Вернуть наибольший к-элемент
//    Input: nums = [3,2,1,5,6,4], k = 2
//    Output: 5
// */
//public class FindTheKthLargestIntegerInTheArray {
//    public static void main(String[] args) {
//        System.out.println(nLargestNumber(new int[]{3, 6, 7, 10}, 4));
//    }
//
//    public static int nLargestNumber(int[] nums, int n) {
//        Arrays.sort(nums);
//        return nums[nums.length - n];
//    }
//}
}


