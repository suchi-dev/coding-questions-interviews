package com.examole.prefixsums;
import java.util.Map;
import java.util.HashMap;

public class PrefixSumEqualsK {

    public static void main(String[] args) {
        int [] arr = {3,4,7,2,-3,1,4,2};
        int count = calculatePrefixSum(arr, 7);
        System.out.println("The number of sub arrays are : "+count);
    }

    public  static int calculatePrefixSum(int [] arr, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);

        int sum =0, count = 0;
        for(int i =0; i < arr.length; i++){
            sum += arr[i];

            count += prefixSum.getOrDefault(sum -k, 0 );
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }

        return count;


    }
}
