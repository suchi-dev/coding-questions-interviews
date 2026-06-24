package com.examole.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "OUZODYXAZV";
        String t = "XYZ";
        String res = minWinSubstring(s, t);
        System.out.println("The min window substring is : "+res);

    }

    public static String  minWinSubstring(String s, String t) {
        if(t.isEmpty()) return "";

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            countT.put(ch, countT.getOrDefault(ch, 0 )+1);
        }

        int have = 0, need = countT.size();
        int resLen = Integer.MAX_VALUE;
        int [] res = { -1, -1};
         int l = 0;
         for(int r = 0; r < s.length(); r++){
             char c = s.charAt(r);
             window.put(c, window.getOrDefault(c, 0) + 1);

             if(countT.containsKey(c) && countT.get(c).equals(window.get(c))){
                 have++;
             }

             while(have == need){
                 if(r - l + 1 < resLen ){
                     resLen  = r - l + 1;
                     res[0] = l;
                     res[1] = r;
                 }
                 char leftChar = s.charAt(l);
                 window.put(leftChar, window.get(leftChar) - 1);

                 if(countT.containsKey(leftChar) && window.get(leftChar) <
                 countT.get(leftChar)){
                     have--;
                 }
                 l++;
             }

         }

        return  resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
