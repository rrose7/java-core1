package com.vastika.training.java.jdbc.basics;

public class Teacher {
    private int id;
    private String firstname;
    private String lastname;
    private String address;
    private String subject;

    public Teacher(int id, String firstname, String lastname, String address, String subject) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.subject = subject;
    }
    public int getId (){return id;}
    public String getFirstname(){return firstname;}
    public String getLastname(){return lastname;}
    public String getAddress(){return address;}
    public String getSubject(){return address;}



    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", subject=" + subject +
                '}';
    }
}


