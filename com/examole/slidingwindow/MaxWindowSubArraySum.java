package com.examole.slidingwindow;

public class MaxWindowSubArraySum {

    public static void main(String[] args) {
        int [] nums = new int[] {2,1,5,1,3,2};
        int k = 3;
        int maxSum = maxSubArraySum(nums, k);
        System.out.println("The maximum sub array sum is : "+maxSum);
    }

    public static int maxSubArraySum(int [] nums, int k){
        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        int currSum = 0;
        for(int end = 0; end < nums.length; end++){
            currSum += nums[end];
            if(end - start + 1 == k){
                maxSum = Math.max(currSum,maxSum);
                currSum -= nums[start];
                start++;
            }
        }
        return maxSum;
    }
}
