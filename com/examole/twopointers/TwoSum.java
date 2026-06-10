package com.examole.twopointers;

public class TwoSum {

    public static void main(String[] args) {
        int [] nums = new int[] {1,3,4,6,8,10,13};
        boolean result = calculateTwoSum(nums, 13);
        System.out.println("The result is : "+result);
    }

    public static boolean calculateTwoSum(int [] nums, int target){
        int l = 0;
        int r = nums.length -1;

        while(l < r){
            int currSum = nums[l] + nums[r];
            if(currSum == target) {
                return  true;
            }else if(currSum < target){
                l++;
            }else {
                r--;
            }
        }

        return  false;
    }
}
