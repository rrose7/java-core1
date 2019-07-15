package com.vastika.training.java.jdbc.basics;

import java.util.List;

public class DriverProgram {
    public static void main(String[] args) {
        StudentRepository repository =  new StudentRepository();

        List<Student> students = repository.getAllstudent();
        System.out.println(students);

    }
}
