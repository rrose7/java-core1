package com.vastika.training.java.jdbc.basics.Services.impl;

import com.vastika.training.java.jdbc.basics.Models.Staff;
import com.vastika.training.java.jdbc.basics.Repository.CrudeRepository;
import com.vastika.training.java.jdbc.basics.Repository.impl.StaffRepository;
import com.vastika.training.java.jdbc.basics.Services.BaseService;


import java.util.List;
import java.util.Scanner;

public class StaffService implements BaseService {

    private CrudeRepository<Staff> repository;

    public StaffService() {
        this.repository = new StaffRepository();
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select");
        System.out.println("1. To list all the staff");
        System.out.println("2. To list all details of the staff");
        System.out.println("3. To insert the staff");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                List<Staff> staffs = repository.findAll();
                System.out.println(staffs);
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
        Scanner scanner = new Scanner((System.in));
        System.out.println("Enter the staff ID");
        int staffid = scanner.nextInt();
        Staff staffid2 = repository.findById(staffid);
        System.out.println(staffid2);
    }

    public void UpdateInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter staff id: ");
        int id = Integer.valueOf(sc.next());
        System.out.print("Enter staff first name: ");
        String firstName = sc.next();
        System.out.print("Enter staff last name: ");
        String lastName = sc.next();
        System.out.print("Enter department: ");
        String department = String.valueOf(sc.next());
        Staff toUpdate = new Staff(id, firstName, lastName, department);
        boolean updated = repository.update(toUpdate);
        if (updated) {
            System.out.println("Success!");
        } else {
            System.out.println("Failed!");
        }
    }


}




