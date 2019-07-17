package com.vastika.training.java.jdbc.basics.Services.impl;

import com.vastika.training.java.jdbc.basics.Repository.CrudeRepository;
import com.vastika.training.java.jdbc.basics.Repository.impl.TeacherRepository;
import com.vastika.training.java.jdbc.basics.Services.BaseService;
import com.vastika.training.java.jdbc.basics.Teacher;

import java.util.List;
import java.util.Scanner;

public class TeacherService implements BaseService {
    public void displayMenu() {
        System.out.println("Please Select:");
        System.out.println("1. To list all the teachers:");
        System.out.println("2. To list teacher details:");
        System.out.println("3. To update teacher record");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        CrudeRepository<Teacher> repository = new TeacherRepository();

        if (choice == 1) {
            List<Teacher> teachers = repository.findAll();
            System.out.println(teachers);

        } else if (choice == 2) {
            System.out.println("Enter the teacher id:");
            int teacherid = scanner.nextInt();
            Teacher teacher2 = repository.findById(teacherid);
            System.out.println(teacher2);
        } else if (choice == 3) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the teacher id");
            int id = Integer.valueOf(sc.next());
            System.out.println("Enter the firstname");
            String firstname = sc.next();
            System.out.println("Enter the lastname");
            String lastname = sc.next();
            System.out.println("Enter the address");
            String address = sc.next();
            System.out.println("Enter the subject");
            String subject = sc.next();
            Teacher toupdate = new Teacher(id, firstname, lastname, address, subject);

            boolean update = repository.update(toupdate);

            if (update) {
                System.out.println("Success");

            } else {
                System.out.println("Failed");


            }
        }


    }

}

