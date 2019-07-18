package com.vastika.training.java.jdbc.basics.Repository.impl;


import com.vastika.training.java.jdbc.basics.DbConnector;
import com.vastika.training.java.jdbc.basics.Repository.CrudeRepository;
import com.vastika.training.java.jdbc.basics.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepository implements CrudeRepository<Teacher> {
    public List<Teacher> findAll() {
        Connection connection = DbConnector.getConnection();
        List<Teacher> teachers = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from teacher");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String address = rs.getString("address");
                String subject = rs.getString("subject");

                Teacher teacher = new Teacher(id, firstName, lastName, address, subject);

                teachers.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return teachers;
    }

    public Teacher findById(int userid) {
        Connection connection = DbConnector.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from teacher where id = ?");
            ps.setInt(1, userid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String address = rs.getString("address");
                String subject = rs.getString("subject");
                Teacher teacher = new Teacher(id, firstName, lastName, address, subject);
                return teacher;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean update(Teacher teacher){
        Connection connection = DbConnector.getConnection();

        try{
            String sql1 = "Insert into teacher( id, firstname, lastname, address, subject) values(?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql1);
            ps.setInt(1, teacher.getId());
            ps.setString(2,teacher.getFirstname());
            ps.setString(3,teacher.getLastname());
            ps.setString(4,teacher.getAddress());
            ps.executeUpdate();

            return true;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }


}


