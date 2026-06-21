package com.examole.list;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TestRandom {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        Random rand = new Random();
        int number = list1.get(rand.nextInt(list1.size()));
        System.out.println("Random number selected : "+ number);
    }
}
