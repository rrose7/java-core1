package com.vastika.training.java.jdbc1.basics;

import java.util.Date;

public class Teacher {
    private int id;
    private String firstname;
    private String lastname;
    private String address;
    private String dateofbirth;

    public Teacher(int id, String firstname, String lastname, String address, String dateofbirth) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.dateofbirth = dateofbirth;
    }
    public int getId (){return id;}
    public String getFirstname(){return firstname;}
    public String getLastname(){return lastname;}
    public String getAddress(){return address;}

    public String getDateofbirth() {
        return dateofbirth;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", dateofbirth=" + dateofbirth +
                '}';
    }
}


