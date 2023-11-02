package tasks_for_lifecodding.s_24_10_2023;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {


    public static void main(String[] args) {
        // Напишите программу для вывода чисел, которые встречаются больше одного раза в формате k=v
        Map<Integer, String> collect = Stream.of("swtt5fs9dg", "sd1fs7df", "sd2gwert7dg")
                .collect(Collectors
                        .groupingBy(string -> string
                                        .chars()
                                        .filter(Character::isDigit)
                                        .mapToObj(Character::toChars)
                                        .mapToInt(ch -> Integer.parseInt(String.valueOf(ch))).sum(),
                                TreeMap::new,
                                Collectors.mapping(string -> string
                                        .chars()
                                        .filter(value -> !Character.isDigit(value))
                                        .mapToObj(Character::toChars)
                                        .map(String::valueOf).collect(Collectors.joining()), Collectors.joining())));
        System.out.println(collect);
    }
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



