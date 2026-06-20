package com.examole.list;

import javax.swing.text.html.HTMLDocument;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestCopyOnWriteArrayList {
    public static void main(String[] args) {

        CopyOnWriteArrayList<Integer> numbers = new CopyOnWriteArrayList<>(Arrays.asList(1,3,5,8));
        Iterator<Integer> iterator = numbers.iterator();
        numbers.add(15);
        LinkedList<Integer> result1 = new LinkedList<>();
        iterator.forEachRemaining(result1::add);
        System.out.println(result1);

        Iterator<Integer> iterator2 = numbers.iterator();
        LinkedList<Integer> result2 = new LinkedList<>();
        iterator2.forEachRemaining(result2::add);
        System.out.println(result2);


        


    }
}
