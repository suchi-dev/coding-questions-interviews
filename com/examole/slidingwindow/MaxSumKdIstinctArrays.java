package com.examole.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MaxSumKdIstinctArrays {

    public static void main(String[] args) {
        int [] numbers = new int [] {3,2,2,3,4,6,7,7,-1};
        int maxScore =  calculateMaxSumDistinct(numbers, 4);
        System.out.println("The max sum of k distinct subarrays is : "+maxScore);
    }

    public static int calculateMaxSumDistinct(int [] nums, int k){
        int maxSum= Integer.MIN_VALUE;
        int start = 0;
        int currSum = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int end =0; end < nums.length; end++){
            currSum += nums[end];
            freqMap.put(nums[end], freqMap.getOrDefault(nums[end], 0) + 1);
            if(end - start + 1 == k){
                if(freqMap.size() == k){
                    // map has distinct values
                    maxSum = Math.max(maxSum, currSum);
                }

                currSum-= nums[start];
                freqMap.put(nums[start] , freqMap.get(nums[start]) - 1);
                if(freqMap.get(nums[start]) == 0){
                    freqMap.remove(nums[start]);
                }
                start++;
            }

        }
        return maxSum == Integer.MIN_VALUE ? 0 : maxSum;
    }
}
