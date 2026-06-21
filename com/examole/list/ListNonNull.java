package com.examole.list;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ListNonNull {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,null,4,5,6,null,7,8,9);
        List<Integer> list1 = list.parallelStream().filter(Objects::nonNull)
                .toList();
        System.out.println(list1);
        List<Integer> list2 = Arrays.asList(1,2,null,4,5,6,null,7,8,9);
        List<Integer>list3 = list2.stream()
                .filter(Objects::nonNull)
                .toList();
        System.out.println(list3);

    }
}
