package tasks_for_lifecodding.s_24_10_2023;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {


    public static void main(String[] args) {
        Stream<User> userStream = Stream.of(new User());
        List<User> x = userStream.filter(user -> user.getGroups().stream().anyMatch(groups -> groups.getName().startsWith("x"))).toList();
    }



    static class User {

        private String name;
        private Integer age;
        private List<Groups> groups;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public List<Groups> getGroups() {
            return groups;
        }

        public void setGroups(List<Groups> groups) {
            this.groups = groups;
        }
    }

    static class Groups {

        private String name;
        private String description;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
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



