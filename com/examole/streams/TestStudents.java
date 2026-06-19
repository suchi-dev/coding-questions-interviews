package com.examole.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStudents {
    public static void main(String[] args) {
        List<Student> studentList = Stream.of(
                new Student("Rita", 1, "Computer", "Bangalore", "Female", 25, 32),
                new Student("Gita", 2, "Electronics", "Mumbai", "Female", 26, 110),
        new Student("Daren", 3, "Chemical", "Pune", "Male", 31, 45),
        new Student("Roma", 4, "Computer", "Chennai", "Female", 26, 62),
        new Student("Sheetal", 5, "Electronics", "Mumbai", "Female", 24, 11),
        new Student("Sneha", 6, "Electonics", "Mumbai", "Female", 22, 35),
        new Student("Amar", 7, "Computer", "Bangalore", "Male", 27, 47)

        ).toList();

        List<Student> studentsIds = studentList.stream().filter(e -> e.getId() > 2 && e.getId() < 5).toList();
        System.out.println(studentsIds);

        List<Student> studemtsMumbai = studentList.stream().filter(e -> e.getCity().equals("Mumbai"))
                .sorted(Comparator.comparing(Student::getName))
                .toList();
        System.out.println(studemtsMumbai);

        List<Student> studentsBangalore = studentList.stream().filter(e -> e.getCity().equals("Bangalore"))
                .sorted(Comparator.comparing(Student::getName, Comparator.reverseOrder()))
                .toList();
        System.out.println(studentsBangalore);


        List<String> deptList = studentList.stream()
                .map(Student::getDept)
                .distinct()
                .toList();
        System.out.println(deptList);


        Map<String, List<Student>> deptWiseStudents = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDept));
        System.out.println(deptWiseStudents);

        Map<String, Long> deptWiseCount = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDept, Collectors.counting()));

        System.out.println(deptWiseCount);

        Map.Entry<String, Long> maxDeptWiseCount = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDept,
                        Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue())
                .get();
        System.out.println(maxDeptWiseCount);


        Map<String, Double> avgGenderAge = studentList.stream().collect(Collectors.groupingBy(Student::getGender,
                Collectors.averagingInt(Student::getAge)));

        System.out.println(avgGenderAge);

        Map<String, Optional<Student>> rankWiseStudents = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDept, Collectors.minBy(Comparator.comparing(Student::getRank))));

        System.out.println(rankWiseStudents);

        // to get student with 2nd highest rank

        Student student2ndHighestRank = studentList.stream()
                .sorted(Comparator.comparing(Student::getRank)).skip(1)
                .findAny().get();
        System.out.println(student2ndHighestRank);
        
        
        // to get 2nd lowest rank 
        Student student2ndLowestRank = studentList.stream()
                .sorted(Comparator.comparing(Student::getRank, Comparator.reverseOrder()))
                .skip(1)
                .findAny().get();
        System.out.println(student2ndLowestRank);


    }

}
