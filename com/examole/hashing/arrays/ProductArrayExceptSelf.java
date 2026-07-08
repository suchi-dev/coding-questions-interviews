package com.examole.hashing.arrays;

import java.util.Arrays;

public class ProductArrayExceptSelf {
    public static void main(String[] args) {
        int [] nums = new int[]{1,2,4,6};
        int [] res = productArray(nums);
        System.out.println("The result is : ");
        for (int e : res) {
            System.out.println(e);
        }
    }

    public static int[] productArray(int [] nums){
        int n = nums.length;
        int [] res = new int[n];
        res[0] = 1;
        for(int i =1; i < n; i++){
            res[i] = res[i-1] * nums[i-1];
        }

        int postfix = 1;
        for(int i = n -1; i >=0; i--){
            res[i] *=postfix;
            postfix *= nums[i];
        }

        return res;
    }
}
