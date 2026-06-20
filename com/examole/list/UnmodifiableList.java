package com.examole.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UnmodifiableList {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("one", "two", "three");
        List<String> unmodifiedList = Collections.unmodifiableList(myList);

        System.out.println(unmodifiedList);

        List<Integer> numberList = Arrays.asList(1,2,3,4,5,6,7);
        List<Integer> unmodifiedListNumbers = List.of(1,2,3,4,5,6,7,8,9,10);
       // unmodifiedListNumbers.add(11);
        System.out.println(unmodifiedListNumbers);


    }
}
