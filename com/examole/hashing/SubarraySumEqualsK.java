package com.examole.hashing;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        int [] nums = new int[] {2, -1, 1, 2};
        int numberOfSubArraySums = subArraySum(nums, 2);
        System.out.println("The result is : "+numberOfSubArraySums);

    }

    public static int subArraySum(int [] nums, int k) {
        int res = 0, currSum = 0;
        Map<Integer, Integer> myMap = new HashMap<>();
        myMap.put(0, 1);
        for(int num : nums) {
            currSum += num;
            int diff = currSum - k;
            res +=myMap.getOrDefault(diff, 0);
            myMap.put(currSum, myMap.getOrDefault(currSum, 0 ) + 1);
        }

        return  res;

    }
}
