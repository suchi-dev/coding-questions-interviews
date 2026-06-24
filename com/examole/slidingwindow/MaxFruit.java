package com.examole.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MaxFruit {

    public static void main(String[] args) {
        int [] fruits = new int [] {3,3,2,1,2,1,0};
        int maxDistinctFruits = calculateMaxFruit(fruits);
        System.out.println("Max sub array length is : "+maxDistinctFruits);
    }

    public static int calculateMaxFruit(int [] fruits) {
        int maxFruits = 0;
        int start = 0;
        Map<Integer, Integer> basket = new HashMap<>();
        for(int end = 0; end < fruits.length; end++){
            basket.put(fruits[end], basket.getOrDefault(fruits[end], 0) + 1);

            while(basket.size() > 2){
                basket.put(fruits[start], basket.get(fruits[start]) - 1);
                if(basket.get(fruits[start]) == 0){
                    basket.remove(fruits[start]);
                }
                start++;
            }
            maxFruits = Math.max(end - start +1 , maxFruits);

        }
        return maxFruits;


    }
}
