package com.examole.streams;

import java.util.Objects;

public class Student {

    private String name;
    private int id;
    private String dept;
    private String city;
    private String gender;
    private int age;
    private int rank;



    public Student(String name, int id, String dept, String city, String gender,
                   int age, int rank) {
        this.name = name;
        this.id = id;
        this.dept = dept;
        this.city = city;
        this.gender = gender;
        this.age = age;
        this.rank = rank;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name) && Objects.equals(dept, student.dept) && Objects.equals(city, student.city) && Objects.equals(gender, student.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, dept, city, gender);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", dept='" + dept + '\'' +
                ", city='" + city + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", rank=" + rank +
                '}';
    }
}
