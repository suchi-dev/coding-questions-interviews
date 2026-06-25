package com.examole.slidingwindow;

public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int [] nums = {1,1,0,1,1,1};
        int res = calculateMaxConsOnes(nums);
        System.out.println("The maximum number of consecutive ones are : "+res);
    }

    public  static int calculateMaxConsOnes(int [] nums){
        int res = 0, cnt = 0;
        for(int num : nums){
            cnt = num == 1 ? cnt + 1: 0;
            res = Math.max(res, cnt);
        }

        return res;
    }
}
