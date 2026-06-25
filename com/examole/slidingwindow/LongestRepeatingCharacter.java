package com.examole.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacter {



    public static void main(String[] args) {
    String s = "BBABCCDD";
    int maxLen = calculateMaxLongestRepeating(s, 2);
    System.out.println("The longest repeating character substring is : " +maxLen);
    }

    public static int calculateMaxLongestRepeating(String s , int k) {
        int start = 0;
        int maxLen = 0;
        int maxFreq = 0;
        Map<Character, Integer> charMap = new HashMap<>();

        for(int end =0; end < s.length(); end ++){
            char ch = s.charAt(end);
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1 );

            maxFreq = Math.max(maxFreq, charMap.get(ch));

            while(end - start + 1 - maxFreq > k){
                char sChar = s.charAt(start);
                charMap.put(sChar, charMap.get(sChar) - 1);
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
