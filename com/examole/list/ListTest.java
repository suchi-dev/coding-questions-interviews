package com.examole.list;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ListTest {
    public static void main(String[] args) {

        Collection<Integer> numbers = IntStream.range(0,10)
                .boxed().collect(Collectors.toSet());
        List<Integer> listNumbers = new ArrayList<>(numbers);
        ListIterator<Integer> lt = listNumbers.listIterator(listNumbers.size());
        List<Integer> result = new ArrayList<>(listNumbers.size());
        while(lt.hasPrevious()){
            result.add(lt.previous());
        }
        System.out.println("The result is : "+result);

        // search for a string
        List<String> stringList = LongStream.range(0,16)
                .boxed()
                .map(Long::toHexString)
                .collect(Collectors.toList());
        Set<String> searchString = new HashSet<>(Arrays.asList("a", "c", "9"));

        List<String> matchedStrings = stringList.stream().filter(searchString::contains)
                .collect(Collectors.toList());
        System.out.println("The matched strings are : "+matchedStrings);

        // using iterator

        List<String> resultStr = new ArrayList<>();
        Iterator<String> itr = stringList.iterator();
        while(itr.hasNext()) {
            String s = itr.next();
            if(searchString.contains(s)){
                resultStr.add(s);
            }
        }

        System.out.println("The result str is : "+resultStr);

        List<String> copy = new ArrayList<>(stringList);
        Collections.sort(copy);
        int index = Collections.binarySearch(copy, "f");
        System.out.println("The search index is : "+index);
        copy.addFirst("add");
        copy.addLast("second");
        System.out.println(copy);



    }
}
