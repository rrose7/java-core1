package com.vastika.training.java.jdbc.basics;

import com.vastika.training.java.jdbc1.basics.CrudeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements CrudeRepository<Student> {
    public List<Student> findAll() {
        Connection connection = DbConnector.getConnection();
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from student");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                double gpa = rs.getDouble("gpa");

                Student student = new Student(id, firstName, lastName, gpa);

                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public Student findById(int userid) {
        Connection connection = DbConnector.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from student where id = " + userid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                double gpa = rs.getDouble("gpa");
                Student student = new Student(id, firstName,lastName, gpa);
                return student;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean update(Student student){
        Connection connection = DbConnector.getConnection();

        try{
            String sql1 = "Insert into student( id, firstname, lastname, gpa) values("+student.getId()+"','"+student.getFirstName()
                    + "','"+student.getLastName() + "',"+student.getGpa()+")";
            PreparedStatement ps = connection.prepareStatement(sql1);
            ps.executeUpdate();
            return true;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }


}

