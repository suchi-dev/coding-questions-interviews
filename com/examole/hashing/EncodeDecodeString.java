package com.examole.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeString {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2="World";
        List<String> strList = Arrays.asList(s1, s2);
        String encodedString = encodeString(strList);
        List<String> decodedString = decode(encodedString);
        System.out.println("The encoded string is : "+encodedString);
       for(String s : decodedString){
           System.out.println("The decoded string is : "+s);
       }

    }

    public static  String encodeString(List<String> strs) {
        if(strs.isEmpty())  return "";

        List<Integer> sizes = new ArrayList<>();
        for(String s : strs){
            sizes.add(s.length());
        }
        StringBuffer res = new StringBuffer();
        for(Integer size : sizes){
            res.append(size).append(',');
        }
        res.append('#');
        for(String s : strs){
            res.append(s);
        }

        return res.toString();



    }

    public  static List<String> decode (String s){
        List<String> res = new ArrayList<>();
        if(s.isEmpty()) return  new ArrayList<>();

        List<Integer> sizes = new ArrayList<>();
        int i =0;
        while(s.charAt(i) != '#'){
            StringBuffer curr = new StringBuffer();
            while(s.charAt(i) != ','){
                curr.append(s.charAt(i));
                i++;
            }
            sizes.add(Integer.parseInt(curr.toString()));
            i++;
        }
        i++;
        for(int size : sizes){
            res.add(s.substring(i, i+size));
            i+=size;
        }

        return  res;




    }

}
