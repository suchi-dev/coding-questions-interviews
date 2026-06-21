package com.examole.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class ListDuplicates {
    public static void main(String[] args) {
        List<Integer> listWithDuplicates = Arrays.asList(1,2,3,4,1,2,3,5,6,7,8);

        // preserves the order so we use LinkedHashSet
        List<Integer> listWithoutDuplicates = new ArrayList<>(new LinkedHashSet<>(listWithDuplicates));
        System.out.println(listWithoutDuplicates);

        //using streams
        List<Integer> listWithoutDuplicates1 = listWithDuplicates.stream()
                .distinct().toList();
        System.out.println(listWithoutDuplicates1);






    }
}
