package com.examole.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TestIterator {
    public static void main(String[] args) {
        Iterator<Integer> iterator = Arrays.asList(1,2,3,4,5).iterator();
        List<Integer> actualList = new ArrayList<>();
        while(iterator.hasNext()){
            actualList.add(iterator.next());
        }
        System.out.println(actualList);
        Iterator<Integer> iterator1 = Arrays.asList(100,200,300,400,500).iterator();
        List<Integer> secondList = new ArrayList<>();
        iterator1.forEachRemaining(secondList::add);
        System.out.println(secondList);


    }
}
