package com.vastika.training.java.jdbc1.basics;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TeacherDriver {
    public static void main(String[] args) {
        String input = "yes";
        while (!"no".equals(input)) {
            System.out.println("Please Select:");
            System.out.println("1. To list all the teachers:");
            System.out.println("2. To list teacher details:");
            System.out.println("3. To update student record");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            TeacherRepository repository = new TeacherRepository();

            if (choice == 1) {
                List<Teacher> teachers = repository.getAllTeacher();
                System.out.println(teachers);

            } else if (choice == 2) {
                System.out.println("Enter the teacher id:");
                int teacherid = scanner.nextInt();
                Teacher teacher2 = repository.findTeacherById(teacherid);
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
                System.out.println("Enter the date of birth");
                String dateofbirth = sc.next();
                Teacher toupdate = new Teacher(id, firstname, lastname, address, dateofbirth);

                boolean update = repository.UpdateTeacher(toupdate);

                if (update) {
                    System.out.println("Success");

                } else {
                    System.out.println("Failed");


                }
            }

            System.out.println("Do you want to try again? (yes/no)");
            Scanner inputs = new Scanner(System.in);
            input = inputs.next();


        }

    }
}
