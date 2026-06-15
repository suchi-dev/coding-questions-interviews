package com.examole.list;

import java.util.*;

public class ListEg {
    public static void main(String[] args) {
        String [] arr =  { "apple", "banana", "chikoo", "orange", "papaya"};
        // convert to a Linked list

        List<String> myList = Arrays.asList(arr);
        LinkedList<String> myLinkedList = new LinkedList<>(myList);

        Iterator<String> it = myLinkedList.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        // another way of converting arr to a ll

        LinkedList<String> myFruits = new LinkedList<>();
        Collections.addAll(myFruits, arr);

        Iterator<String> it1 = myFruits.iterator();
        while(it1.hasNext()){
            System.out.println("------2nd iteration------");
            System.out.println(it1.next());
        }
    }
}
