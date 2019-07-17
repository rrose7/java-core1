package com.vastika.training.java.jdbc.basics.Services.impl;

import com.vastika.training.java.jdbc.basics.Repository.impl.StudentRepository;
import com.vastika.training.java.jdbc.basics.Services.BaseService;
import com.vastika.training.java.jdbc.basics.Student;

import java.util.List;
import java.util.Scanner;

public class StudentService implements BaseService {
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select");
        System.out.println("1. To list all the students");
        System.out.println("2. To list all details of the students");
        System.out.println("3. To insert the students");
        int choice = scanner.nextInt();
        StudentRepository repository = new StudentRepository();
        if (choice == 1) {
            List<Student> students = repository.findAll();
            System.out.println(students);
        } else if (choice == 2) {
            System.out.println("Enter the student ID");
            int studentid = scanner.nextInt();
            Student studentid2 = repository.findById(studentid);
            System.out.println(studentid2);
        } else if (choice == 3) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter student id: ");
            int id = Integer.valueOf(sc.next());
            System.out.print("Enter student first name: ");
            String firstName = sc.next();
            System.out.print("Enter student last name: ");
            String lastName = sc.next();
            System.out.print("Enter student gpa: ");
            double gpa = Double.valueOf(sc.next());
            Student toUpdate = new Student(id, firstName, lastName, gpa);
            boolean updated = repository.update(toUpdate);
            System.out.println("Success!");
        } else {
            System.out.println("Failed!");
        }


    }

}




