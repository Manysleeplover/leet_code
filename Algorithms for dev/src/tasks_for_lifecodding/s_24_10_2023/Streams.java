package tasks_for_lifecodding.s_24_10_2023;

import java.util.List;

public class Streams {


    public static void main(String[] args) {
        List<Integer> integers = List.of(3, 2, 1);
        integers.stream()
                .peek(System.out::println);
        System.out.println();

        integers.stream()
                .peek(System.out::println)
                .forEachOrdered(System.out::println);
        System.out.println();


        integers.stream()
                .peek(System.out::println)
                .sorted()
                .forEach(System.out::println);
    }



//6
//  Напишите функцию, которая принимает на вход массив состоящий из последовательности чисел,
//  первое из которых является количеством последующих элементов, которые нужно поместить в массив,
//  а за ней следуют элементы этого массива, и возвращающая отдельные массивы.
//  Например: 3, 4, 0, 2, 1, 2, 2, 4, 5 будет превращено в [4, 0, 2], [2], [4, 5]
//


// 7
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
//    }
//}

//8
// Дан массив int[] arr = new int[]{1,2,3,4,5,6,7,8,9}
// Вывести только нечётный элементы массива


}


