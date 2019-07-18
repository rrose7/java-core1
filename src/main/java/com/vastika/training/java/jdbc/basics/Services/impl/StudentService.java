package com.vastika.training.java.jdbc.basics.Services.impl;

import com.vastika.training.java.jdbc.basics.Repository.CrudeRepository;
import com.vastika.training.java.jdbc.basics.Repository.impl.StudentRepository;
import com.vastika.training.java.jdbc.basics.Services.BaseService;
import com.vastika.training.java.jdbc.basics.Student;

import java.util.List;
import java.util.Scanner;

public class StudentService implements BaseService {

    private CrudeRepository<Student> repository;

    public StudentService(){
        this.repository = new StudentRepository();
    }


    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select");
        System.out.println("1. To list all the students");
        System.out.println("2. To list all details of the students");
        System.out.println("3. To insert the students");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                List<Student> students = repository.findAll();
                System.out.println(students);
                break;
            case 2:
                printInfo();
                break;
            case 3:
                UpdateInfo();
                break;
            default:
                System.out.println("Invalid Input");
        }
    }

    public void printInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the student ID");
        int studentid = scanner.nextInt();
        Student studentid2 = repository.findById(studentid);
        System.out.println(studentid2);
    }

    public void UpdateInfo() {
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

        if (updated) {
            System.out.println("Success!");
        } else {
            System.out.println("Failed!");
        }
    }
}








