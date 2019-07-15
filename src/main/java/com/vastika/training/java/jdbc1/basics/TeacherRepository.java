package com.vastika.training.java.jdbc1.basics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeacherRepository {
    public List<Teacher> getAllTeacher() {
        Connection con = DbConnector.getConnection();
        List<Teacher> teachers = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("select * from teacher");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String address = rs.getString("address");
                String dateofbirth = rs.getString("dateofbirth");
                Teacher teacher = new Teacher(id, firstname, lastname, address, dateofbirth);
                teachers.add(teacher);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return teachers;
    }

    public Teacher findTeacherById(int userID) {
        Connection con = DbConnector.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("select * from teacher where id = " + userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String address = rs.getString("address");
                String dateofbirth = rs.getString("dateofbirth");

                return new Teacher(id, firstname, lastname, address, dateofbirth);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    public boolean UpdateTeacher(Teacher teacher) {
        Connection con = DbConnector.getConnection();
        try {
            String sql = "update teacher set firstName='" + teacher.getFirstname()
                    + "', lastName='" + teacher.getLastname() + "', address='" + teacher.getAddress() + "', dateofbirth ='" + teacher.getDateofbirth() + "where id=" + teacher.getId();
            PreparedStatement ps = con.prepareStatement(sql);
            int rs = ps.executeUpdate();
            return rs > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}