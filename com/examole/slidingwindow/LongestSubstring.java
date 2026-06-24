package com.examole.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    public  static int calculateMaxSubstring(String s) {
        int maxLength = 0;
        int start = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        for(int end = 0; end < s.length(); end++){
            char ch = s.charAt(end);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            while(freqMap.get(ch) > 1){
                char startCh = s.charAt(start);
                freqMap.put(startCh, freqMap.get(startCh) - 1);
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return  maxLength;

    }

    public static void main(String[] args) {
        String s = "substring";
        int res = calculateMaxSubstring(s);
        System.out.println("The longest substring length without repeating characters : " +res);
    }
}
