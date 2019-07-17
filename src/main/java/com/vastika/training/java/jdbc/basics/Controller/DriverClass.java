package com.vastika.training.java.jdbc.basics.Controller;


import com.vastika.training.java.jdbc.basics.Services.BaseService;
import com.vastika.training.java.jdbc.basics.Services.impl.StudentService;
import com.vastika.training.java.jdbc.basics.Services.impl.TeacherService;

import java.util.Scanner;

public class DriverClass {
    public static void main(String[] args) {
        BaseService StudentService = new StudentService();
        BaseService TeacherService = new TeacherService();
        String input = "yes";
        while (!"no".equals(input)) {
            System.out.println("Select");
            System.out.println("1. For Teacher");
            System.out.println("2 For Student");
            Scanner scanner = new Scanner(System.in);
            int mainMenu = scanner.nextInt();
            if (mainMenu == 1) {
                TeacherService.displayMenu();
            } else if (mainMenu == 2) {
                StudentService.displayMenu();
            }
            System.out.println("Do you want to continue? (yes/no)");
            Scanner inputscanner = new Scanner(System.in);
            input = inputscanner.next();
        }
    }
}